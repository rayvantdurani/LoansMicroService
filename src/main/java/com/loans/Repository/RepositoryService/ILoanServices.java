package com.loans.Repository.RepositoryService;

import com.loans.LoansDTO.LoanDTO;

public interface ILoanServices {

    void initiateLoan(LoanDTO loanDTO);


    LoanDTO getLoanDetails(Long customerId);

    void deleteLoan(Long loanId);

    void updateLoan(LoanDTO loanDto);
}
