package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.QuoteProfitDTO;
import com.yts.revaux.ntQuote.entity.QuoteProfit;
@Mapper(componentModel = "spring")
public interface QuoteProfitMapper extends EntityMapper<QuoteProfitDTO, QuoteProfit> {
	   
	}
