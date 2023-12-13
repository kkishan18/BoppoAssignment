package com.kishan.service;


import java.util.List;

import com.kishan.model.Employee;


public interface EmployeeService {

	public List<Employee> getAllemployees();

	public Employee addEmployee(Employee emp);

	public Employee updateEmployee(Integer empId, Employee emp);

	public String deleteEmployee(Integer empId);

	public List<Employee> getEmployeesByDept(String deptName);
}