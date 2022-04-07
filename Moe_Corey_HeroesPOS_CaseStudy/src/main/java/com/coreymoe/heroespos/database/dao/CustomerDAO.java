package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    List<Customer> findByEmail(@Param("email") String email);

    List<Customer> findByLastNameIgnoreCaseContaining(@Param("lastName") String lastName);

    List<Customer> findByFirstNameAndLastNameIgnoreCaseContaining(@Param("firstName") String firstName, @Param("lastName") String lastname);

    List<Customer> findByPhoneNumber(@Param("phoneNumber") Integer phoneNumber);

    Customer findById(@Param("id") Integer id);

    List<Customer> findCustomerByActive(@Param("active") Boolean active);
}
