package com.vabram.hearthum.model;

import org.joda.time.LocalDate;

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
    private Double length; // length (in seconds)

    @Column(name = "PATIENT_NAME")
    private String patientName; // patient name

    @Column(name = "PATIENT_EMAIL")
    private String patientEmail; // patient email

    @Column(name = "RECORDING_POSITION")
    private String recordingPosition; // recording position

    @Column(name = "RECORDING_TECHNOLOGY")
    private String recordingTechnology; // recording technology

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

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
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

}
