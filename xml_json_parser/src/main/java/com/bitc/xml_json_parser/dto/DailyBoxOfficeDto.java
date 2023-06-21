package com.bitc.xml_json_parser.dto;

import lombok.Data;

@Data   // xml을 파싱할땐 @XmlRootElement 사용 차이에 주의, 필드이름 100% 똑같이 만들어야함(다르면 파싱 불가)
public class DailyBoxOfficeDto {    // dailyBoxOfficeList의 자식 항목
    private String rnum;
    private String rank;
    private String rankInten;
    private String rankOldAndNew;
    private String movieCd;
    private String movieNm;
    private String openDt;
    private String salesAmt;
    private String salesShare;
    private String salesInten;
    private String salesChange;
    private String salesAcc;
    private String audiCnt;
    private String audiInten;
    private String audiChange;
    private String audiAcc;
    private String scrnCnt;
    private String showCnt;
}
