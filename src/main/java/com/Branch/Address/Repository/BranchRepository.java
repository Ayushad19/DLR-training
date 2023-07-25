package com.Branch.Address.Repository;

import com.Branch.Address.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
