package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.QuoteMaterialMarkupDTO;
import com.yts.revaux.ntQuote.entity.QuoteMaterialMarkup;
@Mapper(componentModel = "spring")
public interface QuoteMaterialMarkupMapper extends EntityMapper<QuoteMaterialMarkupDTO, QuoteMaterialMarkup> {
	   
	}
