package com.lec.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Write {

    private Long id;
    private String user;
    private String subject;
    private String content;
}