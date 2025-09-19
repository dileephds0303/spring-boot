package com.employee.controllers;

import com.employee.entities.Employee;
import com.employee.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp,@PathVariable Long id){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(emp,id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(@RequestParam("pageNumber") int pageNumber,
                                                       @RequestParam("pageSize") int pageSize){
        return new ResponseEntity<Page<Employee>>(employeeService.getEmployees(pageNumber,pageSize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){

        return new ResponseEntity<String>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }

}
