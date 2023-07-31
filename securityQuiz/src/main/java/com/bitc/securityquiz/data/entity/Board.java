package com.bitc.securityquiz.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@DynamicUpdate
@Entity
@Table(name = "jpa_board")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto_increment 자동생성은 int 와 float 만 가능
    @Column(name = "num", updatable = false)
    private int num;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @ToString.Exclude
//    @Column(nullable = false) // 외래키를 넣을땐 @Column 어노테이션을 사용하면 안됨
    private Member member;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime postdate;

    @Column(columnDefinition = "integer default 0")
    private int visitcount;

    @Builder    // Impl 에서 쓰려면 생성자 있어야함 필수
    public Board(int num, String title, String content, Member id, LocalDateTime postdate, int visitcount, String auth) {
        this.num = num;
        this.title = title;
        this.content = content;
        this.member = id;
        this.postdate = postdate;
        this.visitcount = visitcount;
    }
}
