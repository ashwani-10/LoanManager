package com.fintech.loanmanager.requestdto;

import lombok.Data;

@Data
public class CustomerReqDto {
    private String name;
    private String email;
    private String phone;
    private String address;
}
