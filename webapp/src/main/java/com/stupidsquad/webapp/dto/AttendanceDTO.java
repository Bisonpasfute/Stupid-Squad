package com.stupidsquad.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stupidsquad.webapp.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceDTO extends Player {

    @JsonProperty("signUpCount")
    private int signUpCount;

    @JsonProperty("benchCount")
    private int benchCount;

    @JsonProperty("totalEventCount")
    private int totalEventCount;

    public AttendanceDTO (Player player) {
        this.setId(player.getId());
        this.setUsername(player.getUsername());
        this.setArrivalDate(player.getArrivalDate());
        this.benchCount = 0;
        this.signUpCount = 0;
        this.totalEventCount = 0;
    }
}
