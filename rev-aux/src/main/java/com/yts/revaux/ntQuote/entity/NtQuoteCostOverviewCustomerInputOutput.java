package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nt_quote_customer_input_output")
public class NtQuoteCostOverviewCustomerInputOutput implements Serializable {

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

	    @Column(name = "material_id")
	    private String materialId;

	    @Column(name = "supplier")
	    private String supplier;

	    @Column(name = "est_annual_volume")
	    private Integer estAnnualVolume;

	    @Column(name = "est_production_run_yrs")
	    private Integer estProductionRunYrs;

	    @Column(name = "material_cost_lb", precision = 21, scale = 2)
	    private BigDecimal materialCostLb;

	    @Column(name = "part_weight_lb", precision = 21, scale = 2)
	    private BigDecimal partWeightLb;

	    @Column(name = "runner_weight_lb", precision = 21, scale = 2)
	    private BigDecimal runnerWeightLb;

	    @Column(name = "machine_size")
	    private String machineSize;

	    @Column(name = "machine_rate", precision = 21, scale = 2)
	    private BigDecimal machineRate;

	    @Column(name = "scrap_rate", precision = 21, scale = 2)
	    private BigDecimal scrapRate;

	    @Column(name = "machine_efficiency", precision = 21, scale = 2)
	    private BigDecimal machineEfficiency;

	    @Column(name = "fte")
	    private String fte;

	    @Column(name = "labor_rate", precision = 21, scale = 2)
	    private BigDecimal laborRate;

	    @Column(name = "number_of_cavities")
	    private Integer numberOfCavities;

	    @Column(name = "cycle_time")
	    private Integer cycleTime;

	    @Column(name = "purchase_component_cost_part", precision = 21, scale = 2)
	    private BigDecimal purchaseComponentCostPart;

	    @Column(name = "secondary_operation_external_process")
	    private String secondaryOperationExternalProcess;

	    @Column(name = "secondary_operation_labor_rate", precision = 21, scale = 2)
	    private BigDecimal secondaryOperationLaborRate;

	    @Column(name = "secondary_operation_machine_rate", precision = 21, scale = 2)
	    private BigDecimal secondaryOperationMachineRate;

	    @Column(name = "secondary_operation_cycle_time")
	    private Integer secondaryOperationCycleTime;

	    @Column(name = "external_operation_rate", precision = 21, scale = 2)
	    private BigDecimal externalOperationRate;

	    @Column(name = "preventative_maintenance_frequency")
	    private Integer preventativeMaintenanceFrequency;

	    @Column(name = "preventative_maintenance_cost")
	    private Integer preventativeMaintenanceCost;

	    @Column(name = "target_profit", precision = 21, scale = 2)
	    private BigDecimal targetProfit;

	    @Column(name = "target_material_markup", precision = 21, scale = 2)
	    private BigDecimal targetMaterialMarkup;

	    @Column(name = "actual_material_cost", precision = 21, scale = 2)
	    private BigDecimal actualMaterialCost;

	    @Column(name = "part_per_hours", precision = 21, scale = 2)
	    private BigDecimal partPerHours;

	    @Column(name = "est_lot_size", precision = 21, scale = 2)
	    private BigDecimal estLotSize;

	    @Column(name = "setup_hours", precision = 21, scale = 2)
	    private BigDecimal setupHours;

	    @Column(name = "external_operation_cost_per", precision = 21, scale = 2)
	    private BigDecimal externalOperationCostPer;

	    @Column(name = "external_machine_cost_per", precision = 21, scale = 2)
	    private BigDecimal externalMachineCostPer;

	    @Column(name = "extended_labor_cost_per", precision = 21, scale = 2)
	    private BigDecimal extendedLaborCostPer;

	    @Column(name = "extended_material_cost_per", precision = 21, scale = 2)
	    private BigDecimal extendedMaterialCostPer;

	    @Column(name = "pack_logistic_cost_per", precision = 21, scale = 2)
	    private BigDecimal packLogisticCostPer;

	    @Column(name = "total_production_cost", precision = 21, scale = 2)
	    private BigDecimal totalProductionCost;

	    @Column(name = "total_material_cost", precision = 21, scale = 2)
	    private BigDecimal totalMaterialCost;

	    @Column(name = "total_cost_sga_profit", precision = 21, scale = 2)
	    private BigDecimal totalCostSgaProfit;

	    @Column(name = "sga_rate", precision = 21, scale = 2)
	    private BigDecimal sgaRate;

	    @Column(name = "profit", precision = 21, scale = 2)
	    private BigDecimal profit;

