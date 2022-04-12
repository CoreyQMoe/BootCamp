package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.database.entity.UserRole;

import java.util.List;

@Repository
public interface UserRolesDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(@Param("userId") Integer userId);
}
