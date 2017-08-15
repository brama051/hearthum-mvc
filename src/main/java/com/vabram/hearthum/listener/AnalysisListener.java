package com.vabram.hearthum.listener;

import com.vabram.hearthum.helper.AutowireHelper;
import com.vabram.hearthum.model.Analysis;
import com.vabram.hearthum.model.Analyzer;
import com.vabram.hearthum.service.AnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * Created by brama051 on 15/08/2017.
 */
public class AnalysisListener {
    @Autowired
    AnalyzerService analyzerService;

    @PrePersist
    public void prePersist(Analysis ob) {
        AutowireHelper.autowire(this);
        System.out.println("Listening Analysis Pre Persist : " + ob.getId());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Analyzer analyzer = analyzerService.getAnalyzerByEmail(user.getUsername());
        // by allowing analyzer to be null, we are allowing failure of insertion of the record - it's not a bug, it's a feature
        ob.setAnalyzer(analyzer);
    }

    @PostPersist
    public void postPersist(Analysis ob) {
        System.out.println("Listening Analysis Post Persist : " + ob.getId());
    }
}
