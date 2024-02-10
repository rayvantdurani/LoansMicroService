package com.loans.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoanIdNotFound extends RuntimeException{


    public LoanIdNotFound(Long loanId)
    {
        super(String.format("The Loan with Loan ID %s doesn't exist ",loanId));
    }
}
