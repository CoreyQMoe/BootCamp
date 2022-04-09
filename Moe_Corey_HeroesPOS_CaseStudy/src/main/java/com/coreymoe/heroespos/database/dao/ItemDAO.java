package com.coreymoe.heroespos.database.dao;

import com.coreymoe.heroespos.database.entity.Department;
import com.coreymoe.heroespos.database.entity.Item;
import com.coreymoe.heroespos.database.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO  extends JpaRepository<Item, Long> {

    Item findById(@Param("id") Integer id);

    Item findByName(@Param("name") String name);

    List<Item> findByDescriptionIgnoreCaseContaining(@Param("description") String description);

    List<Item> findByPrice(@Param("price") Double price);

    List<Item> findByCost(@Param("cost") Double cost);

    List<Item> findByActive(@Param("active") Boolean active);

    List<Item> findByDepartment(@Param("department") Department department);

    List<Item> findByVendor(@Param("vendor") Vendor vendor);
}
