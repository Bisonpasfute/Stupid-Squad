package com.stupidsquad.webapp.service;

import com.stupidsquad.webapp.dto.*;
import com.stupidsquad.webapp.model.Player;
import com.stupidsquad.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RaidHelperService raidHelperService;

    public List<AttendanceStatisticsDTO> getAttendance(EventsDTO eventsDTO) {
        Map<Long, AttendanceDTO> attendanceDTOMap = new HashMap<>();
        List<AttendanceStatisticsDTO> statisticsDTOList = new ArrayList<>();

        // Addition of new players
        if (eventsDTO.getPostedEvents() != null) {
            eventsDTO.getPostedEvents().forEach(postedEventDTO -> {
                if (postedEventDTO.getSignUps() != null) {
                    postedEventDTO.getSignUps().forEach(signUpDTO -> {
                        long userId = Long.parseLong(signUpDTO.getUserId());
                        if (userRepository.findById(userId).isEmpty()) {
                            userRepository.save(new Player(userId, signUpDTO.getName(), new Date(System.currentTimeMillis())));
                        }
                    });
                }
            });
        }

        List<Player> listPlayer = userRepository.findAll();
        listPlayer.forEach(player -> attendanceDTOMap.put(player.getId(), new AttendanceDTO(player)));

        if (eventsDTO.getPostedEvents() != null) {
            eventsDTO.getPostedEvents().forEach(postedEventDTO -> {
                RaidPlanDTO raidPlanDTO = raidHelperService.getRaidPlan(Long.parseLong(postedEventDTO.getId()));
                if (raidPlanDTO != null) {
                    if (postedEventDTO.getSignUps() != null) {
                        postedEventDTO.getSignUps().forEach(signUpDTO -> {
                            long userId = Long.parseLong(signUpDTO.getUserId());
                            //The player has signed up for that event
                            attendanceDTOMap.get(userId).setSignUpCount(attendanceDTOMap.get(userId).getSignUpCount() + 1);
                        });
                    }
                    attendanceDTOMap.forEach((aLong, attendanceDTO) -> {
                        //If the player arrived before the date of the event, they should have signed up
                        if (postedEventDTO.getStartTime() * 1000L >= attendanceDTO.getArrivalDate().getTime()) {
                            attendanceDTO.setTotalEventCount(attendanceDTO.getTotalEventCount() + 1);
                        }
                    });
                    if (postedEventDTO.getId() != null && !postedEventDTO.getId().isEmpty()) {

                        List<Long> rosteredPlayers = raidPlanDTO.getRaidDropDTO()
                                .stream()
                                .map(raidDropDTO -> Long.parseLong(raidDropDTO.getUserid()))
                                .toList();
                        List<Long> signedUpPlayers = postedEventDTO.getSignUps()
                                .stream()
                                .map(signUpDTO -> Long.parseLong(signUpDTO.getUserId()))
                                .toList();
                        List<Long> benchPlayers = new ArrayList<>(signedUpPlayers);
                        benchPlayers.removeAll(rosteredPlayers);
                        benchPlayers.forEach(playerId -> {
                            attendanceDTOMap.get(playerId).setBenchCount(attendanceDTOMap.get(playerId).getBenchCount() + 1);
                        });
                    }
                }
            });
        }

        attendanceDTOMap.forEach((aLong, attendanceDTO) -> {
            float benchPercentage = ((float) attendanceDTO.getBenchCount() / (float) attendanceDTO.getTotalEventCount()) * 100F;
            float signUpPercentage = ((float) attendanceDTO.getSignUpCount() / (float) attendanceDTO.getTotalEventCount()) * 100F;
            float ghostingPercentage = (((float) attendanceDTO.getTotalEventCount() - (float) attendanceDTO.getSignUpCount()) / (float) attendanceDTO.getTotalEventCount()) * 100F;
            AttendanceStatisticsDTO player = new AttendanceStatisticsDTO(
                    attendanceDTO.getId(),
                    attendanceDTO.getUsername(),
                    benchPercentage,
                    signUpPercentage,
                    ghostingPercentage

            );
            statisticsDTOList.add(player);
        });

        return statisticsDTOList;
    }
}
