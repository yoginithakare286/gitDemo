package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.QuoteScrapRateDTO;
import com.yts.revaux.ntQuote.entity.QuoteScrapRate;
@Mapper(componentModel = "spring")
public interface QuoteScrapRateMapper extends EntityMapper<QuoteScrapRateDTO, QuoteScrapRate> {
	   
	}