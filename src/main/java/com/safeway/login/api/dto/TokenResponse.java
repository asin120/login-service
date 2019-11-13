
package com.safeway.login.api.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "body",
        "meta",
        "result"
})
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class TokenResponse implements Serializable {

    @JsonProperty("body")
    private Body body;
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("result")
    private String result;
    private final static long serialVersionUID = 5453843944396218026L;


}
