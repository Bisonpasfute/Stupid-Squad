package com.stupidsquad.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AttendanceStatisticsDTO {
    @JsonProperty("userID")
    private long userId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("benchPercentage")
    private float benchPercentage;

    @JsonProperty("signUpPercentage")
    private float signUpPercentage;

    @JsonProperty("ghostingPercentage")
    private float ghostingPercentage;
}
