package com.yts.revaux.ntQuote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.mapper.QuoteMaterialMarkupMapper;
import com.yts.revaux.ntQuote.repository.QuoteMaterialMarkupRepository;

@Service
@Transactional
public class QuoteMaterialMarkupService {

	private final QuoteMaterialMarkupRepository quoteMaterialMarkupRepository;
	private final QuoteMaterialMarkupMapper quoteMaterialMarkupMapper;
	
	public QuoteMaterialMarkupService(QuoteMaterialMarkupRepository quoteMaterialMarkupRepository,
			QuoteMaterialMarkupMapper quoteMaterialMarkupMapper) {		
		this.quoteMaterialMarkupRepository = quoteMaterialMarkupRepository;
		this.quoteMaterialMarkupMapper = quoteMaterialMarkupMapper;
	}
	
	
	
}
