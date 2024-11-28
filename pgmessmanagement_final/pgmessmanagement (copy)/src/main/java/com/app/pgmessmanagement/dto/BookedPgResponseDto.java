/**
 * Author: Ajay Patil
 * Date:07/08/24
 */
package com.app.pgmessmanagement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookedPgResponseDto {
    private Integer pgId;
    private String pgName;
    private String location;
    private String description;
    private Integer price;
    private Integer roomCount;
    private Integer bookedCount;
    private String image;
    private String bookedBy;
    private String contactNumber;
    private Boolean isFull;
}
