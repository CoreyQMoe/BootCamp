package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Transaction;
import com.coreymoe.heroespos.database.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailDAO  extends JpaRepository<TransactionDetail, Long> {

    TransactionDetail findById(@Param("id") Integer id);

    //select ts.product_id, p.name, count(*) as cnt from transaction_details td, items i where td.product_id = i.idgroup by product_id
}
