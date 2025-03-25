package com.stupidsquad.webapp.controller;

import com.stupidsquad.webapp.dto.*;
import com.stupidsquad.webapp.service.AttendanceService;
import com.stupidsquad.webapp.service.RaidHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    private RaidHelperService raidHelperService;

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/attendance")
    public List<AttendanceStatisticsDTO> getAttendance(@RequestParam(required = false) Integer page,
                                                       @RequestParam(required = false) Boolean includeSignUps,
                                                       @RequestParam(required = false) String channelFilter,
                                                       @RequestParam(required = false) Long startTimeFilter,
                                                       @RequestParam(required = false) Long endTimeFilter) {
        EventsInputDTO eventsInputDTO = new EventsInputDTO(page, includeSignUps, channelFilter, startTimeFilter, endTimeFilter);
        EventsDTO eventsDTO = raidHelperService.getEvents(eventsInputDTO);
        return attendanceService.getAttendance(eventsDTO);
    }
}
