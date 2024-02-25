package com.loans.Repository;

import com.loans.Entity.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoDB extends MongoRepository<Loan, Long> {

    Optional<Loan> findBycustomerId(Long loanId);
}
