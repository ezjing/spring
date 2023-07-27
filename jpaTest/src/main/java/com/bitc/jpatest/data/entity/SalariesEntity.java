package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_salaries")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SalariesEntity extends EmpBaseEntity {

//    @Id   // 테이블을 먼저 만들고
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long empNo;

    @Column(nullable = false)
    private int salary;

    @Id
    @Column(updatable = false)
    private LocalDate fromDate;

    @Column(updatable = false)
    private LocalDate toDate;

    @Id // 관계성 설정을 해야함
    @ManyToOne
    @JoinColumn(name = "emp_no")
    @ToString.Exclude
    private EmployeesEntity employees;
}
