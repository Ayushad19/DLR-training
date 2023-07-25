package com.employee.CRUD.Controller;
import com.employee.CRUD.Entity.Branch;
import com.employee.CRUD.Entity.EmpProjection;
import com.employee.CRUD.Entity.Employee;
import com.employee.CRUD.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmpController {
    @Autowired
    private EmpService empService;

    @PostMapping(path = "/addEmployee")
    public String saveEmployee(@RequestBody Employee employee){
    return empService.saveEmployee(employee);
    }

    @GetMapping(path = "/getAllEmployees")
    public List<EmpProjection> getAllEmployees(){
    return empService.getAllEmployees();
    }
    @PutMapping(path = "/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
    return empService.updateEmployee(employee);
    }

    @DeleteMapping(path = "/deleteEmployees")
    public String deleteEmployee(@RequestBody Employee employee){
    return empService.deleteEmployee(employee.getEmpId());
    }

    @GetMapping(path = "/getBranches")
    public Flux<Branch> getBranch(){
        return empService.getBranch();
    }
}
