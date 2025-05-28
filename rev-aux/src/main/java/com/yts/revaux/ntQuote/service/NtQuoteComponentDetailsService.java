package com.yts.revaux.ntQuote.service;

import com.yts.revaux.ntQuote.dto.NtQuoteComponentDetailDTO;
import com.yts.revaux.ntQuote.entity.NtQuoteComponentDetail;
import com.yts.revaux.ntQuote.mapper.NtQuoteComponentDetailMapper;
import com.yts.revaux.ntQuote.repository.NtQuoteComponentDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NtQuoteComponentDetailsService {

    private final NtQuoteComponentDetailRepository ntQuoteComponentDetailRepository;
    private final NtQuoteComponentDetailMapper ntQuoteComponentDetailMapper;

    public NtQuoteComponentDetailsService(NtQuoteComponentDetailRepository ntQuoteComponentDetailRepository, 
                                         NtQuoteComponentDetailMapper ntQuoteComponentDetailMapper) {
        this.ntQuoteComponentDetailRepository = ntQuoteComponentDetailRepository;
        this.ntQuoteComponentDetailMapper = ntQuoteComponentDetailMapper;
    }

    // Fetching all components from the database and converting to DTO
    public List<NtQuoteComponentDetailDTO> getAllComponentDetails() {
        List<NtQuoteComponentDetail> componentDetails = ntQuoteComponentDetailRepository.findAll();
        return componentDetails.stream()
                .map(ntQuoteComponentDetailMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public NtQuoteComponentDetailDTO updateComponentDetail(Long id, String column, String value) {
        NtQuoteComponentDetail componentDetail = ntQuoteComponentDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found"));

        switch (column) {
            case "materialDescription":
                componentDetail.setMaterialDescription(value);
                break;
            case "partNumber":
                componentDetail.setPartNumber(value);
                break;
            case "eau":
                componentDetail.setEau(Integer.valueOf(value));
                break;
            case "manufacturingLocation":
                componentDetail.setManufacturingLocation(value);
                break;
            case "fobLocation":
                componentDetail.setFobLocation(value);
                break;
            case "packingRequirements":
                componentDetail.setPackingRequirements(value);
                break;
            case "machineSize":
                componentDetail.setMachineSize(value);
                break;
            case "cycleTime":
                componentDetail.setCycleTime(Integer.valueOf(value));
                break;
            case "partWeight":
                componentDetail.setPartWeight(Integer.valueOf(value));
                break;
            case "runnerWeight":
                componentDetail.setRunnerWeight(Integer.valueOf(value));
                break;
            case "cavities":
                componentDetail.setCavities(Integer.valueOf(value));
                break;
            case "comments":
                componentDetail.setComments(value);
                break;
            case "riskLevel":
                componentDetail.setRiskLevel(value);
                break;
            default:
                throw new RuntimeException("Invalid column");
        }

        ntQuoteComponentDetailRepository.save(componentDetail); // Save changes
        return ntQuoteComponentDetailMapper.toDto(componentDetail); // Return updated DTO
    }
}
