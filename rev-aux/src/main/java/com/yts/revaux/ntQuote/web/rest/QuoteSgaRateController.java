package com.yts.revaux.ntQuote.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.service.QuoteSgaRateService;

@RestController
@RequestMapping("/api/quoteSgaRate")
public class QuoteSgaRateController {

	private static final Logger logger = LoggerFactory.getLogger(QuoteSgaRateController.class);
    private final QuoteSgaRateService quoteSgaRateService;
	
    public QuoteSgaRateController(QuoteSgaRateService quoteSgaRateService) {
		
		this.quoteSgaRateService = quoteSgaRateService;
	}
	
    
    
}
