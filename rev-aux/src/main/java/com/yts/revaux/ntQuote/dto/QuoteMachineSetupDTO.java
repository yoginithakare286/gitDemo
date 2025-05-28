package com.yts.revaux.ntQuote.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;

public class QuoteMachineSetupDTO {

	 private Integer id;

	    private UUID uid;

	    private String machineSize;

	    private Double machineRate;

	    private Double setupTime;

	    private String standard;

	    private String metric;

	    private String platenSize;

	    private Double minMoldHeight;

	    private Double toggelMachine;

	    private Double maxDaylight;

	    @Column(name = "min_mold_hv")
	    private Double minMoldHv;

	    private String createdBy;

	    private LocalDateTime createdDate;

	    private String updatedBy;

	    private LocalDateTime updatedDate;

	    private Integer isDelete;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public UUID getUid() {
			return uid;
		}

		public void setUid(UUID uid) {
			this.uid = uid;
		}

		public String getMachineSize() {
			return machineSize;
		}

		public void setMachineSize(String machineSize) {
			this.machineSize = machineSize;
		}

		public Double getMachineRate() {
			return machineRate;
		}

		public void setMachineRate(Double machineRate) {
			this.machineRate = machineRate;
		}

		public Double getSetupTime() {
			return setupTime;
		}

		public void setSetupTime(Double setupTime) {
			this.setupTime = setupTime;
		}

		public String getStandard() {
			return standard;
		}

		public void setStandard(String standard) {
			this.standard = standard;
		}

		public String getMetric() {
			return metric;
		}

		public void setMetric(String metric) {
			this.metric = metric;
		}

		public String getPlatenSize() {
			return platenSize;
		}

		public void setPlatenSize(String platenSize) {
			this.platenSize = platenSize;
		}

		public Double getMinMoldHeight() {
			return minMoldHeight;
		}

		public void setMinMoldHeight(Double minMoldHeight) {
			this.minMoldHeight = minMoldHeight;
		}

		public Double getToggelMachine() {
			return toggelMachine;
		}

		public void setToggelMachine(Double toggelMachine) {
			this.toggelMachine = toggelMachine;
		}

		public Double getMaxDaylight() {
			return maxDaylight;
		}

		public void setMaxDaylight(Double maxDaylight) {
			this.maxDaylight = maxDaylight;
		}

		public Double getMinMoldHv() {
			return minMoldHv;
		}

		public void setMinMoldHv(Double minMoldHv) {
			this.minMoldHv = minMoldHv;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		public LocalDateTime getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(LocalDateTime updatedDate) {
			this.updatedDate = updatedDate;
		}

		public Integer getIsDelete() {
			return isDelete;
		}

		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}
	    
	    
	
}
