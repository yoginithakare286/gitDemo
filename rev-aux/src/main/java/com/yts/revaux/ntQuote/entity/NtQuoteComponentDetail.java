package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
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
@Table(name = "nt_quote_component_detail")
public class NtQuoteComponentDetail implements Serializable {

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

    @Column(name = "eau")
    private Integer eau;

    @Column(name = "manufacturing_location")
    private String manufacturingLocation;

    @Column(name = "fob_location")
    private String fobLocation;

    @Column(name = "packing_requirements")
    private String packingRequirements;

    @Column(name = "machine_size")
    private String machineSize;

    @Column(name = "cycle_time")
    private Integer cycleTime;

    @Column(name = "part_weight")
    private Integer partWeight;

    @Column(name = "runner_weight")
    private Integer runnerWeight;

    @Column(name = "cavities")
    private Integer cavities;

    @Column(name = "comments")
    private String comments;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = { "buyerRfqPricesDetail" }, allowSetters = true)
    private RfqDetail rfqDetail;
    
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
    
	public RfqDetail getRfqDetail() {
		return rfqDetail;
	}

	public void setRfqDetail(RfqDetail rfqDetail) {
		this.rfqDetail = rfqDetail;
	}

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

	public Integer getEau() {
		return eau;
	}

	public void setEau(Integer eau) {
		this.eau = eau;
	}

	public String getManufacturingLocation() {
		return manufacturingLocation;
	}

	public void setManufacturingLocation(String manufacturingLocation) {
		this.manufacturingLocation = manufacturingLocation;
	}

	public String getFobLocation() {
		return fobLocation;
	}

	public void setFobLocation(String fobLocation) {
		this.fobLocation = fobLocation;
	}

	public String getPackingRequirements() {
		return packingRequirements;
	}

	public void setPackingRequirements(String packingRequirements) {
		this.packingRequirements = packingRequirements;
	}

	public String getMachineSize() {
		return machineSize;
	}

	public void setMachineSize(String machineSize) {
		this.machineSize = machineSize;
	}

	public Integer getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(Integer cycleTime) {
		this.cycleTime = cycleTime;
	}

	public Integer getPartWeight() {
		return partWeight;
	}

	public void setPartWeight(Integer partWeight) {
		this.partWeight = partWeight;
	}

	public Integer getRunnerWeight() {
		return runnerWeight;
	}

	public void setRunnerWeight(Integer runnerWeight) {
		this.runnerWeight = runnerWeight;
	}

	public Integer getCavities() {
		return cavities;
	}

	public void setCavities(Integer cavities) {
		this.cavities = cavities;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
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
		return "NtQuoteComponentDetail [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", materialDescription="
				+ materialDescription + ", partNumber=" + partNumber + ", eau=" + eau + ", manufacturingLocation="
				+ manufacturingLocation + ", fobLocation=" + fobLocation + ", packingRequirements="
				+ packingRequirements + ", machineSize=" + machineSize + ", cycleTime=" + cycleTime + ", partWeight="
				+ partWeight + ", runnerWeight=" + runnerWeight + ", cavities=" + cavities + ", comments=" + comments
				+ ", riskLevel=" + riskLevel + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
    
    

}
