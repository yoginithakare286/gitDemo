package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.NtQuoteCommentsDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteComments;

@Mapper(componentModel = "spring")
public interface NtQuoteCommentsMapper extends EntityMapper<NtQuoteCommentsDTO, NtQuoteComments> {
   

}
