package com.yts.revaux.ntQuote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yts.revaux.ntQuote.entity.RfqDetailTbl;

@Repository
public interface RfqDetailTblRepository extends JpaRepository<RfqDetailTbl, String> {}

