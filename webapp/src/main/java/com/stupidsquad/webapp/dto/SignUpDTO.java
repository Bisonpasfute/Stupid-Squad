package com.stupidsquad.webapp.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "entryTime",
        "specName",
        "name",
        "className",
        "id",
        "userId"
})
@Generated("jsonschema2pojo")
@Data
public class SignUpDTO {

    @JsonProperty("entryTime")
    public Integer entryTime;
    @JsonProperty("specName")
    public String specName;
    @JsonProperty("name")
    public String name;
    @JsonProperty("className")
    public String className;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("userId")
    public String userId;

}