package com.stupidsquad.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AttendanceStatisticsDTO {
    @JsonProperty("userID")
    private long userId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("benchPercentage")
    private float benchPercentage;

    @JsonProperty("absencePercentage")
    private float absencePercentage;

    @JsonProperty("presencePercentage")
    private float presencePercentage;

    @JsonProperty("ghostingPercentage")
    private float ghostingPercentage;

    @JsonProperty("eventCount")
    private int evenCount;
}
