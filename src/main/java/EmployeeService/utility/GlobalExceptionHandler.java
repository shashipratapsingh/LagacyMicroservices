package EmployeeService.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle specific exception
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ApiResponse response = new ApiResponse(ex.getMessage(), Boolean.parseBoolean("something went wrong"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAllExceptions(Exception ex) {
        ApiResponse response = new ApiResponse("An error occurred: " + ex.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // Handle specific exceptions like validation errors, etc.
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
    //     String errors = ex.getBindingResult().getAllErrors().stream()
    //                       .map(ObjectError::getDefaultMessage)
    //                       .collect(Collectors.joining(", "));
    //     ApiResponse response = new ApiResponse("Validation failed: " + errors, null, HttpStatus.BAD_REQUEST);
    //     return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    // }
}
