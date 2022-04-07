package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDAO  extends JpaRepository<Department, Long> {

    Department findDepartmentById(@Param("id") Integer id);

    Department findDepartmentByName(@Param("name") String name);
}
