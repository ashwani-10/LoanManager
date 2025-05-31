package com.fintech.loanmanager.responsedto;

import com.fintech.loanmanager.enums.LoanType;
import com.fintech.loanmanager.enums.Status;
import lombok.Data;

import java.time.LocalDate;

public class LoanResponseDto {
    private Long id;
    private String customerName;
    private LoanType loanType;
    private Long amount;
    private Double interestRate;
    private Status status;
    private LocalDate appliedDate;

    public LoanResponseDto() {
    }

    public LoanResponseDto(Long id, String customerName, LoanType loanType, Long amount,
                           Double interestRate, Status status, LocalDate appliedDate) {
        this.id = id;
        this.customerName = customerName;
        this.loanType = loanType;
        this.amount = amount;
        this.interestRate = interestRate;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
}

