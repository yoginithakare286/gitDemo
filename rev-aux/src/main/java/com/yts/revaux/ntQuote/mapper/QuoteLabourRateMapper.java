package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.QuoteLabourRateDTO;
import com.yts.revaux.ntQuote.entity.QuoteLabourRate;

@Mapper(componentModel = "spring")
public interface QuoteLabourRateMapper extends EntityMapper<QuoteLabourRateDTO, QuoteLabourRate> {
	   
	}
