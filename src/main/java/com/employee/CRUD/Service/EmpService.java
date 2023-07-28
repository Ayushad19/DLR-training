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
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EmpService {

@Autowired
private EmpRepository empRepository;
@Autowired
private DeptRepository deptRepository;

@Autowired
private WebClient.Builder webClientBuilder;

@Autowired
public EmpService(EmpRepository empRepository, DeptRepository deptRepository,
                  WebClient.Builder webClientBuilder){
    this.empRepository = empRepository;
    this.deptRepository = deptRepository;
    this.webClientBuilder = webClientBuilder;
}


    //Create method   CCCCCCCCCCCCreate

    public Employee saveEmployee(Employee employee) {
    int deptId;
    if (deptRepository.findByDeptName(employee.getDepartment().getDeptName()).isPresent()){
        deptId = deptRepository.findByDeptName(employee.getDepartment().getDeptName()).get().getDeptId();
        employee.getDepartment().setDeptId(deptId);

    }else {
        deptRepository.save(employee.getDepartment());
    }


        return empRepository.save(employee);
}

    //Read or Get method   RRRRRRRRRRRRead
    public List<EmpProjection> getAllEmployees(){

        return empRepository.findAllEmployeesWithDepartment();
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
    //GET
    public Flux<Branch> getBranch(){
    return webClientBuilder.build()
            .get()
            .uri("http://localhost:8091/branches/getBranches")
            .retrieve()
            .bodyToFlux(Branch.class);
    }
    //POST
    public Flux<Branch> savingBranch(Branch branch){
        return webClientBuilder.build()
                .post()
                .uri("http://localhost:8091/branches/saveBranch")
                .body(Mono.just(getBranch()), Branch.class)
                .retrieve()
                .bodyToFlux(Branch.class);
    }
}
