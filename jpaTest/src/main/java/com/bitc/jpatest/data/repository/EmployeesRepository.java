package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.EmployeesEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 데이터 타입에 주의!!!
public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {
    Optional<EmployeesEntity> findByEmpNo(int empNo);

    List<EmployeesEntity> findAllByGender(Character gender);

    List<EmployeesEntity> queryByGender(Character gender);

    @Query("SELECT e FROM EmployeesEntity AS e")
    List<EmployeesEntity> querySelectAll();

    @Query("SELECT e FROM EmployeesEntity AS e WHERE e.firstName = ?1")
    List<EmployeesEntity> querySelectFirstName(String firstName);

    @Query("SELECT e FROM EmployeesEntity AS e WHERE e.firstName = ?1 AND e.hireDate = ?2")
    List<EmployeesEntity> querySelectFirstNameHireDate(String firstName, LocalDate hireDate);

    @Query("SELECT e FROM EmployeesEntity AS e WHERE e.firstName = :firstName AND e.gender = :gender")
    List<EmployeesEntity> querySelectFirstNameGender(String firstName, Character gender);
}
