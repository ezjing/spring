package com.bitc.springboard_ljw.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int idx;
    private String title;
    private String contents;
    private String createId;
    private String createDt;
    private String updateId;
    private String updateDt;
    private int visitCount;
}
