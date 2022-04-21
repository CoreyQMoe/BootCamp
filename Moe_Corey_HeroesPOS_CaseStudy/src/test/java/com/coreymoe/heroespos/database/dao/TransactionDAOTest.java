package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Item;
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
public class TransactionDAOTest {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveTransactionTest() {
        User user = User.builder().firstName("fName").lastName("lName").email("test@test.test").address("Address").city("City").state("St").phoneNumber("1231231234").zipCode(54321).active(1).created(LocalDate.now()).build();
        userDAO.save(user);
        Transaction transaction = Transaction.builder().user(user).total(9.99D).status("PENDING").created(LocalDate.now()).build();
        transactionDAO.save(transaction);

        Assertions.assertThat(transaction.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getTransactionTest() {
        Integer i = 1;
        Transaction transaction = transactionDAO.findTransactionById(i);
        Assertions.assertThat(transaction.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getTransactionListTest() {
        List<Transaction> transactionList = transactionDAO.findAllTransactions();
        Assertions.assertThat(transactionList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateTransactionTest() {
        Transaction transaction = transactionDAO.findTransactionById(1);
        transaction.setTotal(99.99D);

        Assertions.assertThat(transactionDAO.findTransactionById(1).getTotal()).isEqualTo(transaction.getTotal());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteTransactionTest() {
        Transaction transaction = transactionDAO.findTransactionById(1);
        transactionDAO.delete(transaction);
        Transaction test = null;
        if(transactionDAO.findTransactionById(transaction.getId()) != null) {
            test = transactionDAO.findTransactionById(transaction.getId());
        }

        Assertions.assertThat(test).isNull();
    }

    @ParameterizedTest
    @Order(6)
    @ValueSource(longs = {1,2,3,4,5})
    void test_long_array(long arg) {
        User user = User.builder().firstName("fName").lastName("lName").email("test@test.test").address("Address").city("City").state("St").phoneNumber("1231231234").zipCode(54321).active(1).created(LocalDate.now()).build();
        userDAO.save(user);
        Transaction transaction = Transaction.builder().user(user).total(9.99D).status("PENDING").created(LocalDate.now()).build();

        transactionDAO.save(transaction);

        Assertions.assertThat(arg == transaction.getId());
    }
}
