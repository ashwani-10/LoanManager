package com.fintech.loanmanager.service;

import com.fintech.loanmanager.mapper.CustomerMapper;
import com.fintech.loanmanager.model.Customer;
import com.fintech.loanmanager.repository.CustomerRepository;
import com.fintech.loanmanager.repository.LoanRepository;
import com.fintech.loanmanager.requestdto.CustomerReqDto;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    LoanRepository loanRepository;
    CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository,
                           LoanRepository loanRepository,
                           CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.loanRepository = loanRepository;
        this.customerMapper = customerMapper;
    }


    public void register(CustomerReqDto customerReqDto) {
        try {
            Customer customer = customerMapper.mapCustomer(customerReqDto);
            //Generate random credit score
            Integer creditScore = new Random().nextInt(301) + 500;
            customer.setCreditScore(creditScore);
            customerRepository.save(customer);

            System.out.println("Customer registered successfully");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
