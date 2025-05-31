package com.fintech.loanmanager.requestdto;

import com.fintech.loanmanager.enums.Status;
import lombok.Data;

public class LoanStatusUpdateDto {
    private Status status;

    public LoanStatusUpdateDto() {
    }

    public LoanStatusUpdateDto(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
