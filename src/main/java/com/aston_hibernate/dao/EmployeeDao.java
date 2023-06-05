package com.aston_hibernate.dao;

import com.aston_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee getEmployeeById(int id);

    List<Employee> listEmployees();
}
