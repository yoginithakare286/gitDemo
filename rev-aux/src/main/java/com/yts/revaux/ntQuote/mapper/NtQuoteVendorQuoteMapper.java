package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuoteVendorQuoteDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteVendorQuote;

/**
 * Mapper for the entity {@link NtQuoteVendorQuote} and its DTO {@link NtQuoteVendorQuoteDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteVendorQuoteMapper extends EntityMapper<NtQuoteVendorQuoteDTO, NtQuoteVendorQuote> {
  
}
