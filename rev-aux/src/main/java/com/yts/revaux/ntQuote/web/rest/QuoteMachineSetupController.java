package com.yts.revaux.ntQuote.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.service.QuoteMachineSetupService;

@RestController
@RequestMapping("/api/quoteMachineSetup")
public class QuoteMachineSetupController {

	private static final Logger logger = LoggerFactory.getLogger(QuoteMachineSetupController.class);
   
	private final QuoteMachineSetupService quoteMachineSetupService;

	public QuoteMachineSetupController(QuoteMachineSetupService quoteMachineSetupService) {
	
		this.quoteMachineSetupService = quoteMachineSetupService;
	}
	
	
}
