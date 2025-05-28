package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.*;

import com.yts.revaux.ntQuote.dto.NtQuoteProjectApprovalDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteProjectApproval;

/**
 * Mapper for the entity {@link NtQuoteProjectApproval} and its DTO {@link NtQuoteProjectApprovalDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteProjectApprovalMapper extends EntityMapper<NtQuoteProjectApprovalDTO, NtQuoteProjectApproval> {}
