package com.bitc.jpaquiz.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")  // 프로퍼티가 validate로 설정되어 있다면 테이블과 완벽히 같은 조건이 되어야 하기 때문에 꼭 똑같은 이름으로 지정해 주어야 함
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;

    @Column(nullable = false)
    private LocalDate birthDate;    // mySQL 데이터 타입에 주의 DATE -> LocalDate, DATETIME -> LocalDateTime

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Character gender;   // mySQL 데이터 타입이 처음보는 타입이었음. 오류코드 잘 볼것 Char 타입이라고 나왔으며 Char는 Character이다

    @Column(nullable = false)
    private LocalDate hireDate;
}