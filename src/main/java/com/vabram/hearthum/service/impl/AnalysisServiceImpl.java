package com.vabram.hearthum.service.impl;

import com.vabram.hearthum.model.Analysis;
import com.vabram.hearthum.repository.AnalysisRepository;
import com.vabram.hearthum.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by brama051 on 1.3.2017..
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisRepository analysiseRpository;

    @Override
    public Analysis findOne(Long id) {
        return analysiseRpository.findOne(id);
    }
}
