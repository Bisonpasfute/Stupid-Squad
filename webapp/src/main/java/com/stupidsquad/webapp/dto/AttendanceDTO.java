package com.stupidsquad.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stupidsquad.webapp.model.Player;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceDTO extends Player {

    @JsonProperty("signUpCount")
    private int signUpCount;

    @JsonProperty("benchCount")
    private int benchCount;

    @JsonProperty("absenceCount")
    private int absenceCount;

    @JsonProperty("presenceCount")
    private int presenceCount;

    @JsonProperty("totalEventCount")
    private int totalEventCount;

    public AttendanceDTO (Player player) {
        this.setId(player.getId());
        this.setUsername(player.getUsername());
        this.setArrivalDate(player.getArrivalDate());
        this.signUpCount = 0;
        this.benchCount = 0;
        this.absenceCount = 0;
        this.presenceCount = 0;
        this.totalEventCount = 0;
    }
}
