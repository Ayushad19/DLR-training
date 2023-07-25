package com.Branch.Address.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String branchName;
    private String address;
}
