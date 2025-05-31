package com.fintech.loanmanager.model;

import com.fintech.loanmanager.enums.LoanType;
import com.fintech.loanmanager.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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

    public Loan() {
    }

    public Loan(Long id, LoanType loanType, Long amount, Double interestRate,
                Status status, LocalDate appliedDate, Customer customer) {
        this.id = id;
        this.loanType = loanType;
        this.amount = amount;
        this.interestRate = interestRate;
        this.status = status;
        this.appliedDate = appliedDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
