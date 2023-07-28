package com.bitc.securityquiz.data.repository;

import com.bitc.securityquiz.data.entity.Board;
import com.bitc.securityquiz.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findAllByOrderByBoardIdxDesc();
}
