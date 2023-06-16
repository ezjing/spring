package com.bitc.board3.controller;

import com.bitc.board3.dto.AddressDto;
import com.bitc.board3.service.AddressService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardPageController {

    @Autowired
    private AddressService addressService;

    // required : 파라미터 값 여부 설정, true/false, true이면 파라미터 값이 반드시 존재해야 함, false이면 파라미터 값이 없어도 오류가 발생하지 않음(false 사용 시 defaultValue 속성 필수)
    // defaultValue : 사용자가 입력한 파라미터 값이 없을 경우 지정된 기본값 사용
    @RequestMapping("/page/addressList")
    public ModelAndView addressList(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("page/addressList");

        // 첫번째 매개변수는 서비스를 사용하여 DB에서 데이터 가져오기
        // 두번째 매개변수가 하나의 페이지에 출력할 페이지 버튼 수
        PageInfo<AddressDto> p = new PageInfo<>(addressService.getAddressList(pageNum), 5);

        mv.addObject("addressList", p);

        return mv;
    }
}
