package com.fintech.loanmanager.mapper;

import com.fintech.loanmanager.model.Customer;
import com.fintech.loanmanager.requestdto.CustomerReqDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer mapCustomer(CustomerReqDto customerReqDto){
        Customer customer = new Customer();
        customer.setName(customerReqDto.getName());
        customer.setEmail(customerReqDto.getEmail());
        customer.setPhone(customerReqDto.getPhone());
        customer.setAddress(customerReqDto.getAddress());

        return customer;
    }
}
