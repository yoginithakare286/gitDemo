package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuotePartInformationVersionDTO;
import com.yts.revaux.ntQuote.entity.NtQuotePartInformationVersion;

/**
 * Mapper for the entity {@link NtQuotePartInformationVersion} and its DTO {@link NtQuotePartInformationVersionDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuotePartInformationVersionMapper extends EntityMapper<NtQuotePartInformationVersionDTO, NtQuotePartInformationVersion> {
   
}
