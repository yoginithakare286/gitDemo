package com.yts.revaux.ntQuote.service;

import com.yts.revaux.ntQuote.dto.NtQuoteCustomerProjectDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteCustomerProject;
import com.yts.revaux.ntQuote.mapper.NtQuoteCustomerProjectMapper;
import com.yts.revaux.ntQuote.repository.NtQuoteCustomerProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class NtQuoteCustomerProjectService {

    private final NtQuoteCustomerProjectRepository repository;
    private final NtQuoteCustomerProjectMapper mapper;

    @Autowired
    public NtQuoteCustomerProjectService(NtQuoteCustomerProjectRepository repository, NtQuoteCustomerProjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Fetch the project data by ID
     */
    public Optional<NtQuoteCustomerProjectDTO> getCustomerProjectById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    /**
     * Update an existing project.
     */
    public NtQuoteCustomerProjectDTO updateCustomerProject(Long id, NtQuoteCustomerProjectDTO dto) {
        Optional<NtQuoteCustomerProject> optionalProject = repository.findById(id);
        if (optionalProject.isPresent()) {
            NtQuoteCustomerProject entity = optionalProject.get();
            // Map the fields from DTO to the entity
            mapper.updateEntityFromDto(dto, entity);
            // Save the updated entity
            entity = repository.save(entity);
            // Convert the updated entity back to DTO and return
            return mapper.toDto(entity);
        } else {
            throw new IllegalArgumentException("Project with ID " + id + " not found");
        }
    }
}
