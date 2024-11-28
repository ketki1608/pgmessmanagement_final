package com.app.pgmessmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    @JsonProperty("password")
    private String watchWord;
    private String contactNumber;
    private Boolean isAdmin=false;
    @Column(name = "CREATED_ON")
    @CreationTimestamp
    private LocalDateTime creationDate;
    @Column(name = "UPDATED_ON")
    @UpdateTimestamp
    private LocalDateTime updationDate;
}
