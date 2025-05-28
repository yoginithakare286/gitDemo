package com.yts.revaux.ntQuote.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.dto.QuoteScrapRateDTO;
import com.yts.revaux.ntQuote.service.QuoteScrapRateService;
@RestController
@RequestMapping("/api/quoteScrapRate")
public class QuoteScrapRateController {

    private static final Logger logger = LoggerFactory.getLogger(QuoteScrapRateController.class);
    private final QuoteScrapRateService quoteScrapRateService;

    public QuoteScrapRateController(QuoteScrapRateService quoteScrapRateService) {
        this.quoteScrapRateService = quoteScrapRateService;
    }

    //  Fetch all Quote Scrap Rate Data
    @GetMapping("/getQuoteScrapRateData")
    public ResponseEntity<List<QuoteScrapRateDTO>> getAllQuoteScrapRates() {
        logger.info("Fetching all Quote Scrap Rate data...");

        List<QuoteScrapRateDTO> scrapRates = quoteScrapRateService.getAllQuoteScrapRates();

        if (scrapRates.isEmpty()) {
            logger.warn("⚠ No Quote Scrap Rate data found!");
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        return ResponseEntity.ok(scrapRates); // 200 OK with data
    }
}

