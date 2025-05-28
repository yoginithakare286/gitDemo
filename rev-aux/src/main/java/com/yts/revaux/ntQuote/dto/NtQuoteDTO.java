package com.yts.revaux.ntQuote.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class NtQuoteDTO implements Serializable {

    private Long id;

    private Integer srNo;

    @NotNull
    private UUID uid;

    @NotNull
    private String quoteKey;

    private String salesPerson;

    private String customerName;

    private String quoteNumber;

    private String status;

    private String moldNumber;

    private String partNumber;

    private LocalDate dueDate;

    private String moldManual;

    private String customerPo;

    private String vendorQuote;

    private String vendorPo;

    private String cadFile;

    private Integer quotedPrice;

    private String deliveryTime;

    private LocalDate quoteDate;

    private String createdBy;

    private Instant createdDate;

    private String updatedBy;

    private Instant updatedDate;

    private RfqDetailDTO rfqDetail;

    private NtQuoteProjectApprovalDTO ntQuoteProjectApproval;

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
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

    public LocalDate getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(LocalDate quoteDate) {
        this.quoteDate = quoteDate;
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

    public RfqDetailDTO getRfqDetail() {
        return rfqDetail;
    }

    public void setRfqDetail(RfqDetailDTO rfqDetail) {
        this.rfqDetail = rfqDetail;
    }

    public NtQuoteProjectApprovalDTO getNtQuoteProjectApproval() {
        return ntQuoteProjectApproval;
    }

    public void setNtQuoteProjectApproval(NtQuoteProjectApprovalDTO ntQuoteProjectApproval) {
        this.ntQuoteProjectApproval = ntQuoteProjectApproval;
    }
    

}
