package com.bitc.securityquiz.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddMemberRequest {

    private String id;
    private String pass;
    private String name;
    private LocalDateTime regidate;
    private int grade;
}
