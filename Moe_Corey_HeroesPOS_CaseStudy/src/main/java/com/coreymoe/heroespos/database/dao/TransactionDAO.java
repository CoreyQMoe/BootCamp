package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO  extends JpaRepository<Transaction, Long> {

    Transaction findTransactionById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM transactions t JOIN (SELECT * FROM users WHERE upper(first_name) LIKE upper(:firstName)) AS u ON t.user_id = u.id;", nativeQuery = true)
    List<Transaction> findByUserFirstNameIgnoreCase(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM transactions t JOIN (SELECT * FROM users WHERE upper(last_name) LIKE upper(:lastName)) AS u ON t.user_id = u.id;", nativeQuery = true)
    List<Transaction> findByUserLastNameIgnoreCase(@Param("lastName") String lastName);

    List<Transaction> findByStatus(@Param("status") String status);

    List<Transaction> findByTotal(@Param("total") Double total);

    @Query(value = "SELECT * FROM transactions WHERE created = :created", nativeQuery = true)
    List<Transaction> findByCreated(@Param("created") String created);

    @Query(value = "SELECT * FROM transactions", nativeQuery = true)
    List<Transaction> findAllTransactions();

    @Query(value = "SELECT FROM Transaction WHERE status = 'PENDING' AND userId = :userId")
    Transaction findPendingTransactionByUserId(@Param("userId") Integer userId);
}
