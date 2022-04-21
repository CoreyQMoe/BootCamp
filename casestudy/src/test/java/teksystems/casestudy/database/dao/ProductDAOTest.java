package teksystems.casestudy.database.dao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    @Autowired
    private PrductDAO productDAO;

    @Test
    @Order(1)
    @Rollback(value = false)
    pubic void create() {

    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}
