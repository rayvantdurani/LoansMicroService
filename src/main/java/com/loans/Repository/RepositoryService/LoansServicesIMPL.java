package com.loans.Repository.RepositoryService;

import com.loans.Entity.Loan;
import com.loans.Exception.LoanAlreadyExists;
import com.loans.Exception.LoanIdNotFound;
import com.loans.LoansDTO.LoanDTO;
import com.loans.Mapper.LoanMapper;
import com.loans.Repository.MongoDB;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.loans.Mapper.LoanMapper.UpdateLoanDetails;

@Service
@AllArgsConstructor
public class LoansServicesIMPL implements ILoanServices{


    private MongoDB mongoDB;

    @Override
    public void initiateLoan(LoanDTO loanDTO) {

        Loan loan = LoanMapper.LOANDTO_TO_LOAN(loanDTO,new Loan());
        Optional<Loan> loanvalid = mongoDB.findByloanId(loan.getLoanId());

        if(loanvalid.isPresent())
        {
            throw new LoanAlreadyExists(loanvalid.get().getLoanId());
        }
        else {
            loan.setCreateAt(LocalDateTime.now());
            loan.setCreatedBy("ADMIN");
            mongoDB.save(loan);
        }
    }

    @Override
    public void deleteLoan(Long loanId) {

        Optional<Loan> ifLoanPresnt = mongoDB.findByloanId(loanId);

        if(ifLoanPresnt.isPresent())
        {
            mongoDB.deleteById(ifLoanPresnt.get().getLoanId());
        }
        else {
            throw new LoanIdNotFound(loanId);
        }

    }

    @Override
    public void updateLoan(LoanDTO loanDto) {

        Loan updatedLoanDetails = LoanMapper.LOANDTO_TO_LOAN(loanDto,new Loan());
        Loan ifLoanPresnt = mongoDB.findByloanId(updatedLoanDetails.getLoanId())
                .orElseThrow(
                        ()-> new LoanIdNotFound(loanDto.getLoanId())
                );
        LoanMapper.UpdateLoanDetails(updatedLoanDetails,ifLoanPresnt);
        mongoDB.save(ifLoanPresnt);

    }
}
