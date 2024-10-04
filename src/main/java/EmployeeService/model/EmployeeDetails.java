package EmployeeService.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "employeeDetails")
@Data
public class EmployeeDetails{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String address;
        private String designation;
        private String department;
        private double salary;

       // Implementing With a Foreign Key in JPA
        @OneToOne(mappedBy = "details")
        private Employee employee;
        //test
}