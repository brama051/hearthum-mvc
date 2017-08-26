package com.vabram.hearthum.controller;

import com.vabram.hearthum.model.Analysis;
import com.vabram.hearthum.model.Recording;
import com.vabram.hearthum.model.User;
import com.vabram.hearthum.service.AnalysisService;
import com.vabram.hearthum.service.RecordingService;
import com.vabram.hearthum.service.UserService;
import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * Created by brama051 on 05/07/2017.
 */
@CrossOrigin(origins = {"http://localhost:4200", "https://hearthum-ng.herokuapp.com"})
@Controller
@RequestMapping("/recordings")
public class RecordingController {

    private static final Logger LOGGER = Logger.getLogger(RecordingController.class);

    @Autowired
    RecordingService recordingService;

    @Autowired
    UserService userService;

    @Autowired
    AnalysisService analysisService;

    @ResponseBody
    @GetMapping()
    public Page<Recording> getRecordingPage(@RequestHeader(value="userEmail", defaultValue = "") String userEmail,
                                            @RequestParam(name = "page", defaultValue = "0") int page,
                                            @RequestParam(name = "size", defaultValue = "25") int size,
                                            @RequestParam(name = "filter", defaultValue = "") String filter,
                                            @RequestParam(name = "filterByUser", defaultValue = "false") boolean filterByUser,
                                            @RequestParam(name = "filterBy", defaultValue = "patientName") String filterBy,
                                            @RequestParam(name = "sortType", defaultValue = "descending") String sortType,
                                            @RequestParam(name = "analyzed", defaultValue = "false") boolean analyzed) {
        // required for adding the user to our database
        User user = userService.getUserByEmail(userEmail);

        // required for recording service
        if (!filterByUser) {
            user = null;
        }

        // required pageRequest parameter
        Sort.Direction direction = null;
        if (sortType.equals("descending")) {
            direction = Sort.Direction.DESC;
        } else {
            direction = Sort.Direction.ASC;
        }


        if (analyzed) {
            return recordingService.findAllAnalyzedByPatientEmail(user, filter, new PageRequest(page, size, direction, "patientEmail"));
        } else {
            // determining type of search
            switch (filterBy) {
                case "patientEmail":
                    return recordingService.findAllByPatientEmail(user, filter, new PageRequest(page, size, direction, "patientEmail"));

                case "dateCreated":
                    return recordingService.findAllByRecordingDateTimeBetween(user, filter, new PageRequest(page, size, direction, "recordingDateTime"));

                default:
                    return recordingService.findAllByPatientName(user, filter, new PageRequest(page, size, direction, "patientName"));

            }
        }


    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Recording getRecording(@RequestHeader(value="userEmail", defaultValue = "") String userEmail,
                                  @PathVariable("id") Long id) {
        LOGGER.info("User accessed a recording: " + userEmail);
        /*Recording r = recordingService.findOne(id);
        RecordingResponse rr = new RecordingResponse();
        rr.setId(r.getId());
        rr.setRecordingContent(new File());
        return rr;*/
        return recordingService.findOne(id);
    }

    @ResponseBody
    @PostMapping
    public Recording postRecording(@RequestHeader(value="userEmail", defaultValue = "") String userEmail,
                                   @RequestParam(name = "patientName", defaultValue = "", required = false) String patientName,
                                   @RequestParam(name = "patientEmail", defaultValue = "", required = false) String patientEmail,
                                   @RequestParam(name = "patientHeight", defaultValue = "", required = false) Double patientHeight,
                                   @RequestParam(name = "patientWeight", defaultValue = "", required = false) Double patientWeight,
                                   @RequestParam(name = "patientAge", defaultValue = "", required = false) Double patientAge,
                                   @RequestParam(name = "patientSex", defaultValue = "", required = false) String patientSex,
                                   @RequestParam(name = "recordingDevice", defaultValue = "", required = false) String recordingDevice,
                                   @RequestParam(name = "recordingLocation", defaultValue = "", required = false) String recordingLocation,
                                   @RequestParam(name = "recordingLength", defaultValue = "0", required = false) Double recordingLength,
                                   @RequestParam(name = "comment", defaultValue = "", required = false) String comment,
                                   @RequestParam(name = "content") MultipartFile recordingContent) {
        LOGGER.info("User is trying to create a recording: " + userEmail);
        User user = userService.getUserByEmail(userEmail);

        Recording recording = new Recording();
        recording.setUser(user);
        recording.setPatientName(patientName);
        recording.setPatientEmail(patientEmail);
        recording.setPatientAge(patientAge);
        recording.setPatientHeight(patientHeight);
        recording.setPatientWeight(patientWeight);
        recording.setPatientSex(patientSex);
        recording.setComment(comment);
        recording.setRecordingTechnology(recordingDevice);
        recording.setRecordingPosition(recordingLocation);
        recording.setRecordingDateTime(LocalDateTime.now());
        recording.setRecordingLength(recordingLength);

        try {
            String base64recording = new String(Base64.getEncoder().encode(recordingContent.getBytes()));
            // base64recording = base64recording.substring(0, 100);
            LOGGER.info(base64recording.length());
            recording.setRecordingContent(base64recording);
        } catch (IOException e) {
            LOGGER.warn(e.getStackTrace(), e);
        }

        return recordingService.save(recording);
    }

    @ResponseBody
    @GetMapping("{id}/analyses")
    public List<Analysis> getRecordingPage(@RequestHeader(value="userEmail", defaultValue = "") String userEmail,
                                           @PathVariable(name = "id") Long id) {
        LOGGER.info("User is trying to get a list of recording analysis: " + userEmail);
        User user = userService.getUserByEmail(userEmail);

        Recording recording = recordingService.findOne(id);

        return analysisService.findAllByRecording(recording);
    }


}
