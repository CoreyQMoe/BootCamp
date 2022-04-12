package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(@Param("userId") Integer userId);
}
