package com.yts.revaux.ntQuote.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.dto.QuoteScrapRateDTO;
import com.yts.revaux.ntQuote.entity.QuoteScrapRate;
import com.yts.revaux.ntQuote.mapper.QuoteScrapRateMapper;
import com.yts.revaux.ntQuote.repository.QuoteScrapRateRepository;

@Service
@Transactional
public class QuoteScrapRateService {

    private final QuoteScrapRateRepository quoteScrapRateRepository;
    private final QuoteScrapRateMapper quoteScrapRateMapper;

    public QuoteScrapRateService(QuoteScrapRateRepository quoteScrapRateRepository,
                                 QuoteScrapRateMapper quoteScrapRateMapper) {
        this.quoteScrapRateRepository = quoteScrapRateRepository;
        this.quoteScrapRateMapper = quoteScrapRateMapper;
    }

    //  Fetch all Quote Scrap Rate Data
    public List<QuoteScrapRateDTO> getAllQuoteScrapRates() {
        List<QuoteScrapRate> scrapRates = quoteScrapRateRepository.findAll();

        System.out.println("🔹 Raw Entity Data from DB: " + scrapRates); // Debugging

        if (scrapRates.isEmpty()) {
            System.out.println("⚠ No Quote Scrap Rate data found!");
        }

        List<QuoteScrapRateDTO> dtos = quoteScrapRateMapper.toDto(scrapRates);
        System.out.println("🔹 Mapped DTOs: " + dtos); // Check mapped DTOs

        return dtos;
    }
}
