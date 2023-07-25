package com.employee.CRUD.Service;

import com.employee.CRUD.Entity.Branch;
import com.employee.CRUD.Entity.Department;
import com.employee.CRUD.Entity.EmpProjection;
import com.employee.CRUD.Entity.Employee;
import com.employee.CRUD.Repository.DeptRepository;
import com.employee.CRUD.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.util.List;

@Service
public class EmpService {

@Autowired
private EmpRepository empRepository;
@Autowired
private DeptRepository deptRepository;

@Autowired
private WebClient.Builder webClientBuilder;

//@Autowired
//public EmpService(EmpRepository empRepository, DeptRepository deptRepository,
//                  WebClient.Builder webClientBuilder){
//    this.empRepository = empRepository;
//    this.deptRepository = deptRepository;
//    this.webClientBuilder = webClientBuilder;
//}


    //Create method   CCCCCCCCCCCCreate
public String saveEmployee(Employee employee){

    Department department = deptRepository.findById(employee.getDepartment().getDeptId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid department ID"));

    employee.setDeptName(department.getDeptName());
    empRepository.save(employee);

     return "Employee "+employee.getEmpName()+" added successfully";
}

    //Read or Get method   RRRRRRRRRRRRead
    public List<EmpProjection> getAllEmployees(){

        return empRepository.findAllEmployee();
    }


    //Update method    UUUUUUUUUUUUUUUpdate
    public String updateEmployee(Employee updatedEmployee) {
        Employee existingEmployee = empRepository.findById(updatedEmployee.getEmpId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        existingEmployee.setEmpName(updatedEmployee.getEmpName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setContact(updatedEmployee.getContact());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setSalary(updatedEmployee.getSalary());

         empRepository.save(existingEmployee);
         return "Employee "+existingEmployee.getEmpName()+" updated successfully";
    }

    //Delete method   DDDDDDDDDDDDDelete
    public String deleteEmployee(int empId) {
        empRepository.deleteById(empId);
        return "deleted";
    }

    //Web client
    public Flux<Branch> getBranch(){
    return webClientBuilder.build()
            .get()
            .uri("http://localhost:8091/branches/getBranches")
            .retrieve()
            .bodyToFlux(Branch.class);
    }
}
