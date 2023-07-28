package com.employee.CRUD.Repository;

import com.employee.CRUD.Entity.EmpProjection;
import com.employee.CRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
//Use native query to fetch only employee name and salary
@Query("SELECT new com.employee.CRUD.Entity.Employee(e.empId, e.empName, e.salary, e.department) FROM Employee e JOIN e.department")
List<EmpProjection> findAllEmployeesWithDepartment();

//    @Query("SELECT new com.employee.CRUD.Entity.Employee(e.empId, e.empName, e.salary, e.department) FROM Employee e JOIN FETCH e.department")
//    List<EmpProjection> findAllEmployeesWithDepartment();
//    @Query("SELECT empName, salary FROM Employees")
//    List<Employee> findAllEmployee();
}
