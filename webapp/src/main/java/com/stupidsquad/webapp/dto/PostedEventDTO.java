package com.stupidsquad.webapp.dto;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "signUps",
        "color",
        "description",
        "title",
        "templateId",
        "signUpCount",
        "leaderId",
        "lastUpdated",
        "leaderName",
        "closeTime",
        "startTime",
        "endTime",
        "id",
        "channelId"
})
@Generated("jsonschema2pojo")
@Data
public class PostedEventDTO {

    @JsonProperty("signUps")
    @Valid
    public List<SignUpDTO> signUps;
    @JsonProperty("color")
    public String color;
    @JsonProperty("description")
    public String description;
    @JsonProperty("title")
    public String title;
    @JsonProperty("templateId")
    public String templateId;
    @JsonProperty("signUpCount")
    public String signUpCount;
    @JsonProperty("leaderId")
    public String leaderId;
    @JsonProperty("lastUpdated")
    public Integer lastUpdated;
    @JsonProperty("leaderName")
    public String leaderName;
    @JsonProperty("closeTime")
    public Integer closeTime;
    @JsonProperty("startTime")
    public Integer startTime;
    @JsonProperty("endTime")
    public Integer endTime;
    @JsonProperty("id")
    public String id;
    @JsonProperty("channelId")
    public String channelId;

}