package EmployeeService.service;

import EmployeeService.model.Employee;

public interface EmployeeService {
    public Employee saveEmp(Employee emp);

    public Employee getEmp(int id);
}
