package com.bitc.board4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_board")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class JpaBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardIdx;   // int 타입은 기본적으로 낫널 되는듯

    @Column(name = "title", length = 100, nullable = false) // nullable = false가 낫널
    private String title;

    @Column(length = 500, nullable = false)
    private String contents;

    @Column(nullable = false)
    private String createId;

    @Column(nullable = false)
    private LocalDateTime createDt = LocalDateTime.now();   // 생성되자마자 LocalDateTime.now()로 바로 현재시간 적용. 즉 기본값 세팅한것

    // 전부 기본값으로 사용 시 @Column 어노테이션을 사용하지 않아도 됨
    private String updateId;
    
    private LocalDateTime updateDt;

    @Column(nullable = false)
    private int hitCnt;
}