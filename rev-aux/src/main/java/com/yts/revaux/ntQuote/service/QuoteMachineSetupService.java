package com.yts.revaux.ntQuote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.mapper.QuoteMachineSetupMapper;
import com.yts.revaux.ntQuote.repository.QuoteMachineSetupRepository;

@Service
@Transactional
public class QuoteMachineSetupService {

	private final QuoteMachineSetupRepository quoteMachineSetupRepository;
	private final QuoteMachineSetupMapper quoteMachineSetupMapper;
	
	public QuoteMachineSetupService(QuoteMachineSetupRepository quoteMachineSetupRepository,
			QuoteMachineSetupMapper quoteMachineSetupMapper) {
	
		this.quoteMachineSetupRepository = quoteMachineSetupRepository;
		this.quoteMachineSetupMapper = quoteMachineSetupMapper;
	}
	
	
	
}
