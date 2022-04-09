package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(@Param("id") Integer id);

    Employee findByEmail(@Param("email") String email);

    List<Employee> findByFirstNameAndLastNameIgnoreCaseContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Employee> findByFirstNameContaining(@Param("firstName") String firstName);

    List<Employee> findByLastNameContaining(@Param("lastName") String latName);

    List<Employee> findByActive(@Param("active") Boolean active);

}
