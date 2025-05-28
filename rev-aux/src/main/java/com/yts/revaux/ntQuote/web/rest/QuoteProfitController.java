package com.yts.revaux.ntQuote.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.service.QuoteProfitService;

@RestController
@RequestMapping("/api/quoteProfit")
public class QuoteProfitController {

	private static final Logger logger = LoggerFactory.getLogger(QuoteProfitController.class);
    private final QuoteProfitService quoteProfitService;

    public QuoteProfitController(QuoteProfitService quoteProfitService) {
		
		this.quoteProfitService = quoteProfitService;
	}
	
    
    
}
