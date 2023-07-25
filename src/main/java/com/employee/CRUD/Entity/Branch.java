package com.employee.CRUD.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Branch {
    private int id;
    private String branchName;
    private String address;

}
