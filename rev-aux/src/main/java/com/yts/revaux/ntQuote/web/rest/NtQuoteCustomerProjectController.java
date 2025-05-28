package com.yts.revaux.ntQuote.web.rest;

import com.yts.revaux.ntQuote.dto.NtQuoteCustomerProjectDTO;
import com.yts.revaux.ntQuote.service.NtQuoteCustomerProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nt-quote-customer-projects")
public class NtQuoteCustomerProjectController {

    private final NtQuoteCustomerProjectService projectService;

    @Autowired
    public NtQuoteCustomerProjectController(NtQuoteCustomerProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Fetch the customer project info by ID.
     */
    @GetMapping("/fetchCustomerInfoData/{id}")
    public ResponseEntity<NtQuoteCustomerProjectDTO> fetchCustomerInfoData(@PathVariable Long id) {
        try {
            // Fetching the project details by ID
            NtQuoteCustomerProjectDTO projectDto = projectService.getCustomerProjectById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Project with ID " + id + " not found"));

            // Returning the fetched data as JSON
            return ResponseEntity.ok(projectDto);

        } catch (IllegalArgumentException ex) {
            // Returning a Not Found response if project is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Update an existing project info.
     */
    @PutMapping("/updateExistingCustomer/{id}")
    public ResponseEntity<NtQuoteCustomerProjectDTO> updateExistingCustomer(
            @PathVariable Long id, @RequestBody NtQuoteCustomerProjectDTO dto) {
        try {
            // Updating the project info
            NtQuoteCustomerProjectDTO updatedProject = projectService.updateCustomerProject(id, dto);
            return ResponseEntity.ok(updatedProject);
        } catch (IllegalArgumentException ex) {
            // Returning a Not Found response if project is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // Catching any other exceptions and returning a bad request response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
