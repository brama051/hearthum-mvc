package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Analyzer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by brama051 on 23/06/2017.
 */
@CrossOrigin(origins = {"https://hearthum-ng.herokuapp.com", "http://localhost:4200"})
public interface AnalyzerRepository extends PagingAndSortingRepository<Analyzer, Long> {

    Analyzer findByEmail(String email);

}
