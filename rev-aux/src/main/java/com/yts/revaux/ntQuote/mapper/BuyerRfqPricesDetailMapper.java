package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.yts.revaux.common.EntityMapper;
import com.yts.revaux.ntQuote.dto.BuyerRfqPricesDetailDTO;
import com.yts.revaux.ntQuote.dto.RfqDetailDTO;
import com.yts.revaux.ntQuote.dto.VendorProfileDTO;
import com.yts.revaux.ntQuote.entity.BuyerRfqPricesDetail;
import com.yts.revaux.ntQuote.entity.RfqDetail;
import com.yts.revaux.ntQuote.entity.VendorProfile;

@Mapper(componentModel = "spring")
public interface BuyerRfqPricesDetailMapper extends EntityMapper<BuyerRfqPricesDetailDTO, BuyerRfqPricesDetail> {

}