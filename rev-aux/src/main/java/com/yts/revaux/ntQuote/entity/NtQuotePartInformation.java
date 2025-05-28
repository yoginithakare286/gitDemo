package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nt_quote_part_information")
public class NtQuotePartInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "sr_no")
    private Integer srNo;

    @NotNull
    @Column(name = "uid", nullable = false)
    private UUID uid;

    @Column(name = "material_description")
    private String materialDescription;

    @Column(name = "part_number")
    private String partNumber;

    @Column(name = "cad_file")
    private String cadFile;

    @Column(name = "eau")
    private Integer eau;

    @Column(name = "part_weight")
    private Integer partWeight;

    @Column(name = "material_type")
    private String materialType;

    @Column(name = "material_cost", precision = 21, scale = 2)
    private BigDecimal materialCost;

    @Column(name = "extended_material_cost_per", precision = 21, scale = 2)
    private BigDecimal extendedMaterialCostPer;

    @Column(name = "external_machine_cost_per", precision = 21, scale = 2)
    private BigDecimal externalMachineCostPer;

    @Column(name = "purchase_component_cost", precision = 21, scale = 2)
    private BigDecimal purchaseComponentCost;

    @Column(name = "secondary_external_operation_cost", precision = 21, scale = 2)
    private BigDecimal secondaryExternalOperationCost;

    @Column(name = "overhead", precision = 21, scale = 2)
    private BigDecimal overhead;

    @Column(name = "pack_logistic_cost_per", precision = 21, scale = 2)
    private BigDecimal packLogisticCostPer;

    @Column(name = "machine_size_tons")
    private String machineSizeTons;

    @Column(name = "number_of_cavities")
    private Integer numberOfCavities;

    @Column(name = "cycle_time")
    private Integer cycleTime;

    @Column(name = "per_unit", precision = 21, scale = 2)
    private BigDecimal perUnit;

    @Column(name = "total_price_per_china", precision = 21, scale = 2)
    private BigDecimal totalPricePerChina;

    @Column(name = "total_price_budget", precision = 21, scale = 2)
    private BigDecimal totalPriceBudget;

    @Column(name = "grain_budget", precision = 21, scale = 2)
    private BigDecimal grainBudget;

    @Column(name = "dogating_fixture_budget", precision = 21, scale = 2)
    private BigDecimal dogatingFixtureBudget;

    @Column(name = "gauge_budget", precision = 21, scale = 2)
    private BigDecimal gaugeBudget;

    @Column(name = "eoat", precision = 21, scale = 2)
    private BigDecimal eoat;

    @Column(name = "china_tariff_budget", precision = 21, scale = 2)
    private BigDecimal chinaTariffBudget;

    @Column(name = "total_tooling_budget", precision = 21, scale = 2)
    private BigDecimal totalToolingBudget;

    @Column(name = "lead_time")
    private String leadTime;

    @Column(name = "tooling_notes")
    private String toolingNotes;

    @Column(name = "part_description")
    private String partDescription;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "mold_id")
    private String moldId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(
        value = {
            "projectConsiderations",
            "contractReviewInformations",
            "customerInputOutputVersions",
            "partInformationMasters",
            "comments",
            "termsConditions",
            "projectApprovals",
            "partInformationVersions",
            "customerPos",
            "vendorQuotes",
            "vendorPos",
            "rfqDetail",
            "ntQuoteProjectApproval",
        },
        allowSetters = true
    )
    private NtQuoteList ntQuote;
    
	public NtQuoteList getNtQuote() {
		return ntQuote;
	}

	public void setNtQuote(NtQuoteList ntQuote) {
		this.ntQuote = ntQuote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getCadFile() {
		return cadFile;
	}

	public void setCadFile(String cadFile) {
		this.cadFile = cadFile;
	}

	public Integer getEau() {
		return eau;
	}

	public void setEau(Integer eau) {
		this.eau = eau;
	}

	public Integer getPartWeight() {
		return partWeight;
	}

	public void setPartWeight(Integer partWeight) {
		this.partWeight = partWeight;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public BigDecimal getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(BigDecimal materialCost) {
		this.materialCost = materialCost;
	}

	public BigDecimal getExtendedMaterialCostPer() {
		return extendedMaterialCostPer;
	}

	public void setExtendedMaterialCostPer(BigDecimal extendedMaterialCostPer) {
		this.extendedMaterialCostPer = extendedMaterialCostPer;
	}

	public BigDecimal getExternalMachineCostPer() {
		return externalMachineCostPer;
	}

	public void setExternalMachineCostPer(BigDecimal externalMachineCostPer) {
		this.externalMachineCostPer = externalMachineCostPer;
	}

	public BigDecimal getPurchaseComponentCost() {
		return purchaseComponentCost;
	}

	public void setPurchaseComponentCost(BigDecimal purchaseComponentCost) {
		this.purchaseComponentCost = purchaseComponentCost;
	}

	public BigDecimal getSecondaryExternalOperationCost() {
		return secondaryExternalOperationCost;
	}

	public void setSecondaryExternalOperationCost(BigDecimal secondaryExternalOperationCost) {
		this.secondaryExternalOperationCost = secondaryExternalOperationCost;
	}

	public BigDecimal getOverhead() {
		return overhead;
	}

	public void setOverhead(BigDecimal overhead) {
		this.overhead = overhead;
	}

	public BigDecimal getPackLogisticCostPer() {
		return packLogisticCostPer;
	}

	public void setPackLogisticCostPer(BigDecimal packLogisticCostPer) {
		this.packLogisticCostPer = packLogisticCostPer;
	}

	public String getMachineSizeTons() {
		return machineSizeTons;
	}

	public void setMachineSizeTons(String machineSizeTons) {
		this.machineSizeTons = machineSizeTons;
	}

	public Integer getNumberOfCavities() {
		return numberOfCavities;
	}

	public void setNumberOfCavities(Integer numberOfCavities) {
		this.numberOfCavities = numberOfCavities;
	}

	public Integer getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(Integer cycleTime) {
		this.cycleTime = cycleTime;
	}

	public BigDecimal getPerUnit() {
		return perUnit;
	}

	public void setPerUnit(BigDecimal perUnit) {
		this.perUnit = perUnit;
	}

	public BigDecimal getTotalPricePerChina() {
		return totalPricePerChina;
	}

	public void setTotalPricePerChina(BigDecimal totalPricePerChina) {
		this.totalPricePerChina = totalPricePerChina;
	}

	public BigDecimal getTotalPriceBudget() {
		return totalPriceBudget;
	}

	public void setTotalPriceBudget(BigDecimal totalPriceBudget) {
		this.totalPriceBudget = totalPriceBudget;
	}

	public BigDecimal getGrainBudget() {
		return grainBudget;
	}

	public void setGrainBudget(BigDecimal grainBudget) {
		this.grainBudget = grainBudget;
	}

	public BigDecimal getDogatingFixtureBudget() {
		return dogatingFixtureBudget;
	}

	public void setDogatingFixtureBudget(BigDecimal dogatingFixtureBudget) {
		this.dogatingFixtureBudget = dogatingFixtureBudget;
	}

	public BigDecimal getGaugeBudget() {
		return gaugeBudget;
	}

	public void setGaugeBudget(BigDecimal gaugeBudget) {
		this.gaugeBudget = gaugeBudget;
	}

	public BigDecimal getEoat() {
		return eoat;
	}

	public void setEoat(BigDecimal eoat) {
		this.eoat = eoat;
	}

	public BigDecimal getChinaTariffBudget() {
		return chinaTariffBudget;
	}

	public void setChinaTariffBudget(BigDecimal chinaTariffBudget) {
		this.chinaTariffBudget = chinaTariffBudget;
	}

	public BigDecimal getTotalToolingBudget() {
		return totalToolingBudget;
	}

	public void setTotalToolingBudget(BigDecimal totalToolingBudget) {
		this.totalToolingBudget = totalToolingBudget;
	}

	public String getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	public String getToolingNotes() {
		return toolingNotes;
	}

	public void setToolingNotes(String toolingNotes) {
		this.toolingNotes = toolingNotes;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getMoldId() {
		return moldId;
	}

	public void setMoldId(String moldId) {
		this.moldId = moldId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NtQuotePartInformation [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", materialDescription="
				+ materialDescription + ", partNumber=" + partNumber + ", cadFile=" + cadFile + ", eau=" + eau
				+ ", partWeight=" + partWeight + ", materialType=" + materialType + ", materialCost=" + materialCost
				+ ", extendedMaterialCostPer=" + extendedMaterialCostPer + ", externalMachineCostPer="
				+ externalMachineCostPer + ", purchaseComponentCost=" + purchaseComponentCost
				+ ", secondaryExternalOperationCost=" + secondaryExternalOperationCost + ", overhead=" + overhead
				+ ", packLogisticCostPer=" + packLogisticCostPer + ", machineSizeTons=" + machineSizeTons
				+ ", numberOfCavities=" + numberOfCavities + ", cycleTime=" + cycleTime + ", perUnit=" + perUnit
				+ ", totalPricePerChina=" + totalPricePerChina + ", totalPriceBudget=" + totalPriceBudget
				+ ", grainBudget=" + grainBudget + ", dogatingFixtureBudget=" + dogatingFixtureBudget + ", gaugeBudget="
				+ gaugeBudget + ", eoat=" + eoat + ", chinaTariffBudget=" + chinaTariffBudget + ", totalToolingBudget="
				+ totalToolingBudget + ", leadTime=" + leadTime + ", toolingNotes=" + toolingNotes
				+ ", partDescription=" + partDescription + ", jobId=" + jobId + ", moldId=" + moldId + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + "]";
	}

    
    
}
