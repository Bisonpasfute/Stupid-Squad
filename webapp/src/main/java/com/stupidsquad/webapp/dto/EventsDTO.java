package com.stupidsquad.webapp.dto;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pages",
        "eventsOverall",
        "eventsTransmitted",
        "currentPage",
        "postedEvents"
})
@Generated("jsonschema2pojo")
@Getter
public class EventsDTO {

    @JsonProperty("pages")
    public Integer pages;
    @JsonProperty("eventsOverall")
    public Integer eventsOverall;
    @JsonProperty("eventsTransmitted")
    public Integer eventsTransmitted;
    @JsonProperty("currentPage")
    public Integer currentPage;
    @JsonProperty("postedEvents")
    @Valid
    public List<PostedEventDTO> postedEvents;

}