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

    Item findItemById(@Param("id") Integer id);

    Item findItemByName(@Param("name") String name);

    List<Item> findItemByDescriptionIgnoreCaseContaining(@Param("description") String description);

    List<Item> findItemByPrice(@Param("price") Double price);

    List<Item> findItemByCost(@Param("cost") Double cost);

    List<Item> findItemByActive(@Param("active") Boolean active);

    List<Item> findItemByDepartment(@Param("department") Department department);

    List<Item> findItemByVendor(@Param("vendor") Vendor vendor);
}
