package com.bitc.springboard_ljw.mapper;

import com.bitc.springboard_ljw.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 반환타입이 void 인 메소드는 sql-*에서 resultType 속성이 없다

    List<BoardDto> selectBoardList() throws Exception;

    BoardDto selectBoardDetail(int idx) throws Exception;

    void updateVistiCount(int idx) throws Exception;

    void updateBoardEdit(BoardDto board) throws Exception;

    void updateBoardDelete(int idx) throws Exception;

    void insertBoard(BoardDto board) throws Exception;
}
