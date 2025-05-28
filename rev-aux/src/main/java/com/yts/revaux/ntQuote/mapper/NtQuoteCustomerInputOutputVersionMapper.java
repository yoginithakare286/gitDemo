package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.*;

import com.yts.revaux.ntQuote.dto.NtQuoteCustomerInputOutputVersionDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteCustomerInputOutputVersion;

/**
 * Mapper for the entity {@link NtQuoteCustomerInputOutputVersion} and its DTO {@link NtQuoteCustomerInputOutputVersionDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteCustomerInputOutputVersionMapper
    extends EntityMapper<NtQuoteCustomerInputOutputVersionDTO, NtQuoteCustomerInputOutputVersion> {
    
}
