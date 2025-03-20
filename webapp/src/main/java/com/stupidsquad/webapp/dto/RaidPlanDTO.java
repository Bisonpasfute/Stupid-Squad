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
        "_id",
        "hash",
        "permissionLevel",
        "visibilityLevel",
        "templateId",
        "title",
        "partyPerRaid",
        "slotPerParty",
        "raidDrop",
        "raidDropBench",
        "partyNames",
        "divideArray",
        "hasUpdatingAnnounce",
        "displayRoles",
        "displayClasses",
        "overlayDropColorObject",
        "logging",
        "__v"
})
@Generated("jsonschema2pojo")
@Data
public class RaidPlanDTO {

    @JsonProperty("_id")
    public String id;
    @JsonProperty("hash")
    public String hash;
    @JsonProperty("permissionLevel")
    public String permissionLevel;
    @JsonProperty("visibilityLevel")
    public String visibilityLevel;
    @JsonProperty("templateId")
    public Integer templateId;
    @JsonProperty("title")
    public String title;
    @JsonProperty("partyPerRaid")
    public Integer partyPerRaid;
    @JsonProperty("slotPerParty")
    public Integer slotPerParty;
    @JsonProperty("raidDrop")
    @Valid
    public List<RaidDropDTO> raidDropDTO;
    @JsonProperty("raidDropBench")
    @Valid
    public List<Object> raidDropBench;
    @JsonProperty("partyNames")
    @Valid
    public List<String> partyNames;
    @JsonProperty("divideArray")
    @Valid
    public List<Integer> divideArray;
    @JsonProperty("hasUpdatingAnnounce")
    public String hasUpdatingAnnounce;
    @JsonProperty("displayRoles")
    public String displayRoles;
    @JsonProperty("displayClasses")
    public String displayClasses;
    @JsonProperty("overlayDropColorObject")
    @Valid
    public List<OverlayDropColorObjectDTO> overlayDropColorObjectDTO;
    @JsonProperty("logging")
    @Valid
    public List<LoggingDTO> loggingDTO;
    @JsonProperty("__v")
    public Integer v;

}