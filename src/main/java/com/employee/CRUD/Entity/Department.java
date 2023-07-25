package com.employee.CRUD.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
//@Table(uniqueConstraints = "deptId" )
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int deptId;
    private String deptName;

//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;
}
