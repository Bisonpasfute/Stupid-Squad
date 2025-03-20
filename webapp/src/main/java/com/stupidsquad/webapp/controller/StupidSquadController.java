package com.stupidsquad.webapp.controller;

import com.stupidsquad.webapp.dto.*;
import com.stupidsquad.webapp.model.LootAssignment;
import com.stupidsquad.webapp.service.AttendanceService;
import com.stupidsquad.webapp.service.LootService;
import com.stupidsquad.webapp.service.RaidHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StupidSquadController {

    @Autowired
    private RaidHelperService raidHelperService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private LootService lootService;

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

    @PostMapping("/loot/import")
    public ResponseEntity<?> importLoot(@RequestBody List<LootAssignment> lootAssignments) {
        try {
            List<LootAssignment> allLoot = lootService.importLoot(lootAssignments);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new LootResponseDTO("success", "Data imported successfully.", allLoot));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new LootResponseDTO("error", "An unexpected error occurred.", e.getMessage()));
        }
    }
}
