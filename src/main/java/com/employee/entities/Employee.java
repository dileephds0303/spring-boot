package com.employee.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_employee",schema = "emp_mng")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer empSFId;
    private Double salary;
    private String gender;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String email, Integer empSFId, Double salary, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.empSFId = empSFId;
        this.salary = salary;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmpSFId() {
        return empSFId;
    }

    public void setEmpSFId(Integer empSFId) {
        this.empSFId = empSFId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", empSFId=" + empSFId +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}
