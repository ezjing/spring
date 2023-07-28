package com.bitc.jpaquiz2.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "jpa_employees")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesEntity extends BaseEntity{

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

    // (mappedBy = "employees")를 쓰면 자꾸 오류나면서 안되는데 왜그런지 물어보기(employees(테이블 명)가 아니고 서브 테이블에서 만든 객체 명(employeesEntity)이 들어와야함)
//    @OneToOne(mappedBy = "employeesEntity")
//    @ToString.Exclude
//    private SalariesEntity salariesEntity;
//
//    @OneToOne(mappedBy = "employeesEntity")
//    @ToString.Exclude
//    private TitlesEntity titlesEntity;
}
