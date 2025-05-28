package com.yts.revaux.ntQuote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.mapper.QuoteProfitMapper;
import com.yts.revaux.ntQuote.repository.QuoteProfitRepository;

@Service
@Transactional
public class QuoteProfitService {

	private final QuoteProfitRepository quoteProfitRepository;
	private final QuoteProfitMapper quoteProfitMapper;

	public QuoteProfitService(QuoteProfitRepository quoteProfitRepository, QuoteProfitMapper quoteProfitMapper) {
	
		this.quoteProfitRepository = quoteProfitRepository;
		this.quoteProfitMapper = quoteProfitMapper;
	}
	
	
	
}
