package com.vabram.hearthum.service;

import com.vabram.hearthum.model.Analyzer;

/**
 * Created by brama051 on 1.3.2017..
 */
public interface AnalyzerService {

    Analyzer findOne(Long id);

    Analyzer getAnalyzerByEmail(String email);
}


