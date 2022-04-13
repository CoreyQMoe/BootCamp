package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.User;
import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionDAO  extends JpaRepository<Transaction, Long> {

    Transaction findById(@Param("id") Integer id);

    List<Transaction> findByUser(@Param("user") User user);

    List<Transaction> findByCreated(@Param("created") Date created);

    @Query(value = "SELECT * FROM transactiondetails td LEFT JOIN FETCH transactions t WHERE td.transaction_id = t.id AND t.id = :id", nativeQuery = true)
    List<TransactionDetail> findDetailsByTransactionId(@Param("id") Integer id);

    @Query(value = "SELECT * FROM Transactions", nativeQuery = true)
    List<Transaction> findAllTransactions();
}
