package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.model.User;
import org.joda.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by brama051 on 23/06/2017.
 */
//@CrossOrigin
public interface RecordingRepository extends PagingAndSortingRepository<Recording, Long> {

    Page<Recording> findAllByUser(User user, Pageable page);

    Page<Recording> findAllByUserAndPatientName(User user, String patientName, Pageable page);

    Page<Recording> findAllByPatientName(String patientName, Pageable page);

    Page<Recording> findAllByUserAndPatientEmail(User user, String patientEmail, Pageable page);

    Page<Recording> findAllByPatientEmail(String patientEmail, Pageable page);

    Page<Recording> findAllByRecordingDateTimeBetween(LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page);

    Page<Recording> findAllByUserAndRecordingDateTimeBetween(User user, LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page);
}
