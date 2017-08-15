package com.vabram.hearthum.listener;

import com.vabram.hearthum.helper.AutowireHelper;
import com.vabram.hearthum.model.Analysis;
import com.vabram.hearthum.model.Analyzer;
import com.vabram.hearthum.service.AnalyzerService;
import com.vabram.hearthum.service.EmailService;
import org.joda.time.LocalDateTime;
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

    @Autowired
    EmailService emailService;


    @PrePersist
    public void prePersist(Analysis ob) {
        AutowireHelper.autowire(this);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Analyzer analyzer = analyzerService.getAnalyzerByEmail(user.getUsername());
        // by allowing analyzer to be null, we are allowing failure of insertion of the record - it's not a bug, it's a feature
        ob.setAnalyzer(analyzer);
        ob.setAnalysisDateTime(LocalDateTime.now());
    }

    @PostPersist
    public void postPersist(Analysis ob) {
        AutowireHelper.autowire(this);

        if (ob != null && ob.getAnalysisOutcome()) {
            // need to inform both patient and the user that made the recording
            emailService.sendSimpleMessage(ob.getRecording().getPatientEmail(), "Positive diagnosis notification", "BODY");
            emailService.sendSimpleMessage(ob.getRecording().getUser().getEmail(), "Positive diagnosis notification", "BODY");
        }
    }
}
