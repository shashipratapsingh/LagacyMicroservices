package EmployeeService.controller;

import EmployeeService.model.Employee;
import EmployeeService.model.Project;
import EmployeeService.service.EmployeeService;
import EmployeeService.service.ProjectService;
import EmployeeService.utility.ApiResponse;
import EmployeeService.utility.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    private  EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;
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

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectService.createProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }


}
