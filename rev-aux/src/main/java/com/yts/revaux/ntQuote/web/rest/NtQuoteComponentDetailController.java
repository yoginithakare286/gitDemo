package com.yts.revaux.ntQuote.web.rest;

import com.yts.revaux.ntQuote.dto.NtQuoteComponentDetailDTO;
import com.yts.revaux.ntQuote.service.NtQuoteComponentDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nt-quote-component-details")
public class NtQuoteComponentDetailController {

    private final NtQuoteComponentDetailsService ntQuoteComponentDetailService;

    @Autowired
    public NtQuoteComponentDetailController(NtQuoteComponentDetailsService ntQuoteComponentDetailService) {
        this.ntQuoteComponentDetailService = ntQuoteComponentDetailService;
    }

    // Endpoint to get all the component details
    @GetMapping("/featchComponentDetails")
    public ResponseEntity<List<NtQuoteComponentDetailDTO>> getComponentDetails() {
        List<NtQuoteComponentDetailDTO> componentDetails = ntQuoteComponentDetailService.getAllComponentDetails();
        return ResponseEntity.ok(componentDetails);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<NtQuoteComponentDetailDTO> updateComponentDetail(
            @PathVariable Long id,
            @RequestBody Map<String, String> updateData) {
        
        String column = updateData.keySet().iterator().next();
        String value = updateData.get(column);
        NtQuoteComponentDetailDTO updatedComponent = ntQuoteComponentDetailService.updateComponentDetail(id, column, value);
        
        return ResponseEntity.ok(updatedComponent);
    }
}
