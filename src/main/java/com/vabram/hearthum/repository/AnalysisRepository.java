package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Analysis;
import com.vabram.hearthum.model.Recording;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.PostPersist;
import java.util.List;

/**
 * Created by brama051 on 23/06/2017.
 */
@CrossOrigin
public interface AnalysisRepository extends PagingAndSortingRepository<Analysis, Long> {

    List<Analysis> findAllByRecording(Recording recording);
}
