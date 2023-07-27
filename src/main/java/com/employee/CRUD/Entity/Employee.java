package com.employee.CRUD.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "Employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "contact"),
        @UniqueConstraint(columnNames = "email")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private long contact;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deptId", referencedColumnName = "deptId")
    private Department department;
    private long salary;

    public Employee(int empId, String empName,long salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
}
