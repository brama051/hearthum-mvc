package com.vabram.hearthum.service;

import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.model.User;
import org.joda.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by brama051 on 1.3.2017..
 */
public interface RecordingService {

    /**
     *
     * @param user if user is provided (not null), method will filter by user also
     * @param page
     * @return
     */
    Page<Recording> findAll(User user, Pageable page);

    /**
     *
     * @param user if user is provided (not null), method will filter by user also
     * @param page
     * @return
     */
    Page<Recording> findAllByPatientName(User user, String patientName, Pageable page);

    /**
     *
     * @param user if user is provided (not null), method will filter by user also
     * @param page
     * @return
     */
    Page<Recording> findAllByPatientEmail(User user, String patientName, Pageable page);

    /**
     *
     * @param user if user is provided (not null), method will filter by user also
     * @param page
     * @return
     */
    Page<Recording> findAllByRecordingDateTimeBetween(User user, LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page);

    Recording save(Recording recording);

    Recording findOne(Long id);

}


