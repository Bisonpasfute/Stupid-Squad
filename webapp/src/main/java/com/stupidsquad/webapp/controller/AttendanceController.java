package com.stupidsquad.webapp.controller;

import com.stupidsquad.webapp.dto.*;
import com.stupidsquad.webapp.service.AttendanceService;
import com.stupidsquad.webapp.service.RaidHelperService;
import com.stupidsquad.webapp.utils.DateUtils;
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
                                                       @RequestParam(required = false) String startTimeFilter,
                                                       @RequestParam(required = false) String endTimeFilter) {
        EventsInputDTO eventsInputDTO = new EventsInputDTO(
                page,
                includeSignUps,
                channelFilter,
                DateUtils.convertToEpoch(startTimeFilter),
                DateUtils.convertToEpoch(endTimeFilter)
        );
        EventsDTO eventsDTO = raidHelperService.getEvents(eventsInputDTO);
        return attendanceService.getAttendance(eventsDTO);
    }
}
