package com.yts.revaux.ntQuote.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nt_quote_vendor_quote")
public class NtQuoteVendor_Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer srNo;
    private UUID uid;
    private String vendorName;
    private Date quoteDate;
    private String fileName;
    private String browse;

    @ManyToOne
    @JoinColumn(name = "nt_quote_id", referencedColumnName = "id")
    private NtQuote ntQuote;

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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Date getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBrowse() {
		return browse;
	}

	public void setBrowse(String browse) {
		this.browse = browse;
	}

	public NtQuote getNtQuote() {
		return ntQuote;
	}

	public void setNtQuote(NtQuote ntQuote) {
		this.ntQuote = ntQuote;
	}

	@Override
	public String toString() {
		return "NtQuoteVendor_Quote [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", vendorName=" + vendorName
				+ ", quoteDate=" + quoteDate + ", fileName=" + fileName + ", browse=" + browse + ", ntQuote=" + ntQuote
				+ "]";
	}
    
    
    
}
