package com.hop.ride.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RiderDetailsUpdateRequest {
    private String username;
    private String password;
    private String email;
}
