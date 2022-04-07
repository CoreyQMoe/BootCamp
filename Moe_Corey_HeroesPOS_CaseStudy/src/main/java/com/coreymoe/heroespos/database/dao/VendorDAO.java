package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorDAO  extends JpaRepository<Vendor, Long> {

    Vendor findById(@Param("id") Integer id);

    Vendor findByName(@Param("name") String name);

    List<Vendor> findByActive(@Param("active") Boolean active);
}
