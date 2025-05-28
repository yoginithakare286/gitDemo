package com.yts.revaux.ntQuote.mapper;

import java.util.List;

import org.mapstruct.*;

import com.yts.revaux.ntQuote.dto.NtQuoteCostOverviewCustomerInputOutputDTO;
import com.yts.revaux.ntQuote.dto.NtQuoteDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteCostOverviewCustomerInputOutput;
import com.yts.revaux.ntQuote.entity.NtQuoteList;

/**
 * Mapper for the entity {@link NtQuoteCustomerInputOutputMaster} and its DTO {@link NtQuoteCustomerInputOutputMasterDTO}.
 */
/*
 * @Mapper(componentModel = "spring") public interface
 * NtQuoteCostOverviewCustomerInputOutputMapper extends
 * EntityMapper<NtQuoteCostOverviewCustomerInputOutputDTO,
 * NtQuoteCostOverviewCustomerInputOutput> {}
 */
@Mapper(componentModel = "spring")
public interface NtQuoteCostOverviewCustomerInputOutputMapper  extends EntityMapper<NtQuoteCostOverviewCustomerInputOutputDTO, NtQuoteCostOverviewCustomerInputOutput> {
   
}

