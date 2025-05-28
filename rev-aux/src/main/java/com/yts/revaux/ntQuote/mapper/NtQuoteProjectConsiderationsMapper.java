package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuoteProjectConsiderationsDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteProjectConsiderations;

/**
 * Mapper for the entity {@link NtQuoteProjectConsiderations} and its DTO {@link NtQuoteProjectConsiderationsDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteProjectConsiderationsMapper extends EntityMapper<NtQuoteProjectConsiderationsDTO, NtQuoteProjectConsiderations> {
  
}
