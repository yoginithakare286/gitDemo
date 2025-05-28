package com.yts.revaux.ntQuote.service;

import com.yts.revaux.ntQuote.dto.NtQuoteContractReviewInformationDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteContractReviewInformation;
import com.yts.revaux.ntQuote.mapper.NtQuoteContractReviewInformationMapper;
import com.yts.revaux.ntQuote.repository.NtQuoteContactReviewInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class NtQuoteContactReviewInformationService {

    private final NtQuoteContactReviewInformationRepository repository;
    private final NtQuoteContractReviewInformationMapper mapper;

    @Autowired
    public NtQuoteContactReviewInformationService(NtQuoteContactReviewInformationRepository repository, 
                                                   NtQuoteContractReviewInformationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Fetching a specific NtQuoteContractReviewInformation by ID
    public Optional<NtQuoteContractReviewInformationDTO> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    // Updating the NtQuoteContractReviewInformation
    public NtQuoteContractReviewInformationDTO update(Long id, NtQuoteContractReviewInformationDTO dto) {
        Optional<NtQuoteContractReviewInformation> existingEntity = repository.findById(id);

        if (existingEntity.isPresent()) {
            NtQuoteContractReviewInformation entity = existingEntity.get();

            // Updating the entity with new values
            entity.setContractNumber(dto.getContractNumber());
            entity.setRevision(dto.getRevision());
            entity.setReviewDate(dto.getReviewDate());
            // Additional fields can be updated similarly

            // Saving the updated entity
            NtQuoteContractReviewInformation updatedEntity = repository.save(entity);

            return mapper.toDto(updatedEntity);
        }
        return null;
    }

    // Optional: Method to create new NtQuoteContractReviewInformation, if needed
    public NtQuoteContractReviewInformationDTO create(NtQuoteContractReviewInformationDTO dto) {
        NtQuoteContractReviewInformation entity = mapper.toEntity(dto);
        NtQuoteContractReviewInformation savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }
}
