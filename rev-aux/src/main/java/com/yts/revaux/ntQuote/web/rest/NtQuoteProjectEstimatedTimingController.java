package com.yts.revaux.ntQuote.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.dto.NtQuoteProjectEstimatedTimingDTO;
import com.yts.revaux.ntQuote.service.NtQuoteProjectEstimatedTimingService;

@RestController
@RequestMapping("/api/nt-quote-project-timing")
public class NtQuoteProjectEstimatedTimingController {
	
	
	@Autowired
    private NtQuoteProjectEstimatedTimingService ntQuoteProjectEstimatedTimingService;

    // Endpoint to fetch the project estimated timing details
    @GetMapping("/{id}")
    public NtQuoteProjectEstimatedTimingDTO getEstimatedTiming(@PathVariable Long id) {
        return ntQuoteProjectEstimatedTimingService.getEstimatedTimingById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NtQuoteProjectEstimatedTimingDTO> updateEstimatedTiming(
            @PathVariable Long id, 
            @RequestBody NtQuoteProjectEstimatedTimingDTO ntQuoteProjectEstimatedTimingDTO) {

        try {
            NtQuoteProjectEstimatedTimingDTO updatedEntity = ntQuoteProjectEstimatedTimingService.updateEstimatedTiming(id, ntQuoteProjectEstimatedTimingDTO);
            return ResponseEntity.ok(updatedEntity); // Return the updated DTO in the response
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Entity not found
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Internal error
        }
    }

}
