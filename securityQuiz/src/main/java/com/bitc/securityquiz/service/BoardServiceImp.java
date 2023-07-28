package com.bitc.securityquiz.service;

import com.bitc.securityquiz.data.dto.AddBoardRequest;
import com.bitc.securityquiz.data.entity.Board;
import com.bitc.securityquiz.data.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImp implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> selectBoardList() {
        return boardRepository.findAllByOrderByBoardIdxDesc();
    }
}
