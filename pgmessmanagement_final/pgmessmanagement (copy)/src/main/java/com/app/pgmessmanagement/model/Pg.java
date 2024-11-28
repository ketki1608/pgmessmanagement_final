package com.app.pgmessmanagement.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Pg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "CREATED_ON")
    @CreationTimestamp
    private LocalDateTime creationDate;
    @Column(name = "UPDATED_ON")
    @UpdateTimestamp
    private LocalDateTime updationDate;

}
