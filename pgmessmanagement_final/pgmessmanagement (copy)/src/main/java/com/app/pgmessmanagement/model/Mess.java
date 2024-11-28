package com.app.pgmessmanagement.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Mess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messId;
    private String messName;
    private String location;
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Menu> menuList;
    private String image;
    private Integer userId;
    private Integer price;
    @Column(name = "CREATED_ON")
    @CreationTimestamp
    private LocalDateTime creationDate;
    @Column(name = "UPDATED_ON")
    @UpdateTimestamp
    private LocalDateTime updationDate;
}
