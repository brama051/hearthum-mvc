package com.vabram.hearthum.service;

import com.vabram.hearthum.model.InventoryItem;

import java.util.List;

/**
 * Created by brama051 on 1.3.2017..
 */
public interface InventoryItemService {
    List<InventoryItem> findAll();

    void save(InventoryItem inventoryItem);
}


