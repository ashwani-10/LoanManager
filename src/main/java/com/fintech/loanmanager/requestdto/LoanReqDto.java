package com.fintech.loanmanager.requestdto;

import com.fintech.loanmanager.enums.LoanType;
import lombok.Data;

@Data
public class LoanReqDto {
    private Long customerId;
    private LoanType loanType;
    private Long amount;
}
