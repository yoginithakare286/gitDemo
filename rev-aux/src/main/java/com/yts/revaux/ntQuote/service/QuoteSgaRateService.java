package com.yts.revaux.ntQuote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.mapper.QuoteSgaRateMapper;
import com.yts.revaux.ntQuote.repository.QuoteSgaRateRepository;

@Service
@Transactional
public class QuoteSgaRateService {

	private final QuoteSgaRateRepository quoteSgaRateRepository;
	private final QuoteSgaRateMapper quoteSgaRateMapper;
	
	
	public QuoteSgaRateService(QuoteSgaRateRepository quoteSgaRateRepository, QuoteSgaRateMapper quoteSgaRateMapper) {
		
		this.quoteSgaRateRepository = quoteSgaRateRepository;
		this.quoteSgaRateMapper = quoteSgaRateMapper;
	}



}
