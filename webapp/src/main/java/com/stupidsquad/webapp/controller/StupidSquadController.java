package com.stupidsquad.webapp.controller;

import com.stupidsquad.webapp.dto.*;
import com.stupidsquad.webapp.service.AttendanceService;
import com.stupidsquad.webapp.service.RaidHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StupidSquadController {

    @Autowired
    private RaidHelperService raidHelperService;

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/attendance")
    public List<AttendanceStatisticsDTO> getAttendance(@RequestHeader(required = false) Integer page,
                                                       @RequestHeader(required = false) Boolean includeSignUps,
                                                       @RequestHeader(required = false) String channelFilter,
                                                       @RequestHeader(required = false) Long startTimeFilter,
                                                       @RequestHeader(required = false) Long endTimeFilter) {
        EventsInputDTO eventsInputDTO = new EventsInputDTO(page, includeSignUps, channelFilter, startTimeFilter, endTimeFilter);
        EventsDTO eventsDTO = raidHelperService.getEvents(eventsInputDTO);
        return attendanceService.getAttendance(eventsDTO);
    }
}
