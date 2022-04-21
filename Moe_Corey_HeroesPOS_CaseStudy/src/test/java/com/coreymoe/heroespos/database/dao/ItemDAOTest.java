package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Item;
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
public class ItemDAOTest {

    @Autowired
    private ItemDAO itemDAO;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItemTest() {
        Item item = Item.builder().name("name").description("description").price(9.99D).active(1).created(LocalDate.now()).build();
        itemDAO.save(item);

        Assertions.assertThat(item.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getItemTest() {
        Item item = itemDAO.findItemById(1);
        Assertions.assertThat(item.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getItemListTest() {
        List<Item> itemList = itemDAO.findAllItems();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateItemTest() {
        Item item = itemDAO.findItemById(1);
        item.setName("NewName");

        Assertions.assertThat(itemDAO.findItemById(1).getName()).isEqualTo(item.getName());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteItemTest() {
        Item item = itemDAO.findItemById(1);
        itemDAO.delete(item);
        Item test = null;
        if(itemDAO.findItemById(item.getId()) != null) {
            test = itemDAO.findItemById(item.getId());
        }

        Assertions.assertThat(test).isNull();
    }

    @ParameterizedTest
    @Order(6)
    @ValueSource(longs = {1,2,3,4,5})
    void test_long_array(long arg) {
        Item item = Item.builder().name("name").description("description").price(9.99D).active(1).created(LocalDate.now()).build();

        itemDAO.save(item);

        Assertions.assertThat(arg == item.getId());
    }
}
