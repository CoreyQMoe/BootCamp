package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailDAO  extends JpaRepository<TransactionDetail, Long> {

    List<TransactionDetail> findTransactionDetailsByTransactionId(@Param("transaction_id") Integer transaction_id);

    TransactionDetail findTransactionDetailByTransactionIdAndItemId(@Param("transaction_id") Integer transaction_id, @Param("item_id") Integer item_id);

    //select td.product_id, p.name, count(*) as cnt from transaction_details td, items i where td.product_id = i.idgroup by product_id
}
