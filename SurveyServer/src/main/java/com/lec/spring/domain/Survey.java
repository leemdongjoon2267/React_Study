package com.lec.spring.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "R_Survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Column(nullable = false)
    private String name; // 필수

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING) // Enum + 기본 MALE
    private Gender gender = Gender.MALE;

    @Column(nullable = false)
    private String area;

    private String favorite;

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {

        this.createdAt = LocalDateTime.now();

    }
}


