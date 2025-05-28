package com.yts.revaux.ntQuote.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.dto.QuoteLabourRateDTO;
import com.yts.revaux.ntQuote.entity.QuoteLabourRate;
import com.yts.revaux.ntQuote.mapper.QuoteLabourRateMapper;
import com.yts.revaux.ntQuote.repository.QuoteLabourRateRepository;

@Service
@Transactional
public class QuoteLabourRateService {

    private final QuoteLabourRateRepository quoteLabourRateRepository;
    private final QuoteLabourRateMapper quoteLabourRateMapper;

    public QuoteLabourRateService(QuoteLabourRateRepository quoteLabourRateRepository,
                                  QuoteLabourRateMapper quoteLabourRateMapper) {
        this.quoteLabourRateRepository = quoteLabourRateRepository;
        this.quoteLabourRateMapper = quoteLabourRateMapper;
    }

    //  Fetch all Quote Labour Rate Data
    public List<QuoteLabourRateDTO> getAllQuoteLabourRates() {
        List<QuoteLabourRate> labourRates = quoteLabourRateRepository.findAll();

        System.out.println("🔹 Raw Entity Data from DB: " + labourRates); // Debugging

        if (labourRates.isEmpty()) {
            System.out.println("⚠ No Quote Labour Rate data found!");
        }

        List<QuoteLabourRateDTO> dtos = quoteLabourRateMapper.toDto(labourRates);
        System.out.println("🔹 Mapped DTOs: " + dtos); // Check mapped DTOs

        return dtos;
    }
}

