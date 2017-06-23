package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Recording;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by brama051 on 23/06/2017.
 */
@RepositoryRestResource(collectionResourceRel = "recordings", path = "recordings")
public interface RecordingRepository extends PagingAndSortingRepository<Recording, Long> {

    /*
    * How to protect certain methods: https://stackoverflow.com/questions/29169717/how-to-prevent-some-http-methods-from-being-exported-from-my-mongorepository
    * */

    List<Recording> findAllByPatientName(@Param("patientName") String patientName);

    List<Recording> findAllByPatientEmail(@Param("patientEmail") String patientEmail);


}
