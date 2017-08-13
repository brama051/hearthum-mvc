package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.model.User;
import com.vabram.hearthum.repository.RecordingRepository;
import com.vabram.hearthum.service.RecordingService;
import org.joda.time.LocalDateTime;
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
    public Page<Recording> findAll(User user, Pageable page) {
        if (user == null) {
            return recordingRepository.findAll(page);
        } else {
            return recordingRepository.findAllByUser(user, page);
        }
    }

    @Override
    public Page<Recording> findAllByPatientName(User user, String patientName, Pageable page) {
        return null;
    }

    @Override
    public Page<Recording> findAllByPatientEmail(User user, String patientName, Pageable page) {
        return null;
    }

    @Override
    public Page<Recording> findAllByRecordingDateTimeBetween(User user, LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page) {
        return null;
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
