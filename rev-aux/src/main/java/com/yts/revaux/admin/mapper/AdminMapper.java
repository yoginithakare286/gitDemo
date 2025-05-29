package com.yts.revaux.admin.mapper;

import org.mapstruct.Mapper;

import com.yts.revaux.admin.entity.Admin;
import com.yts.revaux.common.EntityMapper;
import com.yts.revaux.admin.dto.AdminDTO;
//changes by yogini
@Mapper(componentModel = "spring")
public interface AdminMapper  extends EntityMapper<AdminDTO, Admin> {
    // MapStruct will automatically generate the necessary code for these conversions.
}
