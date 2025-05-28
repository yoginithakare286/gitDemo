package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuoteTermsConditionsDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteTermsConditions;

/**
 * Mapper for the entity {@link NtQuoteTermsConditions} and its DTO {@link NtQuoteTermsConditionsDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteTermsConditionsMapper extends EntityMapper<NtQuoteTermsConditionsDTO, NtQuoteTermsConditions> {
   
}
