package com.bitc.springboard_ljw.service;

import com.bitc.springboard_ljw.dto.BoardDto;
import com.bitc.springboard_ljw.mapper.BoardMapper;
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
    public BoardDto selectBoardDetail(int idx) throws Exception {

        boardMapper.updateVistiCount(idx);

        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public void updateBoardEdit(BoardDto board) throws Exception {
        boardMapper.updateBoardEdit(board);
    }

    @Override
    public void updateBoardDelete(int idx) throws Exception {
        boardMapper.updateBoardDelete(idx);
    }

    @Override
    public void insertBoard(BoardDto board) throws Exception {
        boardMapper.insertBoard(board);
    }
}
