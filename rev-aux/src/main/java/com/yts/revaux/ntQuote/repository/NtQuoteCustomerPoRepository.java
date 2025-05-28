package com.yts.revaux.ntQuote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yts.revaux.ntQuote.entity.NtQuoteCustomer_Po;

@Repository
public interface NtQuoteCustomerPoRepository extends JpaRepository<NtQuoteCustomer_Po, Long> {}
