package com.bitc.securityquiz.data.repository;

import com.bitc.securityquiz.data.dto.AddBoardRequest;
import com.bitc.securityquiz.data.entity.Board;
import com.bitc.securityquiz.data.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findAllByOrderByNumDesc();


    Board findByNum(int num);

    void deleteByNum(int num);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Board b SET b.title = :#{#board.title}, b.member.id = :#{#board.id}, b.content = :#{#board.content}, b.postdate = NOW() WHERE b.num = :#{#board.num}")
    void boardEdit(@Param("board") AddBoardRequest board);
}