	    @Column(name = "part_price", precision = 21, scale = 2)
	    private BigDecimal partPrice;

	    @Column(name = "total_cost", precision = 21, scale = 2)
	    private BigDecimal totalCost;

	    @Column(name = "total_sales", precision = 21, scale = 2)
	    private BigDecimal totalSales;

	    @Column(name = "total_profit", precision = 21, scale = 2)
	    private BigDecimal totalProfit;

	    @Column(name = "cost_material", precision = 21, scale = 2)
	    private BigDecimal costMaterial;

	    @Column(name = "total_contribution_margin", precision = 21, scale = 2)
	    private BigDecimal totalContributionMargin;

	    @Column(name = "contribution_margin", precision = 21, scale = 2)
	    private BigDecimal contributionMargin;

	    @Column(name = "material_contribution_margin", precision = 21, scale = 2)
	    private BigDecimal materialContributionMargin;

	    @Column(name = "comments")
	    private String comments;

	    @Column(name = "created_by")
	    private String createdBy;

	    @Column(name = "created_date")
	    private Instant createdDate;

	    @Column(name = "updated_by")
	    private String updatedBy;

	    @Column(name = "updated_date")
	    private Instant updatedDate;

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

		public String getMaterialId() {
			return materialId;
		}

		public void setMaterialId(String materialId) {
			this.materialId = materialId;
		}

