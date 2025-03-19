package com.stupidsquad.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EventsInputDTO {
    @JsonProperty("page")
    Integer page;

    @JsonProperty("IncludeSignUps")
    Boolean includeSignUps;

    @JsonProperty("ChannelFilter")
    String channelFilter;

    @JsonProperty("StartTimeFilter")
    Long startTimeFilter;

    @JsonProperty("EndTimeFilter")
    Long endTimeFilter;
}
