package com.stupidsquad.webapp.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "string",
        "class",
        "class_emote",
        "spec",
        "spec_emote",
        "color",
        "name",
        "partyId",
        "slotId",
        "timestamp",
        "username",
        "oldPartyId",
        "oldSlotId",
        "oldClass",
        "oldClass_emote",
        "oldSpec",
        "oldSpec_emote",
        "oldColor",
        "oldName",
        "newName",
        "newClass_emote",
        "newSpec_emote",
        "newClass",
        "newSpec",
        "newColor"
})
@Generated("jsonschema2pojo")
@Getter
public class LoggingDTO {

    @JsonProperty("type")
    public String type;
    @JsonProperty("string")
    public String string;
    @JsonProperty("class")
    public String _class;
    @JsonProperty("class_emote")
    public String classEmote;
    @JsonProperty("spec")
    public String spec;
    @JsonProperty("spec_emote")
    public String specEmote;
    @JsonProperty("color")
    public String color;
    @JsonProperty("name")
    public String name;
    @JsonProperty("partyId")
    public String partyId;
    @JsonProperty("slotId")
    public Integer slotId;
    @JsonProperty("timestamp")
    @DecimalMin("9223372036854775807")
    public Long timestamp;
    @JsonProperty("username")
    public String username;
    @JsonProperty("oldPartyId")
    public String oldPartyId;
    @JsonProperty("oldSlotId")
    public Integer oldSlotId;
    @JsonProperty("oldClass")
    public String oldClass;
    @JsonProperty("oldClass_emote")
    public String oldClassEmote;
    @JsonProperty("oldSpec")
    public String oldSpec;
    @JsonProperty("oldSpec_emote")
    public String oldSpecEmote;
    @JsonProperty("oldColor")
    public String oldColor;
    @JsonProperty("oldName")
    public String oldName;
    @JsonProperty("newName")
    public String newName;
    @JsonProperty("newClass_emote")
    public String newClassEmote;
    @JsonProperty("newSpec_emote")
    public String newSpecEmote;
    @JsonProperty("newClass")
    public String newClass;
    @JsonProperty("newSpec")
    public String newSpec;
    @JsonProperty("newColor")
    public String newColor;

}
