package EmployeeService.controller;

import EmployeeService.model.Employee;
import EmployeeService.service.EmployeeService;
import EmployeeService.utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    private  EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity saveEmp(@RequestBody Employee emp){
        try {
            Employee savedEmployee = employeeService.saveEmp(emp);
            ApiResponse response = new ApiResponse("Employee saved successfully", savedEmployee, HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save employee: " + e.getMessage());
        }
    }

    @GetMapping("/getEmp/{id}")
    public ResponseEntity getEmployeeById(@PathVariable int id){
        int p=this.employeeService.getEmp(id).getId();
       if(p==-1){
           ApiResponse response = new ApiResponse("Employee not found", null, HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity<>(this.employeeService.getEmp(id),HttpStatus.OK);
    }
}
