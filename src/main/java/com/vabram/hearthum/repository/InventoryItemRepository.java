package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by brama051 on 1.3.2017..
 */
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}
