package com.fintech.loanmanager.service;

import com.fintech.loanmanager.enums.Status;
import com.fintech.loanmanager.model.Customer;
import com.fintech.loanmanager.model.Loan;
import com.fintech.loanmanager.repository.CustomerRepository;
import com.fintech.loanmanager.repository.LoanRepository;
import com.fintech.loanmanager.requestdto.LoanReqDto;
import com.fintech.loanmanager.responsedto.LoanResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    public LoanService(LoanRepository loanRepository, CustomerRepository customerRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
    }

    public void applyLoan(LoanReqDto request) {
            if (request.getAmount() < 0) throw new IllegalArgumentException("Loan amount cannot be less than 0");

            try{
            Customer customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

            if(customer.getCreditScore() < 550) throw new IllegalArgumentException("Customer is not eligible for applying for a loan");

            // calculate interest rate
            double interestRate = calculateInterestRate(customer.getCreditScore());

            Loan loan = new Loan();
            loan.setLoanType(request.getLoanType());
            loan.setAmount(request.getAmount());
            loan.setAppliedDate(LocalDate.now());
            loan.setStatus(Status.PENDING);
            loan.setInterestRate(interestRate);
            loan.setCustomer(customer);
            loanRepository.save(loan);
        }catch (Exception e) {
            throw new RuntimeException("Failed applying for loan: " + e.getMessage(), e);
        }
    }

    private double calculateInterestRate(int creditScore) {
        if (creditScore >= 750) return 7.5;
        else if (creditScore >= 650) return 10.0;
        else return 13.5;
    }

    public List<LoanResponseDto> getAllLoans() {
        List<Loan> loans = loanRepository.findAll();
        List<LoanResponseDto> responseList = new ArrayList<>();

        for (Loan loan : loans) {
            LoanResponseDto dto = new LoanResponseDto();
            dto.setId(loan.getId());
            dto.setCustomerName(loan.getCustomer().getName());
            dto.setLoanType(loan.getLoanType());
            dto.setAmount(loan.getAmount());
            dto.setInterestRate(loan.getInterestRate());
            dto.setStatus(loan.getStatus());
            dto.setAppliedDate(loan.getAppliedDate());

            responseList.add(dto);
        }

        return responseList;
    }

    public void updateLoanStatus(Long loanId, Status status) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.getStatus() != Status.PENDING) {
            throw new RuntimeException("Loan already processed");
        }

        loan.setStatus(status);
        loanRepository.save(loan);
    }

}

