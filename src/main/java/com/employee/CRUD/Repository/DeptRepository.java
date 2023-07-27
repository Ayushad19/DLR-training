package com.employee.CRUD.Repository;

import com.employee.CRUD.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface DeptRepository extends JpaRepository<Department, Integer> {
//Department findByName(String deptName);
     //@Query("SELECT deptId from Department where deptName = ")
       Optional<Department> findByDeptName(String deptName);
}
