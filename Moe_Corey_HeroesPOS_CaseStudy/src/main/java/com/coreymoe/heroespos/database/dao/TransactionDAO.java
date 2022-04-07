package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Customer;
import com.coreymoe.heroespos.database.entity.Employee;
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

    List<Transaction> findByCustomer(@Param("customer") Customer customer);

    List<Transaction> findByEmployee(@Param("employee") Employee employee);

    List<Transaction> findByCreated(@Param("created") Date created);

    @Query(value = "SELECT * FROM transactiondetails td LEFT JOIN FETCH transactions t WHERE td.transaction_id = t.id AND t.id = :id", nativeQuery = true)
    List<TransactionDetail> findDetailsByTransactionId(@Param("id") Integer id);
}
