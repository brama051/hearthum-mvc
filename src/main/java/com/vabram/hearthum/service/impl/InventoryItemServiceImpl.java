package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.InventoryItem;
import com.vabram.hearthum.repository.InventoryItemRepository;
import com.vabram.hearthum.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brama051 on 1.3.2017..
 */
@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Override
    public List<InventoryItem> findAll() {
        return inventoryItemRepository.findAll();
    }

    @Override
    public void save(InventoryItem inventoryItem){ inventoryItemRepository.save(inventoryItem); }
}
