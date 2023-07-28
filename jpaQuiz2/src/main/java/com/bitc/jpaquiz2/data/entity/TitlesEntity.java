package com.bitc.jpaquiz2.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "jpa_titles")
@Getter
@Setter
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)  // empNo가 외래키로 설정되어 있기 때문에 기본 엔티티를 받으면 안된다
@NoArgsConstructor
@AllArgsConstructor
public class TitlesEntity {  //  extends BaseEntity 기본 엔티티 상속 생략

    @Id
    @Column(nullable = false)
    private String title;

    @Id
    @Column(nullable = false)
    private LocalDate fromDate;

    private LocalDate toDate;

    @Id
    @OneToOne   // @OneToOne이 아니고 @ManyToOne이 맞음 각각의 테이블에서 emp_no = 10009 으로 검색해보면 샐러리, 타이틀 테이블에서 여러 종류의 값이 출력됨
    @JoinColumn(name = "emp_no")
    @ToString.Exclude
    private EmployeesEntity employeesEntity;
}
