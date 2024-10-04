package EmployeeService.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // Implementing With a Foreign Key in JPA
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeDetails_id", referencedColumnName = "id")
    private EmployeeDetails details;
}
