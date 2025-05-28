package com.yts.revaux.ntQuote.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.dto.NtQuoteCostOverviewCustomerInputOutputDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteCostOverviewCustomerInputOutput;
import com.yts.revaux.ntQuote.mapper.NtQuoteCostOverviewCustomerInputOutputMapper;
import com.yts.revaux.ntQuote.repository.NtQuoteCostOverviewCustomerInputOutputRepository;

@Service
@Transactional
public class NtQuoteCostOverviewCustomerInputOutputService {

    private final NtQuoteCostOverviewCustomerInputOutputRepository repository;
    private final NtQuoteCostOverviewCustomerInputOutputMapper mapper;

    public NtQuoteCostOverviewCustomerInputOutputService(
            NtQuoteCostOverviewCustomerInputOutputRepository repository,
            NtQuoteCostOverviewCustomerInputOutputMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //  Fetch Data by ID (Returns List of DTOs)
    public List<NtQuoteCostOverviewCustomerInputOutputDTO> getNtQuoteCustomerInputOutputDataById(Long id) {
        List<NtQuoteCostOverviewCustomerInputOutput> quotes = repository.findAllById(Collections.singleton(id));

        System.out.println("🔹 Raw Entity Data from DB: " + quotes); // Debugging

        if (quotes.isEmpty()) {
            System.out.println("⚠ No quotes found for ID: " + id);
        }

        List<NtQuoteCostOverviewCustomerInputOutputDTO> dtos = mapper.toDto(quotes);
        System.out.println("🔹 Mapped DTOs: " + dtos); // Debugging

        return dtos;
    }
    
    //  Update Existing Record
    public NtQuoteCostOverviewCustomerInputOutputDTO updateNtQuoteCustomerInputOutputData(Long id, NtQuoteCostOverviewCustomerInputOutputDTO dto) {
        Optional<NtQuoteCostOverviewCustomerInputOutput> existingEntityOpt = repository.findById(id);

        if (existingEntityOpt.isEmpty()) {
            System.out.println("⚠ No record found with ID: " + id);
            return null; // No data found, return null
        }

        NtQuoteCostOverviewCustomerInputOutput existingEntity = existingEntityOpt.get();

        //  Update only the fields from DTO (avoid overwriting null values)
        mapper.partialUpdate(existingEntity, dto);

        //  Save updated entity
        NtQuoteCostOverviewCustomerInputOutput savedEntity = repository.save(existingEntity);

        //  Convert updated entity to DTO
        return mapper.toDto(savedEntity);
    }
    
    
}

