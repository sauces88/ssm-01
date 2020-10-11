package com.sliny.ssm.controller;

import com.sliny.ssm.entity.Employee;
import com.sliny.ssm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date 2020/10/10 21:38
 */

@Controller
//@RestController
public class EmployeeController {
    private static final String FAILED = "failed";
    private static final String SUCCESS = "success";
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String index(){
        return "index.ftl";
    }

    @ResponseBody
    @GetMapping("/emp/get")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @ResponseBody
    @PostMapping("/emp/insert")
    public String insertEmployee(@RequestBody Employee employee){
        if (employeeService.insert(employee) < 0)
            return FAILED;
        return SUCCESS;
    }

    @ResponseBody
    @PostMapping("/emp/update")
    public String updateEmployee(@RequestBody Employee employee){
        if (employeeService.update(employee) < 0)
            return FAILED;
        return SUCCESS;
    }

    @ResponseBody
    @PostMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        if (employeeService.delete(id) < 0)
            return FAILED;
        return SUCCESS;
    }
}
