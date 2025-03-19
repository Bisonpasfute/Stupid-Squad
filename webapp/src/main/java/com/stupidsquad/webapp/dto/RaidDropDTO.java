package com.stupidsquad.webapp.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "partyId",
        "slotId",
        "class",
        "spec",
        "name",
        "color",
        "spec_emote",
        "class_emote",
        "role_emote",
        "signuptime",
        "userid",
        "isConfirmed"
})
@Generated("jsonschema2pojo")
@Getter
public class RaidDropDTO {

    @JsonProperty("partyId")
    public Integer partyId;
    @JsonProperty("slotId")
    public Integer slotId;
    @JsonProperty("class")
    public String _class;
    @JsonProperty("spec")
    public String spec;
    @JsonProperty("name")
    public String name;
    @JsonProperty("color")
    public String color;
    @JsonProperty("spec_emote")
    public String specEmote;
    @JsonProperty("class_emote")
    public String classEmote;
    @JsonProperty("role_emote")
    public String roleEmote;
    @JsonProperty("signuptime")
    public String signuptime;
    @JsonProperty("userid")
    public String userid;
    @JsonProperty("isConfirmed")
    public String isConfirmed;

}