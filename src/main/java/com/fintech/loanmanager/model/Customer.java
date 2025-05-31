package com.fintech.loanmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer creditScore;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Loan> loans;

}
