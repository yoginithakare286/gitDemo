package com.yts.revaux.ntQuote.mapper;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.yts.revaux.ntQuote.dto.NtQuoteProjectEstimatedTimingDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteProjectEstimatedTiming;

@Mapper(componentModel = "spring")
public interface NtQuoteProjectEstimatedTimingMapper extends EntityMapper<NtQuoteProjectEstimatedTimingDTO, NtQuoteProjectEstimatedTiming> {

    // Convert from Instant to ZonedDateTime (you can specify a timezone)
    @Mapping(target = "createdDate", source = "createdDate")
    default ZonedDateTime map(Instant value) {
        return ZonedDateTime.ofInstant(value, ZoneId.systemDefault()); // or specify a particular time zone
    }

    // Convert from ZonedDateTime to Instant
    @Mapping(target = "createdDate", source = "createdDate")
    default Instant map(ZonedDateTime value) {
        return value.toInstant();
    }
    
    // Your other mappings would go here (if any)
}
