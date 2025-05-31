package com.fintech.loanmanager.model;

import com.fintech.loanmanager.enums.LoanType;
import com.fintech.loanmanager.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private Double interestRate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private LocalDate appliedDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
