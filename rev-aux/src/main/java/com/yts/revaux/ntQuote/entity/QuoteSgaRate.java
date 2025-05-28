package com.yts.revaux.ntQuote.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quote_sga_rate")
public class QuoteSgaRate {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false, unique = true)
	    private UUID uid;

	    @Column(name = "sga_rate", nullable = false)
	    private Integer sgaRate;

	    @Column(name = "created_date", nullable = false, updatable = false)
	    private LocalDateTime createdDate;

	    @Column(name = "created_by", nullable = false, updatable = false)
	    private String createdBy;

	    @Column(name = "updated_date")
	    private LocalDateTime updatedDate;

	    @Column(name = "updated_by")
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

		public Integer getSgaRate() {
			return sgaRate;
		}

		public void setSgaRate(Integer sgaRate) {
			this.sgaRate = sgaRate;
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

		@Override
		public String toString() {
			return "QuoteSgaRate [id=" + id + ", uid=" + uid + ", sgaRate=" + sgaRate + ", createdDate=" + createdDate
					+ ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + "]";
		}
	
	
	    
	    
}
