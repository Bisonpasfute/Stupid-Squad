package com.stupidsquad.webapp.service;

import com.stupidsquad.webapp.dto.*;
import com.stupidsquad.webapp.model.ClassEnum;
import com.stupidsquad.webapp.model.Player;
import com.stupidsquad.webapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class AttendanceService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RaidHelperService raidHelperService;

    public List<AttendanceStatisticsDTO> getAttendance(EventsDTO eventsDTO) {
        Map<Long, AttendanceDTO> attendanceDTOMap = new HashMap<>();
        List<AttendanceStatisticsDTO> statisticsDTOList = new ArrayList<>();

        // Addition of missing players (players who signed up but don't exist in the player table)
        if (eventsDTO.getPostedEvents() != null) {
            eventsDTO.getPostedEvents().forEach(postedEventDTO -> {
                if (postedEventDTO.getSignUps() != null) {
                    postedEventDTO.getSignUps().forEach(signUpDTO -> {
                        long userId = Long.parseLong(signUpDTO.getUserId());
                        if (playerRepository.findById(userId).isEmpty()) {
                            playerRepository.save(new Player(userId, signUpDTO.getName(), new Date(System.currentTimeMillis())));
                        }
                    });
                }
            });
        }

        List<Player> listPlayer = playerRepository.findAll();
        listPlayer.forEach(player -> attendanceDTOMap.put(player.getId(), new AttendanceDTO(player)));

        if (eventsDTO.getPostedEvents() != null) {
            eventsDTO.getPostedEvents().forEach(postedEventDTO -> {
                RaidPlanDTO raidPlanDTO = raidHelperService.getRaidPlan(Long.parseLong(postedEventDTO.getId()));
                if (raidPlanDTO != null) {
                    if (postedEventDTO.getSignUps() != null) {
                        // For each sign-up, increase their sign-up count or their absence count
                        postedEventDTO.getSignUps().forEach(signUpDTO -> {
                            long userId = Long.parseLong(signUpDTO.getUserId());
                            if (postedEventDTO.getStartTime() * 1000L >= attendanceDTOMap.get(userId).getArrivalDate().getTime()) {
                                if (ClassEnum.ABSENCE.getClassName().equals(signUpDTO.getSpecName())) {
                                    attendanceDTOMap.get(userId).setAbsenceCount(attendanceDTOMap.get(userId).getAbsenceCount() + 1);
                                } else {
                                    attendanceDTOMap.get(userId).setSignUpCount(attendanceDTOMap.get(userId).getSignUpCount() + 1);
                                }
                            }
                        });
                    }
                    // For each player-up, if the player arrived before the date of the event, increase their total event count
                    attendanceDTOMap.forEach((aLong, attendanceDTO) -> {
                        if (postedEventDTO.getStartTime() * 1000L >= attendanceDTO.getArrivalDate().getTime()) {
                            attendanceDTO.setTotalEventCount(attendanceDTO.getTotalEventCount() + 1);
                        }
                    });

                    // Find players who are signed up (not as absence) but not rostered (bench players) and update their bench count
                    if (postedEventDTO.getId() != null && !postedEventDTO.getId().isEmpty()) {
                        List<Long> rosteredPlayers = raidPlanDTO.getRaidDropDTO()
                                .stream()
                                .map(RaidDropDTO::getUserid)
                                .filter(userId -> userId != null && !userId.isEmpty() && !userId.equals("undefined"))  // Check for null or empty
                                .map(Long::parseLong)
                                .toList();

                        List<Long> signedUpPlayers = Optional.ofNullable(postedEventDTO.getSignUps())
                                .orElseGet(Collections::emptyList)  // Provide an empty list if null
                                .stream()
                                .filter(signUpDTO -> !ClassEnum.ABSENCE.getClassName().equals(signUpDTO.getSpecName()))
                                .map(signUpDTO -> Long.parseLong(signUpDTO.getUserId()))
                                .toList();
                        List<Long> benchPlayers = new ArrayList<>(signedUpPlayers);
                        benchPlayers.removeAll(rosteredPlayers);
                        benchPlayers.forEach(playerId -> {
                            if (postedEventDTO.getStartTime() * 1000L >= attendanceDTOMap.get(playerId).getArrivalDate().getTime()) {
                             attendanceDTOMap.get(playerId).setBenchCount(attendanceDTOMap.get(playerId).getBenchCount() + 1);
                            }
                        });
                    }
                }
            });
        }

        // Calculate the final attendance statistics for each player
        attendanceDTOMap.forEach((aLong, attendanceDTO) -> {
            float benchPercentage = ((float) attendanceDTO.getBenchCount() / (float) attendanceDTO.getTotalEventCount()) * 100F;
            float absencePercentage = ((float) attendanceDTO.getAbsenceCount() / (float) attendanceDTO.getTotalEventCount()) * 100F;
            float presencePercentage = ((float) attendanceDTO.getSignUpCount() / (float) attendanceDTO.getTotalEventCount()) * 100F;
            float ghostingPercentage = ((((float) attendanceDTO.getTotalEventCount() - ((float) attendanceDTO.getSignUpCount() + attendanceDTO.getAbsenceCount())) / (float) attendanceDTO.getTotalEventCount())) * 100F;
            AttendanceStatisticsDTO player = new AttendanceStatisticsDTO(
                    attendanceDTO.getId(),
                    attendanceDTO.getUsername(),
                    benchPercentage,
                    absencePercentage,
                    presencePercentage,
                    ghostingPercentage,
                    attendanceDTO.getTotalEventCount()
            );
            statisticsDTOList.add(player);
        });

        return statisticsDTOList;
    }
}
