package com.bitc.xml_json_parser.controller;

import com.bitc.xml_json_parser.dto.DailyBoxOfficeDto;
import com.bitc.xml_json_parser.dto.PharmacyFullDataItemDto;
import com.bitc.xml_json_parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parse")
public class ParserController {

    @Autowired
    private ParserService parserService;

    @Value("${full505.kobis.json.DailyBoxOfficeResultUrl}")
    private String serviceUrl;

    @Value("${full505.kobis.json.key}")
    private String serviceKey;

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/pharmacy/fullDataFile")
    public ModelAndView getFullDataFile() throws Exception {
        ModelAndView mv = new ModelAndView("pharmacy/fullDataFile");

        List<PharmacyFullDataItemDto> itemList = parserService.getItemListFile("C:\\smart505\\pharmarcy.xml");
        mv.addObject("itemList", itemList);

        return mv;
    }

    @GetMapping("/pharmacy/fullDataUrl")
    public String getFullDataUrl() throws Exception {

        return "pharmacy/fullDataUrl";
    }

    @ResponseBody   // 뷰 없이 데이터만 전송할때 필요
    @PostMapping("/pharmacy/fullDataUrl")
    public Object getFullDataUrl(@RequestParam("pageNo") String pageNo, @RequestParam("numOfRows") String numOfRows) throws Exception {

        // 주소 https 로 오는데 http 로 해야 실행됨
//        http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=N9jLaOQ6gZTdZPEQTWZiXorU1DsZc17Mk8cuhrPYOFIKhTyF5KVf73ctXS9KQqobH8ZhjcyuqUxisbewnnOU7g%3D%3D&pageNo=1&numOfRows=10

        String serviceUrl = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";
        String serviceKey = "?serviceKey=";
        String key = "N9jLaOQ6gZTdZPEQTWZiXorU1DsZc17Mk8cuhrPYOFIKhTyF5KVf73ctXS9KQqobH8ZhjcyuqUxisbewnnOU7g%3D%3D";
        String opt1 = "&pageNo=";
        String opt2 = "&numOfRows=";

//        List<PharmacyFullDataItemDto> itemList = parserService.getItemListUrl("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=N9jLaOQ6gZTdZPEQTWZiXorU1DsZc17Mk8cuhrPYOFIKhTyF5KVf73ctXS9KQqobH8ZhjcyuqUxisbewnnOU7g%3D%3D&pageNo=1&numOfRows=10");

        List<PharmacyFullDataItemDto> itemList = parserService.getItemListUrl(serviceUrl + serviceKey + key + opt1 + pageNo + opt2 + numOfRows);

        return itemList;
    }

    // 영화 진흥원 일일 박스오피스 출력 View
    @GetMapping("/kobis/dailyBoxOffice")
    public String dailyBoxOfficeView() throws Exception {
        return "kobis/dailyBoxOffice";
    }

    // 영화 진흥원 일일 박스오피스 데이터 가져오기
    @ResponseBody
    @PostMapping("/kobis/dailyBoxOffice")
    public Object getDailyBoxOfficeProcess(@RequestParam("targetDt") String targetDt) throws Exception {  // 데이터를 넘길땐 반환타입 Object, @RequestParam html파일에서 받아오는 데이터에 사용

//        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + targetDt;

        String url = serviceUrl + "?key=" + serviceKey + "&targetDt=" + targetDt;

        List<DailyBoxOfficeDto> dailyBoxOfficeDtoList = parserService.getDailyBoxOfficeList(url);

//        List<DailyBoxOfficeDto> dailyBoxOfficeDtoList = parserService.getDailyBoxOfficeList(serviceUrl + "?key=" + serviceKey + "&targetDt=" + targetDt);   // 이렇게도 작동 됨

        return dailyBoxOfficeDtoList;
    }
}
