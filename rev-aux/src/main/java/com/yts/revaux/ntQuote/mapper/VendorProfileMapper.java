package com.yts.revaux.ntQuote.mapper;

import org.mapstruct.*;

import com.yts.revaux.ntQuote.dto.VendorProfileDTO;
import com.yts.revaux.ntQuote.entity.VendorProfile;

/**
 * Mapper for the entity {@link VendorProfile} and its DTO {@link VendorProfileDTO}.
 */
@Mapper(componentModel = "spring")
public interface VendorProfileMapper extends EntityMapper<VendorProfileDTO, VendorProfile> {}
