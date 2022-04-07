package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Employee;
import com.coreymoe.heroespos.database.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(@Param("id") Integer id);

    Employee findEmployeeByEmail(@Param("email") String email);

    List<Employee> findEmployeeByFirstNameAndLastNameIgnoreCaseContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Employee> findEmployeeByFirstNameContaining(@Param("firstName") String firstName);

    List<Employee> findEmployeeByLastNameContaining(@Param("lastName") String latName);

    List<Employee> findEmployeeByActive(@Param("active") Boolean active);

    @Query("SELECT FROM Employees e JOIN Passwords p WHERE :e.id = ")
    Password findEmployeePasswordById(@Param("id") Integer id);
}
