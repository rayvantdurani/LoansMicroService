package com.loans.LoansDTO;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Map;


@Data
@ToString
public class LoanDTO {


    private Long loanId;
    private Long loanAmount;
    private String baseBank;
    private int tenor;



}

