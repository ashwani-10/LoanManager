package com.fintech.loanmanager.requestdto;

import com.fintech.loanmanager.enums.LoanType;
import lombok.Data;

public class LoanReqDto {
    private Long customerId;
    private LoanType loanType;
    private Long amount;

    public LoanReqDto() {
    }

    public LoanReqDto(Long customerId, LoanType loanType, Long amount) {
        this.customerId = customerId;
        this.loanType = loanType;
        this.amount = amount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
}
