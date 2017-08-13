package com.vabram.hearthum.repository;

import com.vabram.hearthum.model.Analyzer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by brama051 on 23/06/2017.
 */
public interface AnalyzerRepository extends PagingAndSortingRepository<Analyzer, Long> {

    Analyzer findByEmail(String email);

}
