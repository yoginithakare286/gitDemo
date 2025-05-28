package com.yts.revaux.ntQuote.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.dto.NtQuoteCostOverviewCustomerInputOutputDTO;
import com.yts.revaux.ntQuote.service.NtQuoteCostOverviewCustomerInputOutputService;

@RestController
@RequestMapping("/api/nt-quote-customer-input-output")
public class NtQuoteCostOverviewCustomerInputOutputController {

    private static final Logger logger = LoggerFactory.getLogger(NtQuoteCostOverviewCustomerInputOutputController.class);

    private final NtQuoteCostOverviewCustomerInputOutputService service;

    public NtQuoteCostOverviewCustomerInputOutputController(NtQuoteCostOverviewCustomerInputOutputService service) {
        this.service = service;
    }

    @GetMapping("/getCalculationInputOutputData/{id}")
    public ResponseEntity<List<NtQuoteCostOverviewCustomerInputOutputDTO>> getNtQuoteCustomerInputOutputDataById(@PathVariable Long id) {
        logger.info("Fetching NT Quote Data for ID: {}", id);

        List<NtQuoteCostOverviewCustomerInputOutputDTO> quotes = service.getNtQuoteCustomerInputOutputDataById(id);

        if (quotes.isEmpty()) {
            logger.warn("No NT Quote found for ID: {}", id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        return ResponseEntity.ok(quotes); // 200 OK
    }
    
    
    //  Save/Update Calculation Input Output Data
    @PutMapping("/saveCalculationInputOutputData/{id}")
    public ResponseEntity<NtQuoteCostOverviewCustomerInputOutputDTO> updateNtQuoteCustomerInputOutputData(
            @PathVariable Long id,
            @RequestBody NtQuoteCostOverviewCustomerInputOutputDTO dto) {

        logger.info("Updating NT Quote Data for ID: {}", id);

        NtQuoteCostOverviewCustomerInputOutputDTO updatedDto = service.updateNtQuoteCustomerInputOutputData(id, dto);

        if (updatedDto == null) {
            logger.warn("⚠ No NT Quote found for ID: {}", id);
            return ResponseEntity.notFound().build(); // 404 Not Found
        }

        return ResponseEntity.ok(updatedDto); // 200 OK
    }
    
}

