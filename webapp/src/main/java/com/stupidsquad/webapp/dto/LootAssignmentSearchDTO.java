package com.stupidsquad.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LootAssignmentSearchDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("player")
    private String player;

    @JsonProperty("dateStart")
    private String dateStart;

    @JsonProperty("dateEnd")
    private String dateEnd;

    @JsonProperty("date")
    private String dateM;

    @JsonProperty("timeStart")
    private String timeStart;

    @JsonProperty("timeEnd")
    private String timeEnd;

    @JsonProperty("time")
    private String time;

    @JsonProperty("itemID")
    private Integer itemID;

    @JsonProperty("itemString")
    private String itemString;

    @JsonProperty("response")
    private String response;

    @JsonProperty("votes")
    private Integer votes;

    @JsonProperty("class")
    private String playerClass;

    @JsonProperty("instance")
    private String instance;

    @JsonProperty("boss")
    private String boss;

    @JsonProperty("gear1")
    private String gear1;

    @JsonProperty("gear2")
    private String gear2;

    @JsonProperty("responseID")
    private Integer responseID;

    @JsonProperty("isAwardReason")
    private String isAwardReason;

    @JsonProperty("rollType")
    private String rollType;

    @JsonProperty("subType")
    private String subType;

    @JsonProperty("equipLoc")
    private String equipLoc;

    @JsonProperty("note")
    private String note;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("serverTimeStart")
    private Long serverTimeStart;

    @JsonProperty("serverTimeEnd")
    private Long serverTimeEnd;

    @JsonProperty("serverTime")
    private Long serverTime;
}