		public String getSupplier() {
			return supplier;
		}

		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}

		public Integer getEstAnnualVolume() {
			return estAnnualVolume;
		}

		public void setEstAnnualVolume(Integer estAnnualVolume) {
			this.estAnnualVolume = estAnnualVolume;
		}

		public Integer getEstProductionRunYrs() {
			return estProductionRunYrs;
		}

		public void setEstProductionRunYrs(Integer estProductionRunYrs) {
			this.estProductionRunYrs = estProductionRunYrs;
		}

		public BigDecimal getMaterialCostLb() {
			return materialCostLb;
		}

		public void setMaterialCostLb(BigDecimal materialCostLb) {
			this.materialCostLb = materialCostLb;
		}

		public BigDecimal getPartWeightLb() {
			return partWeightLb;
		}

		public void setPartWeightLb(BigDecimal partWeightLb) {
			this.partWeightLb = partWeightLb;
		}

		public BigDecimal getRunnerWeightLb() {
			return runnerWeightLb;
		}

		public void setRunnerWeightLb(BigDecimal runnerWeightLb) {
			this.runnerWeightLb = runnerWeightLb;
		}

		public String getMachineSize() {
			return machineSize;
		}

		public void setMachineSize(String machineSize) {
			this.machineSize = machineSize;
		}

		public BigDecimal getMachineRate() {
			return machineRate;
		}

		public void setMachineRate(BigDecimal machineRate) {
			this.machineRate = machineRate;
		}

		public BigDecimal getScrapRate() {
			return scrapRate;
		}

		public void setScrapRate(BigDecimal scrapRate) {
			this.scrapRate = scrapRate;
		}

		public BigDecimal getMachineEfficiency() {
			return machineEfficiency;
		}

		public void setMachineEfficiency(BigDecimal machineEfficiency) {
			this.machineEfficiency = machineEfficiency;
		}

		public String getFte() {
			return fte;
		}

		public void setFte(String fte) {
			this.fte = fte;
		}

		public BigDecimal getLaborRate() {
			return laborRate;
		}

		public void setLaborRate(BigDecimal laborRate) {
			this.laborRate = laborRate;
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

		public BigDecimal getPurchaseComponentCostPart() {
			return purchaseComponentCostPart;
		}

		public void setPurchaseComponentCostPart(BigDecimal purchaseComponentCostPart) {
			this.purchaseComponentCostPart = purchaseComponentCostPart;
		}

		public String getSecondaryOperationExternalProcess() {
			return secondaryOperationExternalProcess;
		}

		public void setSecondaryOperationExternalProcess(String secondaryOperationExternalProcess) {
			this.secondaryOperationExternalProcess = secondaryOperationExternalProcess;
		}

		public BigDecimal getSecondaryOperationLaborRate() {
			return secondaryOperationLaborRate;
		}

		public void setSecondaryOperationLaborRate(BigDecimal secondaryOperationLaborRate) {
			this.secondaryOperationLaborRate = secondaryOperationLaborRate;
		}

		public BigDecimal getSecondaryOperationMachineRate() {
			return secondaryOperationMachineRate;
		}

		public void setSecondaryOperationMachineRate(BigDecimal secondaryOperationMachineRate) {
			this.secondaryOperationMachineRate = secondaryOperationMachineRate;
		}

		public Integer getSecondaryOperationCycleTime() {
			return secondaryOperationCycleTime;
		}

		public void setSecondaryOperationCycleTime(Integer secondaryOperationCycleTime) {
			this.secondaryOperationCycleTime = secondaryOperationCycleTime;
		}

		public BigDecimal getExternalOperationRate() {
			return externalOperationRate;
		}

		public void setExternalOperationRate(BigDecimal externalOperationRate) {
			this.externalOperationRate = externalOperationRate;
		}

		public Integer getPreventativeMaintenanceFrequency() {
			return preventativeMaintenanceFrequency;
		}

		public void setPreventativeMaintenanceFrequency(Integer preventativeMaintenanceFrequency) {
			this.preventativeMaintenanceFrequency = preventativeMaintenanceFrequency;
		}

		public Integer getPreventativeMaintenanceCost() {
			return preventativeMaintenanceCost;
		}

		public void setPreventativeMaintenanceCost(Integer preventativeMaintenanceCost) {
			this.preventativeMaintenanceCost = preventativeMaintenanceCost;
		}

		public BigDecimal getTargetProfit() {
			return targetProfit;
		}

		public void setTargetProfit(BigDecimal targetProfit) {
			this.targetProfit = targetProfit;
		}

		public BigDecimal getTargetMaterialMarkup() {
			return targetMaterialMarkup;
		}

		public void setTargetMaterialMarkup(BigDecimal targetMaterialMarkup) {
			this.targetMaterialMarkup = targetMaterialMarkup;
		}

		public BigDecimal getActualMaterialCost() {
			return actualMaterialCost;
		}

		public void setActualMaterialCost(BigDecimal actualMaterialCost) {
			this.actualMaterialCost = actualMaterialCost;
		}

		public BigDecimal getPartPerHours() {
			return partPerHours;
		}

		public void setPartPerHours(BigDecimal partPerHours) {
			this.partPerHours = partPerHours;
		}

		public BigDecimal getEstLotSize() {
			return estLotSize;
		}

		public void setEstLotSize(BigDecimal estLotSize) {
			this.estLotSize = estLotSize;
		}

		public BigDecimal getSetupHours() {
			return setupHours;
		}

		public void setSetupHours(BigDecimal setupHours) {
			this.setupHours = setupHours;
		}

		public BigDecimal getExternalOperationCostPer() {
			return externalOperationCostPer;
		}

		public void setExternalOperationCostPer(BigDecimal externalOperationCostPer) {
			this.externalOperationCostPer = externalOperationCostPer;
		}

		public BigDecimal getExternalMachineCostPer() {
			return externalMachineCostPer;
		}

		public void setExternalMachineCostPer(BigDecimal externalMachineCostPer) {
			this.externalMachineCostPer = externalMachineCostPer;
		}

		public BigDecimal getExtendedLaborCostPer() {
			return extendedLaborCostPer;
		}

		public void setExtendedLaborCostPer(BigDecimal extendedLaborCostPer) {
			this.extendedLaborCostPer = extendedLaborCostPer;
		}

		public BigDecimal getExtendedMaterialCostPer() {
			return extendedMaterialCostPer;
		}

		public void setExtendedMaterialCostPer(BigDecimal extendedMaterialCostPer) {
			this.extendedMaterialCostPer = extendedMaterialCostPer;
		}

		public BigDecimal getPackLogisticCostPer() {
			return packLogisticCostPer;
		}

		public void setPackLogisticCostPer(BigDecimal packLogisticCostPer) {
			this.packLogisticCostPer = packLogisticCostPer;
		}

		public BigDecimal getTotalProductionCost() {
			return totalProductionCost;
		}

		public void setTotalProductionCost(BigDecimal totalProductionCost) {
			this.totalProductionCost = totalProductionCost;
		}

		public BigDecimal getTotalMaterialCost() {
			return totalMaterialCost;
		}

		public void setTotalMaterialCost(BigDecimal totalMaterialCost) {
			this.totalMaterialCost = totalMaterialCost;
		}

		public BigDecimal getTotalCostSgaProfit() {
			return totalCostSgaProfit;
		}

		public void setTotalCostSgaProfit(BigDecimal totalCostSgaProfit) {
			this.totalCostSgaProfit = totalCostSgaProfit;
		}

		public BigDecimal getSgaRate() {
			return sgaRate;
		}

		public void setSgaRate(BigDecimal sgaRate) {
			this.sgaRate = sgaRate;
		}

		public BigDecimal getProfit() {
			return profit;
		}

		public void setProfit(BigDecimal profit) {
			this.profit = profit;
		}

		public BigDecimal getPartPrice() {
			return partPrice;
		}

		public void setPartPrice(BigDecimal partPrice) {
			this.partPrice = partPrice;
		}

		public BigDecimal getTotalCost() {
			return totalCost;
		}

		public void setTotalCost(BigDecimal totalCost) {
			this.totalCost = totalCost;
		}

		public BigDecimal getTotalSales() {
			return totalSales;
		}

		public void setTotalSales(BigDecimal totalSales) {
			this.totalSales = totalSales;
		}

		public BigDecimal getTotalProfit() {
			return totalProfit;
		}

		public void setTotalProfit(BigDecimal totalProfit) {
			this.totalProfit = totalProfit;
		}

		public BigDecimal getCostMaterial() {
			return costMaterial;
		}

		public void setCostMaterial(BigDecimal costMaterial) {
			this.costMaterial = costMaterial;
		}

		public BigDecimal getTotalContributionMargin() {
			return totalContributionMargin;
		}

		public void setTotalContributionMargin(BigDecimal totalContributionMargin) {
			this.totalContributionMargin = totalContributionMargin;
		}

		public BigDecimal getContributionMargin() {
			return contributionMargin;
		}

		public void setContributionMargin(BigDecimal contributionMargin) {
			this.contributionMargin = contributionMargin;
		}

		public BigDecimal getMaterialContributionMargin() {
			return materialContributionMargin;
		}

		public void setMaterialContributionMargin(BigDecimal materialContributionMargin) {
			this.materialContributionMargin = materialContributionMargin;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
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
			return "NtQuoteCostOverviewCustomerInputOutput [id=" + id + ", srNo=" + srNo + ", uid=" + uid
					+ ", materialDescription=" + materialDescription + ", partNumber=" + partNumber + ", materialId="
					+ materialId + ", supplier=" + supplier + ", estAnnualVolume=" + estAnnualVolume
					+ ", estProductionRunYrs=" + estProductionRunYrs + ", materialCostLb=" + materialCostLb
					+ ", partWeightLb=" + partWeightLb + ", runnerWeightLb=" + runnerWeightLb + ", machineSize="
					+ machineSize + ", machineRate=" + machineRate + ", scrapRate=" + scrapRate + ", machineEfficiency="
					+ machineEfficiency + ", fte=" + fte + ", laborRate=" + laborRate + ", numberOfCavities="
					+ numberOfCavities + ", cycleTime=" + cycleTime + ", purchaseComponentCostPart="
					+ purchaseComponentCostPart + ", secondaryOperationExternalProcess="
					+ secondaryOperationExternalProcess + ", secondaryOperationLaborRate=" + secondaryOperationLaborRate
					+ ", secondaryOperationMachineRate=" + secondaryOperationMachineRate
					+ ", secondaryOperationCycleTime=" + secondaryOperationCycleTime + ", externalOperationRate="
					+ externalOperationRate + ", preventativeMaintenanceFrequency=" + preventativeMaintenanceFrequency
					+ ", preventativeMaintenanceCost=" + preventativeMaintenanceCost + ", targetProfit=" + targetProfit
					+ ", targetMaterialMarkup=" + targetMaterialMarkup + ", actualMaterialCost=" + actualMaterialCost
					+ ", partPerHours=" + partPerHours + ", estLotSize=" + estLotSize + ", setupHours=" + setupHours
					+ ", externalOperationCostPer=" + externalOperationCostPer + ", externalMachineCostPer="
					+ externalMachineCostPer + ", extendedLaborCostPer=" + extendedLaborCostPer
					+ ", extendedMaterialCostPer=" + extendedMaterialCostPer + ", packLogisticCostPer="
					+ packLogisticCostPer + ", totalProductionCost=" + totalProductionCost + ", totalMaterialCost="
					+ totalMaterialCost + ", totalCostSgaProfit=" + totalCostSgaProfit + ", sgaRate=" + sgaRate
					+ ", profit=" + profit + ", partPrice=" + partPrice + ", totalCost=" + totalCost + ", totalSales="
					+ totalSales + ", totalProfit=" + totalProfit + ", costMaterial=" + costMaterial
					+ ", totalContributionMargin=" + totalContributionMargin + ", contributionMargin="
					+ contributionMargin + ", materialContributionMargin=" + materialContributionMargin + ", comments="
					+ comments + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
					+ updatedBy + ", updatedDate=" + updatedDate + "]";
		}
	    
	    
	    
}
