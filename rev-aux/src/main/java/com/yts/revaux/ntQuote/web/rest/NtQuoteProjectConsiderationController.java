package com.yts.revaux.ntQuote.web.rest;

import com.yts.revaux.ntQuote.dto.NtQuoteProjectConsiderationsDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteProjectConsiderations;
import com.yts.revaux.ntQuote.service.NtQuoteProjectConsiderationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nt-quote-project-considerations")
public class NtQuoteProjectConsiderationController {

    private final NtQuoteProjectConsiderationService ntQuoteProjectConsiderationsService;

    public NtQuoteProjectConsiderationController(NtQuoteProjectConsiderationService ntQuoteProjectConsiderationsService) {
        this.ntQuoteProjectConsiderationsService = ntQuoteProjectConsiderationsService;
    }

    /**
     * Get all project considerations.
     * 
     * @return a ResponseEntity containing a list of project consideration DTOs
     */
    @GetMapping
    public ResponseEntity<List<NtQuoteProjectConsiderationsDTO>> getAllProjectConsiderations() {
        List<NtQuoteProjectConsiderationsDTO> projectConsiderations = ntQuoteProjectConsiderationsService.findAll();
        return ResponseEntity.ok(projectConsiderations);
    }

    /**
     * Get a specific project consideration by its ID.
     * 
     * @param id the ID of the project consideration
     * @return a ResponseEntity containing the project consideration DTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<NtQuoteProjectConsiderationsDTO> getProjectConsiderationById(@PathVariable Long id) {
        NtQuoteProjectConsiderationsDTO projectConsideration = ntQuoteProjectConsiderationsService.findOne(id);
        return ResponseEntity.ok(projectConsideration);
    }
}
