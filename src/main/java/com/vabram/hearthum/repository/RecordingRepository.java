package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Recording;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by brama051 on 23/06/2017.
 */
//@CrossOrigin
public interface RecordingRepository extends PagingAndSortingRepository<Recording, Long> {

    List<Recording> findAllByPatientName(String patientName);

    List<Recording> findAllByPatientEmail(String patientEmail);


}
