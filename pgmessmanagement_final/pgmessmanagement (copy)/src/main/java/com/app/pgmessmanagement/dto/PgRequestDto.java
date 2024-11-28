package com.app.pgmessmanagement.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PgRequestDto {
    private Integer pgId;
    private String pgName;
    private String location;
    private String description;
    private Integer price;
    private Integer roomCount;
    private Integer bookedCount;
    private String image;
    private Integer userId;
    private Boolean isFull=false;
}
