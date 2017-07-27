package com.vabram.hearthum.response;

import org.joda.time.LocalDateTime;

import java.io.File;

/**
 * Created by brama051 on 23/06/2017.
 */
public class RecordingResponse {

    private Long id; // primary key

    //private User user; // user that created the recording

    private File content; // actual recording

    private Double recordingLength; // recordingLength (in seconds)

    private String patientName; // patient name

    private String patientEmail; // patient email

    private String recordingPosition; // recording position

    private String recordingTechnology; // recording technology

    private LocalDateTime recordingDateTime; // recording datetime

    // --- get / set methods --------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File getContent() {
        return content;
    }

    public void setContent(File content) {
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
