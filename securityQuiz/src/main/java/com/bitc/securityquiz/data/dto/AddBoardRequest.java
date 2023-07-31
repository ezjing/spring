package com.bitc.securityquiz.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.ErrorResponse;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddBoardRequest {
    private int num;
    private String title;
    private String content;
    private String id;
    private LocalDateTime postdate;
    private int visitcount;

}
