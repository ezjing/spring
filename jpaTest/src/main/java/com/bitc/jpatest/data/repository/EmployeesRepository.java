package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Long> {
    Optional<EmployeesEntity> findByEmpNo(long empNo);
    List<EmployeesEntity> findAllByFirstName(String firstName);
}
