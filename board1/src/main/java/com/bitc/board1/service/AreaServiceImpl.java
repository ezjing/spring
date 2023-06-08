package com.bitc.board1.service;

import com.bitc.board1.dto.AreaDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{

    @Override
    public List<AreaDto> getDistrictList(String cityName) throws Exception {
        List<AreaDto> districtList = new ArrayList<>();

        switch (cityName) {
            case "서울" :
                AreaDto se1 = new AreaDto();
                AreaDto se2 = new AreaDto();
                AreaDto se3 = new AreaDto();
                AreaDto se4 = new AreaDto();

                se1.setAreaName("강북구");
                se2.setAreaName("강남구");
                se3.setAreaName("강서구");
                se4.setAreaName("강동구");

                districtList.add(se1);
                districtList.add(se2);
                districtList.add(se3);
                districtList.add(se4);
                break;

            case "대전" :
                AreaDto dj1 = new AreaDto();
                AreaDto dj2 = new AreaDto();
                AreaDto dj3 = new AreaDto();
                AreaDto dj4 = new AreaDto();

                dj1.setAreaName("동구");
                dj2.setAreaName("중구");
                dj3.setAreaName("서구");
                dj4.setAreaName("유성구");

                districtList.add(dj1);
                districtList.add(dj2);
                districtList.add(dj3);
                districtList.add(dj4);
                break;

            case "대구" :
                AreaDto dg1 = new AreaDto();
                AreaDto dg2 = new AreaDto();
                AreaDto dg3 = new AreaDto();
                AreaDto dg4 = new AreaDto();

                dg1.setAreaName("달서구");
                dg2.setAreaName("달서군");
                dg3.setAreaName("수성구");
                dg4.setAreaName("중구");

                districtList.add(dg1);
                districtList.add(dg2);
                districtList.add(dg3);
                districtList.add(dg4);
                break;

            case "부산" :
                AreaDto bs1 = new AreaDto();
                AreaDto bs2 = new AreaDto();
                AreaDto bs3 = new AreaDto();
                AreaDto bs4 = new AreaDto();

                bs1.setAreaName("부산진구");
                bs2.setAreaName("해운대구");
                bs3.setAreaName("동래구");
                bs4.setAreaName("영도구");

                districtList.add(bs1);
                districtList.add(bs2);
                districtList.add(bs3);
                districtList.add(bs4);
                break;
        }
        return districtList;
    }

    @Override
    public List<AreaDto> getTownList(String districtName) throws Exception {
        List<AreaDto> townList = new ArrayList<>();

        switch (districtName) {
            case "강남구" :
                AreaDto kn1 = new AreaDto();
                AreaDto kn2 = new AreaDto();
                AreaDto kn3 = new AreaDto();
                AreaDto kn4 = new AreaDto();

                kn1.setAreaName("강남1동");
                kn2.setAreaName("강남2동");
                kn3.setAreaName("강남3동");
                kn4.setAreaName("강남4동");

                townList.add(kn1);
                townList.add(kn2);
                townList.add(kn3);
                townList.add(kn4);
                break;
            case "부산진구" :
                AreaDto jg1 = new AreaDto();
                AreaDto jg2 = new AreaDto();
                AreaDto jg3 = new AreaDto();
                AreaDto jg4 = new AreaDto();

                jg1.setAreaName("진구1동");
                jg2.setAreaName("진구2동");
                jg3.setAreaName("진구3동");
                jg4.setAreaName("진구4동");

                townList.add(jg1);
                townList.add(jg2);
                townList.add(jg3);
                townList.add(jg4);
                break;
            case "유성구" :
                AreaDto us1 = new AreaDto();
                AreaDto us2 = new AreaDto();
                AreaDto us3 = new AreaDto();
                AreaDto us4 = new AreaDto();

                us1.setAreaName("유성1동");
                us2.setAreaName("유성2동");
                us3.setAreaName("유성3동");
                us4.setAreaName("유성4동");

                townList.add(us1);
                townList.add(us2);
                townList.add(us3);
                townList.add(us4);
                break;
            case "수성구" :
                AreaDto ss1 = new AreaDto();
                AreaDto ss2 = new AreaDto();
                AreaDto ss3 = new AreaDto();
                AreaDto ss4 = new AreaDto();

                ss1.setAreaName("수성1동");
                ss2.setAreaName("수성2동");
                ss3.setAreaName("수성3동");
                ss4.setAreaName("수성4동");

                townList.add(ss1);
                townList.add(ss2);
                townList.add(ss3);
                townList.add(ss4);
                break;

        }
        return null;
    }
}
