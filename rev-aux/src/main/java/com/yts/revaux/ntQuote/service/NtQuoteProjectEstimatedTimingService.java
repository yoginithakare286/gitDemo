package com.yts.revaux.ntQuote.service;

import com.yts.revaux.ntQuote.dto.NtQuoteProjectEstimatedTimingDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteProjectEstimatedTiming;
import com.yts.revaux.ntQuote.mapper.NtQuoteProjectEstimatedTimingMapper;
import com.yts.revaux.ntQuote.repository.NtQuoteProjectEstimatedTimingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NtQuoteProjectEstimatedTimingService {

    @Autowired
    private NtQuoteProjectEstimatedTimingRepository ntQuoteProjectEstimatedTimingRepository;

    @Autowired
    private NtQuoteProjectEstimatedTimingMapper mapper;

    public NtQuoteProjectEstimatedTimingDTO getEstimatedTimingById(Long id) {
        Optional<NtQuoteProjectEstimatedTiming> entity = ntQuoteProjectEstimatedTimingRepository.findById(id);
        return entity.map(mapper::toDto).orElse(null);
    }

    public NtQuoteProjectEstimatedTimingDTO updateEstimatedTiming(Long id, NtQuoteProjectEstimatedTimingDTO ntQuoteProjectEstimatedTimingDTO) {
        Optional<NtQuoteProjectEstimatedTiming> existingEntity = ntQuoteProjectEstimatedTimingRepository.findById(id);

        if (existingEntity.isPresent()) {
            NtQuoteProjectEstimatedTiming entity = existingEntity.get();

            // Update fields only if they're not null
            if (ntQuoteProjectEstimatedTimingDTO.getPrototypeDelDate() != null) {
                entity.setPrototypeDelDate(ntQuoteProjectEstimatedTimingDTO.getPrototypeDelDate());
            }
            if (ntQuoteProjectEstimatedTimingDTO.getDesgValdDelDate() != null) {
                entity.setDesgValdDelDate(ntQuoteProjectEstimatedTimingDTO.getDesgValdDelDate());
            }
            if (ntQuoteProjectEstimatedTimingDTO.getPrdValdDelDate() != null) {
                entity.setPrdValdDelDate(ntQuoteProjectEstimatedTimingDTO.getPrdValdDelDate());
            }

            // Update the updatedBy and updatedDate fields
            entity.setUpdatedBy(ntQuoteProjectEstimatedTimingDTO.getUpdatedBy());
            entity.setUpdatedDate(ntQuoteProjectEstimatedTimingDTO.getUpdatedDate());

            // Save the updated entity
            NtQuoteProjectEstimatedTiming updatedEntity = ntQuoteProjectEstimatedTimingRepository.save(entity);

            // Convert the updated entity back to DTO and return
            return mapper.toDto(updatedEntity);
        } else {
            // If entity does not exist, throw an exception
            throw new IllegalArgumentException("Estimated timing entry not found");
        }
    }

}
