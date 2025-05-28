package com.yts.revaux.ntQuote.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.service.NtQuoteListService;
import com.yts.revaux.ntQuote.service.QuoteMaterialMarkupService;

@RestController
@RequestMapping("/api/quoteMaterialMarkup")
public class QuoteMaterialMarkupController {

	private static final Logger logger = LoggerFactory.getLogger(QuoteMaterialMarkupController.class);
 
	private final QuoteMaterialMarkupService quoteMaterialMarkupService;

	public QuoteMaterialMarkupController(QuoteMaterialMarkupService quoteMaterialMarkupService) {
		
		this.quoteMaterialMarkupService = quoteMaterialMarkupService;
	} 
	
    
    
}
