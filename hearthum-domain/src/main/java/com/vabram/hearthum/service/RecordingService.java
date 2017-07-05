package com.vabram.hearthum.service;

import com.vabram.hearthum.model.InventoryItem;
import com.vabram.hearthum.model.Recording;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by brama051 on 1.3.2017..
 */
public interface RecordingService {

    Page<Recording> findAll(Pageable pageable);

    Recording save(Recording recording);

    Recording findOne(Long id);
}


