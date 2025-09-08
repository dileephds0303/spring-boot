package com.employee.services;

import com.employee.entities.Employee;
import com.employee.repositories.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

   private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee saveEmployee(Employee emp) {
        logger.info("inside saveEmployee method==={}",emp);
        return employeeRepo.save(emp);
    }

    public Employee updateEmployee(Employee emp, Long id) {
       Optional<Employee> optional = employeeRepo.findById(id);
        Employee existingEmp=optional.get();
        existingEmp.setFirstName(emp.getFirstName());
        existingEmp.setLastName(emp.getLastName());
        existingEmp.setEmail(emp.getEmail());
        existingEmp.setEmpSFId(emp.getEmpSFId());
        existingEmp.setSalary(emp.getSalary());
        existingEmp.setGender(emp.getGender());

        return employeeRepo.save(existingEmp);

    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployee(Long id) {
        Optional<Employee> optional = employeeRepo.findById(id);

        return optional.get();
    }
}
