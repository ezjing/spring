package com.bitc.xml_json_parser.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoxOfficeResultDto {   // boxOfficeResult의 자식 항목
    private String boxofficeType;
    private String showRange;
    private List<DailyBoxOfficeDto> dailyBoxOfficeList = null;  // 데이터타입 DailyBoxOfficeDto 지정
}
