package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.*;
import com.yts.revaux.ntQuote.dto.NtQuoteComponentDetailDTO;
import com.yts.revaux.ntQuote.dto.NtQuoteCustomerInputOutputVersionDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteComponentDetail;
import com.yts.revaux.ntQuote.entity.NtQuoteCustomerInputOutputVersion;

@Mapper(componentModel = "spring")
public interface NtQuoteComponentDetailMapper extends EntityMapper<NtQuoteComponentDetailDTO, NtQuoteComponentDetail>{

}
