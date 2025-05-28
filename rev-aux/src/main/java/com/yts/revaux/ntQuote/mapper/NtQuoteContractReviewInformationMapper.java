package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.*;

import com.yts.revaux.ntQuote.dto.NtQuoteContractReviewInformationDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteContractReviewInformation;

/**
 * Mapper for the entity {@link NtQuoteContractReviewInformation} and its DTO {@link NtQuoteContractReviewInformationDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteContractReviewInformationMapper
    extends EntityMapper<NtQuoteContractReviewInformationDTO, NtQuoteContractReviewInformation> {
   
}
