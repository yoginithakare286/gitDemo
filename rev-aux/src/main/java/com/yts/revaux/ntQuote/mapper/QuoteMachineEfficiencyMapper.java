package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.QuoteMachineEfficiencyDTO;
import com.yts.revaux.ntQuote.entity.QuoteMachineEfficiency;
@Mapper(componentModel = "spring")
public interface QuoteMachineEfficiencyMapper extends EntityMapper<QuoteMachineEfficiencyDTO, QuoteMachineEfficiency> {
	   
	}
