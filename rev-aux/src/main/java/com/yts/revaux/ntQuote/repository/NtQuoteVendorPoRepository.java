package com.yts.revaux.ntQuote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yts.revaux.ntQuote.entity.NtQuoteVendor_Po;

@Repository
public interface NtQuoteVendorPoRepository extends JpaRepository<NtQuoteVendor_Po, Long> {}
