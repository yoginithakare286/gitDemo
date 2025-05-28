package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuoteDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteList;

/**
 * Mapper for the entity {@link NtQuote} and its DTO {@link NtQuoteDTO}.
 */
@Mapper(componentModel = "spring")
public interface NtQuoteMapper extends EntityMapper<NtQuoteDTO, NtQuoteList> {
}
