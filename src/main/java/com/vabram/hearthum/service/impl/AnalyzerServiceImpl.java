package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.Analyzer;
import com.vabram.hearthum.repository.AnalyzerRepository;
import com.vabram.hearthum.service.AnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by brama051 on 1.3.2017..
 */
@Service
public class AnalyzerServiceImpl implements AnalyzerService {

    @Autowired
    private AnalyzerRepository analyzerRepository;

    @Override
    public Analyzer findOne(Long id) {
        return analyzerRepository.findOne(id);
    }

    @Override
    public Analyzer getAnalyzerByEmail(String email) {
        return analyzerRepository.findByEmail(email);
    }
}
