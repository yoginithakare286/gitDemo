package com.yts.revaux.ntQuote.entity;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "nt_quote")
public class NtQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer srNo;
    private UUID uid;
    private String quoteKey;
    private String salesPerson;
    private String customerName;
    private String quoteNumber;
    private String status;
    private String moldNumber;
    private String partNumber;
    private Date dueDate;
    private String moldManual;
    private String customerPo;
    private String vendorQuote;
    private String vendorPo;
    private String cadFile;
    private Integer quotedPrice;
    private String deliveryTime;
    private Date quoteDate;
    private String createdBy;
    private Timestamp createdDate;
    private String updatedBy;
    private Timestamp updatedDate;

    @OneToMany(mappedBy = "ntQuote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NtQuoteCustomer_Po> customerPos;

    @OneToMany(mappedBy = "ntQuote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NtQuoteVendor_Po> vendorPos;

    @OneToMany(mappedBy = "ntQuote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NtQuoteVendor_Quote> vendorQuotes;

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

	public String getQuoteKey() {
		return quoteKey;
	}

	public void setQuoteKey(String quoteKey) {
		this.quoteKey = quoteKey;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getQuoteNumber() {
		return quoteNumber;
	}

	public void setQuoteNumber(String quoteNumber) {
		this.quoteNumber = quoteNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMoldNumber() {
		return moldNumber;
	}

	public void setMoldNumber(String moldNumber) {
		this.moldNumber = moldNumber;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getMoldManual() {
		return moldManual;
	}

	public void setMoldManual(String moldManual) {
		this.moldManual = moldManual;
	}

	public String getCustomerPo() {
		return customerPo;
	}

	public void setCustomerPo(String customerPo) {
		this.customerPo = customerPo;
	}

	public String getVendorQuote() {
		return vendorQuote;
	}

	public void setVendorQuote(String vendorQuote) {
		this.vendorQuote = vendorQuote;
	}

	public String getVendorPo() {
		return vendorPo;
	}

	public void setVendorPo(String vendorPo) {
		this.vendorPo = vendorPo;
	}

	public String getCadFile() {
		return cadFile;
	}

	public void setCadFile(String cadFile) {
		this.cadFile = cadFile;
	}

	public Integer getQuotedPrice() {
		return quotedPrice;
	}

	public void setQuotedPrice(Integer quotedPrice) {
		this.quotedPrice = quotedPrice;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Date getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<NtQuoteCustomer_Po> getCustomerPos() {
		return customerPos;
	}

	public void setCustomerPos(List<NtQuoteCustomer_Po> customerPos) {
		this.customerPos = customerPos;
	}

	public List<NtQuoteVendor_Po> getVendorPos() {
		return vendorPos;
	}

	public void setVendorPos(List<NtQuoteVendor_Po> vendorPos) {
		this.vendorPos = vendorPos;
	}

	public List<NtQuoteVendor_Quote> getVendorQuotes() {
		return vendorQuotes;
	}

	public void setVendorQuotes(List<NtQuoteVendor_Quote> vendorQuotes) {
		this.vendorQuotes = vendorQuotes;
	}

	@Override
	public String toString() {
		return "NtQuote [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", quoteKey=" + quoteKey + ", salesPerson="
				+ salesPerson + ", customerName=" + customerName + ", quoteNumber=" + quoteNumber + ", status=" + status
				+ ", moldNumber=" + moldNumber + ", partNumber=" + partNumber + ", dueDate=" + dueDate + ", moldManual="
				+ moldManual + ", customerPo=" + customerPo + ", vendorQuote=" + vendorQuote + ", vendorPo=" + vendorPo
				+ ", cadFile=" + cadFile + ", quotedPrice=" + quotedPrice + ", deliveryTime=" + deliveryTime
				+ ", quoteDate=" + quoteDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", customerPos=" + customerPos
				+ ", vendorPos=" + vendorPos + ", vendorQuotes=" + vendorQuotes + "]";
	}
    
    
}
