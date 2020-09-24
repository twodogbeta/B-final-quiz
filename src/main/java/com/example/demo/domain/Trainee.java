package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainee")
public class Trainee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String office;
    private String email;
    private String zoomId;
    private Boolean grouped;
}
