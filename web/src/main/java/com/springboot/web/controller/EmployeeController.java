package com.springboot.web.controller;

import com.springboot.web.dao.EmployeeDao;
import com.springboot.web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){

        Set<Employee> employeeSet = new HashSet<>();
        Collection<Employee> employees = employeeDao.getAll();
//        List<Employee> employeeList = new ArrayList<>(employees);

        //放在请求域中
        model.addAttribute("emps",employees);


        return "emp/list";
    }
}
