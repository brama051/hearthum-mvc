package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.model.User;
import org.joda.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by brama051 on 23/06/2017.
 */
@CrossOrigin
public interface RecordingRepository extends PagingAndSortingRepository<Recording, Long> {

    Page<Recording> findAllByUser(User user, Pageable page);

    Page<Recording> findAllByUserAndPatientNameContainingIgnoreCase(User user, String patientName, Pageable page);

    Page<Recording> findAllByPatientNameContainingIgnoreCase(String patientName, Pageable page);

    Page<Recording> findAllByUserAndPatientEmailContainingIgnoreCase(User user, String patientEmail, Pageable page);

    Page<Recording> findAllByPatientEmailContainingIgnoreCase(String patientEmail, Pageable page);

    Page<Recording> findAllByRecordingDateTimeBetween(LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page);

    Page<Recording> findAllByUserAndRecordingDateTimeBetween(User user, LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page);

    // -- analyzed

    Page<Recording> findDistinctByUserAndPatientNameContainingIgnoreCaseAndAnalysisListIsNotNull(User user, String patientName, Pageable page);

    Page<Recording> findDistinctByPatientNameContainingIgnoreCaseAndAnalysisListIsNotNull(String patientName, Pageable page);

    Page<Recording> findDistinctByUserAndPatientEmailContainingIgnoreCaseAndAnalysisListIsNotNull(User user, String patientEmail, Pageable page);

    Page<Recording> findDistinctByPatientEmailContainingIgnoreCaseAndAnalysisListIsNotNull(String patientEmail, Pageable page);

    Page<Recording> findDistinctByRecordingDateTimeBetweenAndAnalysisListIsNotNull(LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page);

    Page<Recording> findDistinctByUserAndRecordingDateTimeBetweenAndAnalysisListIsNotNull(User user, LocalDateTime recordingDateTimeStart, LocalDateTime recordingDateTimeEnd, Pageable page);

}
