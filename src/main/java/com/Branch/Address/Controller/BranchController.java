package com.Branch.Address.Controller;

import com.Branch.Address.Entity.Branch;
import com.Branch.Address.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @PostMapping(path = "saveBranch")
    public String saveBranch(@RequestBody Branch branch){
        return branchService.saveBranch(branch);
    }

    @GetMapping(path = "getBranches")
    public List<Branch> getAllBranches(){
        return branchService.getAllBranches();
    }
}
