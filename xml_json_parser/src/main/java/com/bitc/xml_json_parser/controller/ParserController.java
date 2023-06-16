package com.bitc.xml_json_parser.controller;

import com.bitc.xml_json_parser.dto.PharmacyFullDataItemDto;
import com.bitc.xml_json_parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parse")
public class ParserController {

    @Autowired
    private ParserService parserService;

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
}
