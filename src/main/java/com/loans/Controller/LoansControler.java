package com.loans.Controller;


import com.loans.Constants.LoanHTTPConstants;
import com.loans.LoansDTO.LoanDTO;
import com.loans.LoansDTO.ResponseDTO;
import com.loans.Repository.RepositoryService.ILoanServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="${base.url}")
public class LoansControler {


    @Autowired
    private ILoanServices iLoanServices;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> initiateLoan(@RequestBody LoanDTO loanDTO)
    {

        iLoanServices.initiateLoan(loanDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(LoanHTTPConstants.STATUS_201,LoanHTTPConstants.MESSAGE_200));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteLoan(@RequestParam Long loanId)
    {
        iLoanServices.deleteLoan(loanId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDTO(LoanHTTPConstants.STATUS_200,LoanHTTPConstants.MESSAGE_200));
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateLoan(@RequestBody LoanDTO loanDTO)
    {
        iLoanServices.updateLoan(loanDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO(LoanHTTPConstants.STATUS_200,LoanHTTPConstants.MESSAGE_200));
    }


}
