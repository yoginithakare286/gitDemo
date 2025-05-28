package com.yts.revaux.ntQuote.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.entity.NtQuote;
import com.yts.revaux.ntQuote.service.NtQuoteService;

@RestController
@RequestMapping("/api/quotes")
public class NtQuoteController {
    @Autowired
    private NtQuoteService ntQuoteService;

    @PostMapping("/insert/{rfqId}")
    public ResponseEntity<NtQuote> insertQuote(@PathVariable String rfqId) {
        try {
            NtQuote savedQuote = ntQuoteService.insertIntoNtQuote(rfqId);
            return ResponseEntity.ok(savedQuote);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
