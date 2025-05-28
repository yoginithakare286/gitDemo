package com.yts.revaux.ntQuote.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;

public class QuoteMachineEfficiencyDTO {

	  private Integer id;

	    private UUID uid;

	    private String machineEfficiency;

	    private LocalDateTime createdDate;

	    private String createdBy;

	    private LocalDateTime updatedDate;

	    private String updatedBy;

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

		public String getMachineEfficiency() {
			return machineEfficiency;
		}

		public void setMachineEfficiency(String machineEfficiency) {
			this.machineEfficiency = machineEfficiency;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public LocalDateTime getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(LocalDateTime updatedDate) {
			this.updatedDate = updatedDate;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}
	
	    
	    
}
