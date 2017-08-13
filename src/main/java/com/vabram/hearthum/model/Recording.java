package com.vabram.hearthum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Created by brama051 on 23/06/2017.
 */
@Entity
@Table(name = "RECORDING", schema = "hearthumschema")
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id; // primary key

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user; // user that created the recording

    @Column(name = "RECORDING_CONTENT", length=10485760)
    private String recordingContent; // actual recording

    @Column(name = "RECORDING_LENGTH")
    private Double recordingLength; // recordingLength (in seconds)

    @Column(name = "RECORDING_POSITION")
    private String recordingPosition; // recording position

    @Column(name = "RECORDING_TECHNOLOGY")
    private String recordingTechnology; // recording technology

    @Column(name = "COMMENT")
    private String comment; // comment

    @Column(name = "PATIENT_NAME")
    private String patientName; // patient name

    @Column(name = "PATIENT_EMAIL")
    private String patientEmail; // patient email

    @Column(name = "PATIENT_AGE")
    private Double patientAge; // patient age

    @Column(name = "PATIENT_SEX")
    private String patientSex; // patient sex

    @Column(name = "PATIENT_HEIGHT")
    private Double patientHeight; // patient height

    @Column(name = "PATIENT_WEIGHT")
    private Double patientWeight; // patient weight

    @Column(name = "RECORDING_DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime recordingDateTime; // recording datetime

    @OneToMany(mappedBy = "recording", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Analysis> analysisList;

    // --- get / set methods --------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecordingContent() {
        return recordingContent;
    }

    public void setRecordingContent(String recordingContent) {
        this.recordingContent = recordingContent;
    }

    public Double getRecordingLength() {
        return recordingLength;
    }

    public void setRecordingLength(Double recordingLength) {
        this.recordingLength = recordingLength;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getRecordingPosition() {
        return recordingPosition;
    }

    public void setRecordingPosition(String recordingPosition) {
        this.recordingPosition = recordingPosition;
    }

    public String getRecordingTechnology() {
        return recordingTechnology;
    }

    public void setRecordingTechnology(String recordingTechnology) {
        this.recordingTechnology = recordingTechnology;
    }

    public LocalDateTime getRecordingDateTime() {
        return recordingDateTime;
    }

    public void setRecordingDateTime(LocalDateTime recordingDateTime) {
        this.recordingDateTime = recordingDateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Double patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Double getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(Double patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(Double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }
}
