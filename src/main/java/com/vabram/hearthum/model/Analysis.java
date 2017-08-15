package com.vabram.hearthum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vabram.hearthum.listener.AnalysisListener;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

/**
 * Created by brama051 on 23/06/2017.
 */
@Entity
@EntityListeners(AnalysisListener.class)
@Table(name = "ANALYSIS", schema = "hearthumschema")
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id; // primary key

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "RECORDING_ID")
    private Recording recording; // recording that is subject of the analysis

    @ManyToOne
    @JoinColumn(name = "ANALYZER_ID")
    private Analyzer analyzer; // analyzer that created the analysis

    @Column(name = "RECORDING_RATING")
    private Integer recordingRating; // rating of the recording

    @Column(name = "ANALYSIS_COMMENT", length = 1024)
    private String analysisComment; // analysis comment

    @Column(name = "ANALYSIS_OUTCOME")
    private Boolean analysisOutcome; // outcome of the analysis - true or false (positive or negative)

    @Column(name = "ANALYSIS_TECHNOLOGY")
    private String analysisTechnology;

    @Column(name = "ANALYSIS_DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime analysisDateTime; // recording datetime

    // --- get / set methods --------------------------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recording getRecording() {
        return recording;
    }

    public void setRecording(Recording recording) {
        this.recording = recording;
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public Integer getRecordingRating() {
        return recordingRating;
    }

    public void setRecordingRating(Integer recordingRating) {
        this.recordingRating = recordingRating;
    }

    public String getAnalysisComment() {
        return analysisComment;
    }

    public void setAnalysisComment(String analysisComment) {
        this.analysisComment = analysisComment;
    }

    public Boolean getAnalysisOutcome() {
        return analysisOutcome;
    }

    public void setAnalysisOutcome(Boolean analysisOutcome) {
        this.analysisOutcome = analysisOutcome;
    }

    public String getAnalysisTechnology() {
        return analysisTechnology;
    }

    public void setAnalysisTechnology(String analysisTechnology) {
        this.analysisTechnology = analysisTechnology;
    }

    public LocalDateTime getAnalysisDateTime() {
        return analysisDateTime;
    }

    public void setAnalysisDateTime(LocalDateTime analysisDateTime) {
        this.analysisDateTime = analysisDateTime;
    }
}
