package com.yts.revaux.ntQuote.service;

import com.yts.revaux.ntQuote.dto.NtQuoteProjectConsiderationsDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteProjectConsiderations;
import com.yts.revaux.ntQuote.mapper.NtQuoteProjectConsiderationsMapper;
import com.yts.revaux.ntQuote.repository.NtQuoteProjectConsiderationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NtQuoteProjectConsiderationService {

    private final NtQuoteProjectConsiderationRepository ntQuoteProjectConsiderationRepository;
    private final NtQuoteProjectConsiderationsMapper ntQuoteProjectConsiderationsMapper;

    public NtQuoteProjectConsiderationService(NtQuoteProjectConsiderationRepository ntQuoteProjectConsiderationRepository,
                                               NtQuoteProjectConsiderationsMapper ntQuoteProjectConsiderationsMapper) {
        this.ntQuoteProjectConsiderationRepository = ntQuoteProjectConsiderationRepository;
        this.ntQuoteProjectConsiderationsMapper = ntQuoteProjectConsiderationsMapper;
    }

    /**
     * Get all project considerations.
     * 
     * @return a list of Project Consideration DTOs
     */
    @Transactional(readOnly = true)
    public List<NtQuoteProjectConsiderationsDTO> findAll() {
        List<NtQuoteProjectConsiderations> projectConsiderations = ntQuoteProjectConsiderationRepository.findAll();
        return projectConsiderations.stream()
                                    .map(ntQuoteProjectConsiderationsMapper::toDto)
                                    .collect(Collectors.toList());
    }

    /**
     * Get a single project consideration by its ID.
     * 
     * @param id the ID of the Project Consideration
     * @return the Project Consideration DTO
     */
    @Transactional(readOnly = true)
    public NtQuoteProjectConsiderationsDTO findOne(Long id) {
        NtQuoteProjectConsiderations projectConsideration = ntQuoteProjectConsiderationRepository.findById(id).orElse(null);
        return ntQuoteProjectConsiderationsMapper.toDto(projectConsideration);
    }
}
