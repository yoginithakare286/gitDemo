package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.QuoteSgaRateDTO;
import com.yts.revaux.ntQuote.entity.QuoteSgaRate;
@Mapper(componentModel = "spring")
public interface QuoteSgaRateMapper extends EntityMapper<QuoteSgaRateDTO, QuoteSgaRate> {
	   
	}
