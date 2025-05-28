package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuotePartInformationDTO;
import com.yts.revaux.ntQuote.entity.NtQuotePartInformation;

/**
 * Mapper for the entity {@link NtQuotePartInformationMaster} and its DTO {@link NtQuotePartInformationMasterDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuotePartInformationMasterMapper extends EntityMapper<NtQuotePartInformationDTO, NtQuotePartInformation> {
   
}
