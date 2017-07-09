package com.vabram.hearthum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

/**
 * Created by brama051 on 23/06/2017.
 */
@Entity
@Table(name = "RECORDING")
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id; // primary key

    //private User user; // user that created the recording

    @Column(name = "CONTENT")
    private byte[] content; // actual recording

    @Column(name = "LENGTH")
    private Double recordingLength; // recordingLength (in seconds)

    @Column(name = "PATIENT_NAME")
    private String patientName; // patient name

    @Column(name = "PATIENT_EMAIL")
    private String patientEmail; // patient email

    @Column(name = "RECORDING_POSITION")
    private String recordingPosition; // recording position

    @Column(name = "RECORDING_TECHNOLOGY")
    private String recordingTechnology; // recording technology

    @Column(name = "RECORDING_DATETIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime recordingDateTime; // recording datetime

    // --- get / set methods --------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
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
}
