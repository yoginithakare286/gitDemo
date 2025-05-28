package com.yts.revaux.ntQuote.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yts.revaux.ntQuote.dto.QuoteMachineEfficiencyDTO;
import com.yts.revaux.ntQuote.service.QuoteMachineEfficiencyService;

@RestController
@RequestMapping("/api/quoteMachineEfficiency")
public class QuoteMachineEfficiencyController {

    private static final Logger logger = LoggerFactory.getLogger(QuoteMachineEfficiencyController.class);

    private final QuoteMachineEfficiencyService quoteMachineEfficiencyService;

    public QuoteMachineEfficiencyController(QuoteMachineEfficiencyService quoteMachineEfficiencyService) {
        this.quoteMachineEfficiencyService = quoteMachineEfficiencyService;
    }

    //  Fetch all Machine Efficiency Data
    @GetMapping("/getMachineEfficiencyData")
    public ResponseEntity<List<QuoteMachineEfficiencyDTO>> getAllMachineEfficiencies() {
        logger.info("Fetching all Machine Efficiency data...");

        List<QuoteMachineEfficiencyDTO> efficiencies = quoteMachineEfficiencyService.getAllMachineEfficiencies();

        if (efficiencies.isEmpty()) {
            logger.warn("⚠ No Machine Efficiency data found!");
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        return ResponseEntity.ok(efficiencies); // 200 OK with data
    }
}
