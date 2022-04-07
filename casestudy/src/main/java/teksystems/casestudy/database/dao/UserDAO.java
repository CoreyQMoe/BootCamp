package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.User;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    //there are 3 ways to execute query
    //1) @Query with JPA/JQL/HQL
    //2) @Query with nativeQuery
    //3) using a function for spring to do the query with no query


    //Native query in sql language
    //@Query(value="select * from users where email = :email", nativeQuery = true)
    //JPA query in HQL
    //@Query("select u from users u where u.email = :email")
    User findByEmail(@Param("email") String email);

    List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName") String firstName);

    List<User> findByLastName(@Param("lastName") String lastName);

    List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    public User findById(@Param("id") Integer id);
}

