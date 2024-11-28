/**
 * Author: Ajay Patil
 * Date:07/08/24
 */
package com.app.pgmessmanagement.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookPgDto {
    private Integer id;
    private Integer userId;
    private Integer pgId;
    private Integer ownerUserId;
}
