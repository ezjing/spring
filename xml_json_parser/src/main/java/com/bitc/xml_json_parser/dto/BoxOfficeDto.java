package com.bitc.xml_json_parser.dto;

import lombok.Data;

@Data
public class BoxOfficeDto { // 제일 큰 data 타입 최상위 항목
    private  BoxOfficeResultDto boxOfficeResult;    // 제이슨은 오브젝트 타입으로 되어있기 때문에 가져 올때는 BoxOfficeResultDto 타입으로 지정해줘야 함
}
