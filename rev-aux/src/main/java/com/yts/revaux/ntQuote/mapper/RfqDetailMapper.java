package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.ntQuote.dto.RfqDetailDTO;
import com.yts.revaux.ntQuote.entity.RfqDetail;

/**
 * Mapper for the entity {@link RfqDetail} and its DTO {@link RfqDetailDTO}.
 */
@Mapper(componentModel = "spring")
public interface RfqDetailMapper extends EntityMapper<RfqDetailDTO, RfqDetail> {}
