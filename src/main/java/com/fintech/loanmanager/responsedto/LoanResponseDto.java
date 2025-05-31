package com.fintech.loanmanager.responsedto;

import com.fintech.loanmanager.enums.LoanType;
import com.fintech.loanmanager.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanResponseDto {
    private Long id;
    private String customerName;
    private LoanType loanType;
    private Long amount;
    private Double interestRate;
    private Status status;
    private LocalDate appliedDate;
}

