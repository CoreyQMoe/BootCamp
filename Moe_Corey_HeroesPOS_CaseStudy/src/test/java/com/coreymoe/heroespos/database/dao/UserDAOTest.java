package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {
        User user = User.builder().firstName("fName").lastName("lName").email("test@test.test").address("Address").city("City").state("St").phoneNumber("1231231234").zipCode(54321).active(1).created(LocalDate.now()).build();
        userDAO.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getUserTest() {
        Integer i = 1;
        User user = userDAO.findUserById(i);
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getUserListTest() {
        List<User> userList = userDAO.findAllUsers();
        Assertions.assertThat(userList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userDAO.findUserById(1);
        user.setFirstName("NewName");

        Assertions.assertThat(userDAO.findUserById(1).getFirstName()).isEqualTo(user.getFirstName());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest() {
        User user = userDAO.findUserById(1);
        userDAO.delete(user);
        User test = null;
        if(userDAO.findUserById(user.getId()) != null) {
            test = userDAO.findUserById(user.getId());
        }

        Assertions.assertThat(test).isNull();
    }

    @ParameterizedTest
    @Order(6)
    @ValueSource(longs = {1,2,3,4,5})
    void test_long_array(long arg) {
        User user = User.builder().firstName("Name"+arg).lastName("lName").email("test@test.test").address("Address").city("City").state("St").phoneNumber("1231231234").zipCode(54321).active(1).created(LocalDate.now()).build();

        userDAO.save(user);

        Assertions.assertThat(arg == user.getId());
    }
}
