package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.QuoteMachineSetupDTO;
import com.yts.revaux.ntQuote.entity.QuoteMachineSetup;
@Mapper(componentModel = "spring")
public interface QuoteMachineSetupMapper extends EntityMapper<QuoteMachineSetupDTO, QuoteMachineSetup> {
	   
	}
