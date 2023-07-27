package com.bitc.jpaquiz.controller;

import com.bitc.jpaquiz.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;

    @RequestMapping({"/eQueryMethod"})
    public String eQueryMethod() throws Exception {

        this.employeesService.finds();

        return "eQueryMethod";
    }

    @RequestMapping({"/eQuery"})
    public String eQuery() throws Exception {

        this.employeesService.querySelectAll();
        this.employeesService.querySelectName();

        return "eQuery";
    }
}