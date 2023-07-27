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
    @Column(updatable = false)
    private String title;

    @Id
    @Column(updatable = false)
    private LocalDate fromDate;

    private LocalDate toDate;

    @OneToOne
    @JoinColumn(name = "emp_no")
    @ToString.Exclude
    private EmployeesEntity employeesEntity;
}
