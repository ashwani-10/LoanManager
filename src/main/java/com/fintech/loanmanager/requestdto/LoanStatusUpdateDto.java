package com.fintech.loanmanager.requestdto;

import com.fintech.loanmanager.enums.Status;
import lombok.Data;

@Data
public class LoanStatusUpdateDto {
    private Status status;
}
