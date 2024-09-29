package EmployeeService.service;

import EmployeeService.model.Employee;
import EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmp(Employee emp) {

        List<Employee> emp1=employeeRepository.findAll();
        if (emp1.size()>0) {
            return employeeRepository.save(emp);
        }else {
            return null;
        }
    }

    @Override
    public Employee getEmp(int id) {
        return this.employeeRepository.findById(id).get();
    }
}
