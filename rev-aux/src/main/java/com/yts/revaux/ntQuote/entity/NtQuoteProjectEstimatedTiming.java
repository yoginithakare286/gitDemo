package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
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
@Table(name = "nt_quote_poject_est_timing")
public class NtQuoteProjectEstimatedTiming implements Serializable{

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
    
    @Column(name = "prototype_del_date")
    private ZonedDateTime prototypeDelDate;
    
    @Column(name = "desg_vald_del_date")
    private ZonedDateTime desgValdDelDate;
    
    @Column(name = "prd_vald_del_date")
    private ZonedDateTime prdValdDelDate;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "created_date")
    private ZonedDateTime createdDate;
    
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

	public NtQuoteList getNtQuote() {
		return ntQuote;
	}

	public void setNtQuote(NtQuoteList ntQuote) {
		this.ntQuote = ntQuote;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NtQuoteProjectEstimatedTiming [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", prototypeDelDate="
				+ prototypeDelDate + ", desgValdDelDate=" + desgValdDelDate + ", prdValdDelDate=" + prdValdDelDate
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}
    
    
	
}
