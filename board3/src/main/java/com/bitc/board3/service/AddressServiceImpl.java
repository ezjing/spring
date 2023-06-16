package com.bitc.board3.service;

import com.bitc.board3.dto.AddressDto;
import com.bitc.board3.mapper.AddressMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressMapper addressMapper;

    // PageInfo : PageHelper 라이브러리에서 제공하는 클래스  (html 파일에 <p th:text="${addressList}"></p> 넣으면 확인 가능)
    // 아래와 같이 페이징에 관련된 정보를 제공하고 있음
    // pageNum : 현재 페이지 번호
    // pageSize : 현재 페이지 수량
    // size : 현재 페이지 수
    // startRow : 현재 페이지의 첫번째 요소가 데이터 베이스에 있는 줄 번호
    // endRow : 현재 페이지의 마지막 요소가 데이터 베이스에 있는 줄 번호
    // pages : 전체 페이지 수
    // prePage : 이전 페이지
    // nextPage : 다음 페이지
    // isFirstPage : 현재 페이지가 첫 페이지 여부 확인, true/false
    // isLastPage : 현재 페이지가 마지막 페이지 여부 확인, true/false
    // hasPreviousPage : 이전 페이지가 존재하는지 여부, true/false
    // hasNextPage : 다음 페이지가 존재하는지 여부, true/false
    // navigatePages : 네비게이션 페이지 번호
    // navigatepageNums : 전체 네비게이션 페이지 번호, 배열로 구성
    // navigateFirstPage : 네비게이션 바의 첫 페이지
    // navigateLastPage : 네비게이션 바의 마지막 페이지

    @Override
    public Page<AddressDto> getAddressList(int pageNum) throws Exception {  // Page는 그냥 기능이 좀 추가된 List라고 생각하면 됨
        // 첫번째 매개변수 : 현재 페이지 번호
        // 두번째 매개변수 : 현재 페이지에 출력한 게시물 수
        // PageHelper 라이브러리가 mapper를 사용하여 전체 데이터를 불러온 후 자동으로 제어함
        // mapper의 sql문에 limit로 개수 제한을 할 필요가 없음
        PageHelper.startPage(pageNum, 20);
        return addressMapper.getAddressList();
    }
}
