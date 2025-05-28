package com.yts.revaux.ntQuote.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yts.revaux.ntQuote.dto.QuoteMachineEfficiencyDTO;
import com.yts.revaux.ntQuote.entity.QuoteMachineEfficiency;
import com.yts.revaux.ntQuote.mapper.QuoteMachineEfficiencyMapper;
import com.yts.revaux.ntQuote.repository.QuoteMachineEfficiencyRepository;

@Service
@Transactional
public class QuoteMachineEfficiencyService {

    private final QuoteMachineEfficiencyRepository quoteMachineEfficiencyRepository;
    private final QuoteMachineEfficiencyMapper quoteMachineEfficiencyMapper;

    public QuoteMachineEfficiencyService(QuoteMachineEfficiencyRepository quoteMachineEfficiencyRepository, 
                                         QuoteMachineEfficiencyMapper quoteMachineEfficiencyMapper) {
        this.quoteMachineEfficiencyRepository = quoteMachineEfficiencyRepository;
        this.quoteMachineEfficiencyMapper = quoteMachineEfficiencyMapper;
    }

    //  Fetch all Machine Efficiency Data
    public List<QuoteMachineEfficiencyDTO> getAllMachineEfficiencies() {
        List<QuoteMachineEfficiency> efficiencies = quoteMachineEfficiencyRepository.findAll();

        System.out.println("🔹 Raw Entity Data from DB: " + efficiencies); // Debugging

        if (efficiencies.isEmpty()) {
            System.out.println("⚠ No Machine Efficiency data found!");
        }

        List<QuoteMachineEfficiencyDTO> dtos = quoteMachineEfficiencyMapper.toDto(efficiencies);
        System.out.println("🔹 Mapped DTOs: " + dtos); // Check mapped DTOs

        return dtos;
    }
}

