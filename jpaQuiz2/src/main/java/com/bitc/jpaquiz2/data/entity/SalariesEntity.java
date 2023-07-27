package com.bitc.jpaquiz2.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "jpa_salaries")
@Getter
@Setter
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)  // empNo가 외래키로 설정되어 있기 때문에 기본 엔티티를 받으면 안된다
@NoArgsConstructor
@AllArgsConstructor
public class SalariesEntity {  //  extends BaseEntity 기본 엔티티 상속 생략

    @Column(nullable = false)
    private int salary;

    @Id
    @Column(updatable = false)
    private LocalDate fromDate;

    @Column(updatable = false)
    private LocalDate toDate;

    @Id
    @OneToOne
    @JoinColumn(name = "emp_no")
    @ToString.Exclude
    private EmployeesEntity employeesEntity;
}
