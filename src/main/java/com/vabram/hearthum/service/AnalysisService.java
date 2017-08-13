package com.vabram.hearthum.service;

import com.vabram.hearthum.model.Analysis;
import com.vabram.hearthum.model.Recording;

import java.util.List;

/**
 * Created by brama051 on 1.3.2017..
 */
public interface AnalysisService {

    Analysis findOne(Long id);

    List<Analysis> findAllByRecording(Recording recording);
}


