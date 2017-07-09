package com.vabram.hearthum.controller;

import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.service.RecordingService;
import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by brama051 on 05/07/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/recordings")
public class RecordingController {

    private static final Logger LOGGER = Logger.getLogger(RecordingController.class);

    @Autowired
    RecordingService recordingService;

    @ResponseBody
    @GetMapping()
    public Page<Recording> getRecordingPage(@RequestParam(name = "page", defaultValue = "0") int page,
                                            @RequestParam(name = "size", defaultValue = "25") int size) {
        return recordingService.findAll(new PageRequest(page, size));
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Recording getRecording(@PathVariable("id") Long id) {
        return recordingService.findOne(id);
    }

    @ResponseBody
    @PostMapping
    public Recording postRecording(@RequestParam(name = "patientName", defaultValue = "", required = false) String patientName,
                                   @RequestParam(name = "patientEmail", defaultValue = "", required = false) String patientEmail,
                                   @RequestParam(name = "recordingDevice", defaultValue = "", required = false) String recordingDevice,
                                   @RequestParam(name = "recordingLocation", defaultValue = "", required = false) String recordingLocation,
                                   @RequestParam(name = "recordingLength", defaultValue = "0", required = false) Double recordingLength,
                                   @RequestParam(name = "content") MultipartFile content) {
        Recording recording = new Recording();
        recording.setPatientName(patientName);
        recording.setPatientEmail(patientEmail);
        recording.setRecordingTechnology(recordingDevice);
        recording.setRecordingPosition(recordingLocation);
        recording.setRecordingDateTime(LocalDateTime.now());
        recording.setRecordingLength(recordingLength);
        try {
            recording.setContent(content.getBytes());
        } catch (IOException e) {
            LOGGER.warn(e.getStackTrace(), e);
        }

        return recordingService.save(recording);
    }



    /*@ResponseBody
    @DeleteMapping(name = "/{id}")
    public Recording deleteRecording(@PathVariable("id") Long id) {
        return recordingService.findOne(id);
    }*/

}
