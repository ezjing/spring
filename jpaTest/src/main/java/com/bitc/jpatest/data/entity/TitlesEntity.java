package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "jpa_titles")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TitlesEntity extends EmpBaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long empNo;

    @Id
    @Column(updatable = false)
    private String title;

    @Id
    @Column(updatable = false)
    private LocalDate fromDate;

    @Id
    @ManyToOne
    @JoinColumn(name = "emp_no")
    @ToString.Exclude
    private EmployeesEntity employees;
}
