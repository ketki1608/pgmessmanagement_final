/**
 * Author: Ajay Patil
 * Date:07/08/24
 */
package com.app.pgmessmanagement.dto;

import com.app.pgmessmanagement.model.Menu;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class MessDto {
    private Integer messId;
    private String messName;
    private String location;
    private String description;
    private Set<Menu> menuList;
    private String image;
    private Integer userId;
    private Integer price;
}
