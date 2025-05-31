package com.fintech.loanmanager.controller;

import com.fintech.loanmanager.requestdto.LoanReqDto;
import com.fintech.loanmanager.requestdto.LoanStatusUpdateDto;
import com.fintech.loanmanager.responsedto.LoanResponseDto;
import com.fintech.loanmanager.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyForLoan(@RequestBody LoanReqDto loanReqDto){
        loanService.applyLoan(loanReqDto);
        return ResponseEntity.ok("Loan application submitted successfully");
    }

    @GetMapping("/view")
    public ResponseEntity<List<LoanResponseDto>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @PutMapping("/{loanId}/status")
    public ResponseEntity<String> updateLoanStatus(
            @PathVariable Long loanId,
            @RequestBody LoanStatusUpdateDto request) {

        try {
            loanService.updateLoanStatus(loanId, request.getStatus());
            return ResponseEntity.ok("Loan status updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
