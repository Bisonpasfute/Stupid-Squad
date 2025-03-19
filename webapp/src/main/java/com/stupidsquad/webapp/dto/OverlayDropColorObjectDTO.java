package com.stupidsquad.webapp.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "class",
        "spec",
        "class_emote",
        "spec_emote",
        "role_emote",
        "isConfirmed",
        "index",
        "color"
})
@Generated("jsonschema2pojo")
@Getter
public class OverlayDropColorObjectDTO {

    @JsonProperty("class")
    public String _class;
    @JsonProperty("spec")
    public String spec;
    @JsonProperty("class_emote")
    public String classEmote;
    @JsonProperty("spec_emote")
    public String specEmote;
    @JsonProperty("role_emote")
    public String roleEmote;
    @JsonProperty("isConfirmed")
    public Boolean isConfirmed;
    @JsonProperty("index")
    public String index;
    @JsonProperty("color")
    public String color;

}