package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuoteVendorPoDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteVendorPo;

/**
 * Mapper for the entity {@link NtQuoteVendorPo} and its DTO {@link NtQuoteVendorPoDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteVendorPoMapper extends EntityMapper<NtQuoteVendorPoDTO, NtQuoteVendorPo> {
   
}
