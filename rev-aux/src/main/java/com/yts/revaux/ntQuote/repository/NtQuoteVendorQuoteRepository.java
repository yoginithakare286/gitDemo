package com.yts.revaux.ntQuote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yts.revaux.ntQuote.entity.NtQuoteVendor_Quote;

@Repository
public interface NtQuoteVendorQuoteRepository extends JpaRepository<NtQuoteVendor_Quote, Long> {}
