package com.Branch.Address.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private int empId;
    private String empName;
    private long contact;
    private String email;

    private long salary;
}
