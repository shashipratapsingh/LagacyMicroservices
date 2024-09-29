package EmployeeService.utility;

import EmployeeService.model.Employee;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse <T>{
    private String message;
    private boolean success;
    private T data;

    public ApiResponse(String message ,boolean success,T data) {
        this.message=message;
        this.success=success;
        this.data=data;
    }
    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(String employeeSavedSuccessfully, Employee savedEmployee, HttpStatus httpStatus) {
        this.message=message;

    }
}
