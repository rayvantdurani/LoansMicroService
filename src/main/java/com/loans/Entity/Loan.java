package com.loans.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@Document(collection="Loans")
public class Loan {


    private Long loanId;
    @MongoId
    private Long customerId;
    private Long loanAmount;
    private String baseBank;
    private int tenor;

    @CreatedDate
    private LocalDateTime createAt;

    @CreatedBy
    private String createdBy;


    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

    @LastModifiedBy
    private String LastModifiedBy;
}
