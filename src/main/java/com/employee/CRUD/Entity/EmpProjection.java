package com.employee.CRUD.Entity;

public interface EmpProjection {

    int getEmpId();
    String getEmpName();
    Long getSalary();

   // String getDeptName();
    Department getDepartment();

}
