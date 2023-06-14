package com.bitc.board2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Getter, @Setter, @Data 같이 써도 문제 없음
@Getter
@Setter
@Data
public class Board2Dto {
    private int boardIdx;
    private String title;
    private String contents;
    private String createId;
    private String createDt;
    private String updateId;
    private String updateDt;
    private int hitCnt;
}