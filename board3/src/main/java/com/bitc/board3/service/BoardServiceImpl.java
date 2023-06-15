package com.bitc.board3.service;

import com.bitc.board3.dto.BoardDto;
import com.bitc.board3.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
        boardMapper.updateHitCount(boardIdx);
        return boardMapper.selectBoardDetail(boardIdx);
    }

    @Override
    public void insertBoard(BoardDto board) throws Exception {
        boardMapper.insertBoard(board);
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        boardMapper.deleteBoard(boardIdx);
    }

    // 매퍼와 서비스 메소드 차이. 매퍼는 모든 쿼리문을 사용하는것에 대한 데이터 다 있어야하지만 서비스는 게시판에 직접적으로 관련된 메소드만 있음 ex 조회수는 디테일 들어갈때마다 수행되는 디테일에 포함되는 쿼리문이므로 서비스에 없다
}
