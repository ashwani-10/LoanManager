package com.fintech.loanmanager.controller;

import com.fintech.loanmanager.requestdto.CustomerReqDto;
import com.fintech.loanmanager.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> customerRegistration(@RequestBody CustomerReqDto customerReqDto){
        try{
            customerService.register(customerReqDto);
            return new ResponseEntity<>("Customer Registered successfully", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Failed to register",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
