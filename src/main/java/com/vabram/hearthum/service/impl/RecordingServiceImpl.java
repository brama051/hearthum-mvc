package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.model.User;
import com.vabram.hearthum.repository.RecordingRepository;
import com.vabram.hearthum.service.RecordingService;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
        if (user == null) {
            return recordingRepository.findAllByPatientNameContainingIgnoreCase(patientName, page);
        } else {
            return recordingRepository.findAllByUserAndPatientNameContainingIgnoreCase(user, patientName, page);
        }
    }

    @Override
    public Page<Recording> findAllByPatientEmail(User user, String patientName, Pageable page) {
        if (user == null) {
            return recordingRepository.findAllByPatientEmailContainingIgnoreCase(patientName, page);
        } else {
            return recordingRepository.findAllByUserAndPatientEmailContainingIgnoreCase(user, patientName, page);
        }
    }

    @Override
    public Page<Recording> findAllByRecordingDateTimeBetween(User user, String filter, Pageable page) {
        //filter.indexOf('~');
        String start = filter.substring(0, filter.indexOf('~'));
        String end = filter.substring(filter.indexOf('~') + 1, filter.length());
        DateTimeFormatter fmt = DateTimeFormat.forPattern( "yyyy-MM-dd'T'HH:mm");

        LocalDateTime recordingDateTimeStart = fmt.parseLocalDateTime(start);
        LocalDateTime recordingDateTimeEnd = fmt.parseLocalDateTime(end);

        if (user == null) {
            return recordingRepository.findAllByRecordingDateTimeBetween(recordingDateTimeStart, recordingDateTimeEnd, page);
        } else {
            return recordingRepository.findAllByUserAndRecordingDateTimeBetween(user, recordingDateTimeStart, recordingDateTimeEnd, page);
        }
    }

    @Override
    public Page<Recording> findAllAnalyzedByPatientName(User user, String patientName, Pageable page) {

        if (user == null) {
            return recordingRepository.findDistinctByPatientNameContainingIgnoreCaseAndAnalysisListIsNotNull(patientName, page);
        } else {
            return recordingRepository.findDistinctByUserAndPatientNameContainingIgnoreCaseAndAnalysisListIsNotNull(user, patientName, page);
        }
    }

    @Override
    public Page<Recording> findAllAnalyzedByPatientEmail(User user, String patientName, Pageable page) {
        if (user == null) {
            return recordingRepository.findDistinctByPatientEmailContainingIgnoreCaseAndAnalysisListIsNotNull(patientName, page);
        } else {
            return recordingRepository.findDistinctByUserAndPatientEmailContainingIgnoreCaseAndAnalysisListIsNotNull(user, patientName, page);
        }
    }

    @Override
    public Page<Recording> findAllAnalyzedByRecordingDateTimeBetween(User user, String filter, Pageable page) {
        String start = filter.substring(0, filter.indexOf('~'));
        String end = filter.substring(filter.indexOf('~') + 1, filter.length());
        DateTimeFormatter fmt = DateTimeFormat.forPattern( "yyyy-MM-dd'T'HH:mm");

        LocalDateTime recordingDateTimeStart = fmt.parseLocalDateTime(start);
        LocalDateTime recordingDateTimeEnd = fmt.parseLocalDateTime(end);

        if (user == null) {
            return recordingRepository.findDistinctByRecordingDateTimeBetweenAndAnalysisListIsNotNull(recordingDateTimeStart, recordingDateTimeEnd, page);
        } else {
            return recordingRepository.findDistinctByUserAndRecordingDateTimeBetweenAndAnalysisListIsNotNull(user, recordingDateTimeStart, recordingDateTimeEnd, page);
        }
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
