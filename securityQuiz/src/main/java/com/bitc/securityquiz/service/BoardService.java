package com.bitc.securityquiz.service;

import com.bitc.securityquiz.data.dto.AddBoardRequest;
import com.bitc.securityquiz.data.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> selectBoardList() throws Exception;
}
