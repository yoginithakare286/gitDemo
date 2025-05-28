package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.yts.revaux.ntQuote.dto.NtQuoteCustomerProjectDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteCustomerProject;

/**
 * Mapper for the entity {@link NtQuoteCustomerProject} and its DTO {@link NtQuoteCustomerProjectDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteCustomerProjectMapper {

    // Convert Entity to DTO
    NtQuoteCustomerProjectDTO toDto(NtQuoteCustomerProject entity);

    // Convert DTO to Entity
    NtQuoteCustomerProject toEntity(NtQuoteCustomerProjectDTO dto);

    // Define the method for updating the entity from the DTO
    void updateEntityFromDto(NtQuoteCustomerProjectDTO dto, @MappingTarget NtQuoteCustomerProject entity);
}
