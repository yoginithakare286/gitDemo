package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuoteCustomerPoDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteCustomerPo;

/**
 * Mapper for the entity {@link NtQuoteCustomerPo} and its DTO {@link NtQuoteCustomerPoDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteCustomerPoMapper extends EntityMapper<NtQuoteCustomerPoDTO, NtQuoteCustomerPo> {
   
}
