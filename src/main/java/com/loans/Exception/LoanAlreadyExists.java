package com.loans.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoanAlreadyExists extends RuntimeException{


    public LoanAlreadyExists(Long loanId)
    {

        super(String.format(" Loan Already Exists with Loan ID %s",loanId));
    }
}
