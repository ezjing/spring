package com.bitc.jpatest.service;

import com.bitc.jpatest.data.entity.EmployeesEntity;
import com.bitc.jpatest.data.repository.EmployeesRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;

    public void finds() {
        System.out.println("\n ----- findsBy() 쿼리 메소드 실행 ----- \n");
        Optional<EmployeesEntity> prod1 = this.employeesRepository.findByEmpNo(10001);
        List<EmployeesEntity> prod2 = this.employeesRepository.findAllByGender('M');    // gender는 Char 즉 Character 타입 이기 때문에 작은따옴표''를 사용해야함
        List<EmployeesEntity> prod3 = this.employeesRepository.queryByGender('G');  // query = findAll 동일 기능
        System.out.println("\n ----- findsBy() 쿼리 메소드 실행 완료 ----- \n");
    }

    public void querySelectAll() {
        System.out.println("\n ----- @Query 사용, querySelectAll() 실행 ----- \n");
        List<EmployeesEntity> prod1 = this.employeesRepository.querySelectAll();
        System.out.println("\n ----- @Query 사용, querySelectAll() 실행 완료 ----- \n");
    }

    public void querySelectName() {
        System.out.println("\n ----- @Query 사용, querySelectName() 실행 ----- \n");
        List<EmployeesEntity> prod1 = this.employeesRepository.querySelectFirstName("Akemi");   // 쿼리문 결과가 여러개 나오기 때문에 List로 받아야 하며 하나만 나온다면 EmployeesEntity 타입으로 받아도 된다 
        String string = "1994-03-31";
        LocalDate date = LocalDate.parse(string, DateTimeFormatter.ISO_DATE);
        this.employeesRepository.querySelectFirstNameHireDate("Akemi", date);   // LocalDate 타입에 데이터를 넣기위해 파싱과정을 거쳐야함
        List<EmployeesEntity> prod3 = this.employeesRepository.querySelectFirstNameGender("Akemi", 'M');    // And를 이용하여 결과가 하나만 나와도 첫번째 매개변수에서 결과가 여러개 나오기 때문에 List 타입을 사용해야 함
        System.out.println("\n ----- @Query 사용, querySelectName() 실행 완료 ----- \n");
    }
}
