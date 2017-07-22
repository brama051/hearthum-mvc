package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.repository.RecordingRepository;
import com.vabram.hearthum.service.RecordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Created by brama051 on 1.3.2017..
 */
@Service
public class RecordingServiceImpl implements RecordingService {

    @Autowired
    private RecordingRepository recordingRepository;

    @Override
    public Page<Recording> findAll(Pageable pageable) {
        return recordingRepository.findAll(pageable);
    }

    @Override
    public Recording save(Recording recording) {
        return recordingRepository.save(recording);
    }

    @Override
    public Recording findOne(Long id) {
        return recordingRepository.findOne(id);
    }
}
