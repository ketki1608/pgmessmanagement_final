package com.app.pgmessmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    @NotBlank(message = "User name is must")
    private String userName;
    @NotBlank(message = "Password is must")
    @JsonProperty("password")
    private String watchWord;
    private Boolean isAdmin;
    private Integer userId;
    private String contactNumber;
}
