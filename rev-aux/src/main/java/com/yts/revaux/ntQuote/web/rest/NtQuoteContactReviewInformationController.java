package com.yts.revaux.ntQuote.web.rest;

import com.yts.revaux.ntQuote.dto.NtQuoteContractReviewInformationDTO;
import com.yts.revaux.ntQuote.service.NtQuoteContactReviewInformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/nt-quote-contract-review-informations")
public class NtQuoteContactReviewInformationController {

    private final NtQuoteContactReviewInformationService service;

    @Autowired
    public NtQuoteContactReviewInformationController(NtQuoteContactReviewInformationService service) {
        this.service = service;
    }

    // Get a specific NtQuoteContractReviewInformation by ID
    @GetMapping("/{id}")
    public ResponseEntity<NtQuoteContractReviewInformationDTO> getById(@PathVariable Long id) {
        Optional<NtQuoteContractReviewInformationDTO> dto = service.getById(id);
        return dto.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update an existing NtQuoteContractReviewInformation
    @PutMapping("/{id}")
    public ResponseEntity<NtQuoteContractReviewInformationDTO> update(@PathVariable Long id,
                                                                      @RequestBody NtQuoteContractReviewInformationDTO dto) {
        NtQuoteContractReviewInformationDTO updatedDto = service.update(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto)
                                  : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Create a new NtQuoteContractReviewInformation (optional, for completeness)
    @PostMapping
    public ResponseEntity<NtQuoteContractReviewInformationDTO> create(@RequestBody NtQuoteContractReviewInformationDTO dto) {
        NtQuoteContractReviewInformationDTO createdDto = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDto);
    }
}
