package com.loans.Mapper;

import com.loans.Entity.Loan;
import com.loans.LoansDTO.LoanDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public class LoanMapper {


    private LoanMapper()
    {

    }

        /**
     * Converts LoanDTO Object to Loan Object(dataBase)
     * @param loanDto
     * @param loan
     * @return Loan Object to store in DB
     */
    public static Loan LOANDTO_TO_LOAN (LoanDTO loanDto ,Loan loan)
    {
        loan.setLoanId(loanDto.getLoanId());
        loan.setCustomerId(loanDto.getCustomerId());
        loan.setLoanAmount(loanDto.getLoanAmount());
        loan.setTenor(loanDto.getTenor());
        loan.setBaseBank(loan.getBaseBank());

        loan.setLastModifiedBy("ADMIN_1"+" "+LocalDateTime.now());
        loan.setLastModifiedTime(LocalDateTime.now());

        return loan;
    }

    /**
     * Converts Loan object to LoanDTO Object
     * @param loan
     * @param loanDto
     * @return LOANDTO Object for Client
     */
    public static LoanDTO LOAN_ToLOANDTO (Loan loan,LoanDTO loanDto )
    {

        loanDto.setLoanId(loan.getLoanId());
        loanDto.setCustomerId(loan.getCustomerId());
        loanDto.setLoanAmount(loan.getLoanAmount());
        loanDto.setTenor(loan.getTenor());
        loanDto.setBaseBank(loan.getBaseBank());
        return loanDto;
    }

    public static Loan UpdateLoanDetails(Loan newLoanDetails, Loan oldLoanDetails)
    {
        oldLoanDetails.setLoanAmount(newLoanDetails.getLoanAmount());
        oldLoanDetails.setTenor(newLoanDetails.getTenor());
        oldLoanDetails.setBaseBank(newLoanDetails.getBaseBank());
        oldLoanDetails.setLastModifiedTime(LocalDateTime.now());
        oldLoanDetails.setLastModifiedBy("ADMIN "+LocalDateTime.now());

        return oldLoanDetails;

    }




}
