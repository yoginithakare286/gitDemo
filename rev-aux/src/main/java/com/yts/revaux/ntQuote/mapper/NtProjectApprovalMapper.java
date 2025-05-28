package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.Mapper;


import com.yts.revaux.ntQuote.dto.NtProjectApprovalDTO;
import com.yts.revaux.ntQuote.entity.NtProjectApproval;

@Mapper(componentModel = "spring")
public interface NtProjectApprovalMapper extends EntityMapper<NtProjectApprovalDTO, NtProjectApproval> {
   
}
