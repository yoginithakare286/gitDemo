package com.yts.revaux.ntQuote.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.dto.QuoteLabourRateDTO;
import com.yts.revaux.ntQuote.service.QuoteLabourRateService;

@RestController
@RequestMapping("/api/quoteLabourRate")
public class QuoteLabourRateController {

    private static final Logger logger = LoggerFactory.getLogger(QuoteLabourRateController.class);

    private final QuoteLabourRateService quoteLabourRateService;

    public QuoteLabourRateController(QuoteLabourRateService quoteLabourRateService) {
        this.quoteLabourRateService = quoteLabourRateService;
    }

    //  Fetch all Quote Labour Rate Data
    @GetMapping("/getQuoteLabourRateData")
    public ResponseEntity<List<QuoteLabourRateDTO>> getAllQuoteLabourRates() {
        logger.info("Fetching all Quote Labour Rate data...");

        List<QuoteLabourRateDTO> labourRates = quoteLabourRateService.getAllQuoteLabourRates();

        if (labourRates.isEmpty()) {
            logger.warn("⚠ No Quote Labour Rate data found!");
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        return ResponseEntity.ok(labourRates); // 200 OK with data
    }
}

