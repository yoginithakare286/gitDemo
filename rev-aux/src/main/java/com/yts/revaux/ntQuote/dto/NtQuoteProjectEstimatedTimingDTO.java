package com.yts.revaux.ntQuote.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class NtQuoteProjectEstimatedTimingDTO implements Serializable{

	
	    private Long id;

	    private Integer srNo;
	    
	    @NotNull
	    private UUID uid;
	    
	    private ZonedDateTime prototypeDelDate;
	    
	    private ZonedDateTime desgValdDelDate;
	    
	    private ZonedDateTime prdValdDelDate;
	    
	    private String createdBy;
	    
	    private ZonedDateTime createdDate;
	    
	    private String updatedBy;

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

		public ZonedDateTime getPrototypeDelDate() {
			return prototypeDelDate;
		}

		public void setPrototypeDelDate(ZonedDateTime prototypeDelDate) {
			this.prototypeDelDate = prototypeDelDate;
		}

		public ZonedDateTime getDesgValdDelDate() {
			return desgValdDelDate;
		}

		public void setDesgValdDelDate(ZonedDateTime desgValdDelDate) {
			this.desgValdDelDate = desgValdDelDate;
		}

		public ZonedDateTime getPrdValdDelDate() {
			return prdValdDelDate;
		}

		public void setPrdValdDelDate(ZonedDateTime prdValdDelDate) {
			this.prdValdDelDate = prdValdDelDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public ZonedDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(ZonedDateTime createdDate) {
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

		

	    
}
