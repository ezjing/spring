package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_employees")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empNo;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private LocalDate hireDate;

    // @ToString.Exclude   //양방향 관계 설정 시 ToString을 사용할 경우 상호 참조가 발생함, 상호참조 발생하는 것을 방지하기 위한 옵션
    @OneToMany(mappedBy = "employees")
    @ToString.Exclude
    private List<SalariesEntity> salariesList = new ArrayList<>();

    @OneToMany(mappedBy = "employees")
    @ToString.Exclude
    private List<TitlesEntity> titlesList = new ArrayList<>();
}
