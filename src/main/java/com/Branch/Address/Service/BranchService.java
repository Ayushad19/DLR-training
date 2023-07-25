package com.Branch.Address.Service;

import com.Branch.Address.Entity.Branch;
import com.Branch.Address.Entity.Employee;
import com.Branch.Address.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private WebClient employeeWebClient;

    @Autowired
    public BranchService(BranchRepository branchRepository, WebClient employeeWebClient){
        this.branchRepository = branchRepository;
        this.employeeWebClient = employeeWebClient;
    }

    public String saveBranch(Branch branch){
        branchRepository.save(branch);
        return branch.getBranchName();
    }

    public List<Branch> getAllBranches(){
        return branchRepository.findAll();
    }
//    public Flux<Employee> getEmployee(){
//    return employeeWebClient
//            .get()
//            .uri("/getAllEmployees")
//            .retrieve()
//            .bodyToFlux(Employee.class);
//    }

}
