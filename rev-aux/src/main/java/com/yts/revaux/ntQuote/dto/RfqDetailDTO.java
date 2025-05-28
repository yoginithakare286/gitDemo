package com.yts.revaux.ntQuote.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class RfqDetailDTO implements Serializable {

    private Long id;

    private Integer srNo;

    @NotNull
    private UUID uid;

    private String rfqId;

    private LocalDate orderDate;

    private LocalDate startDate;

    private LocalDate endDate;

    private String itemDescription;

    private String rfqStatus;

    private String rfqType;

    private String customer;

    private LocalDate rfqReceivedDate;

    private LocalDate quoteDueDate;

    private String part;

    private String buyer;

    private String expectedLaunch;

    private String requestor;

    private String raStatus;

    private Integer isDelete;

    private String customerFeedback;

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

    public String getRfqId() {
        return rfqId;
    }

    public void setRfqId(String rfqId) {
        this.rfqId = rfqId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getRfqStatus() {
        return rfqStatus;
    }

    public void setRfqStatus(String rfqStatus) {
        this.rfqStatus = rfqStatus;
    }

    public String getRfqType() {
        return rfqType;
    }

    public void setRfqType(String rfqType) {
        this.rfqType = rfqType;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getRfqReceivedDate() {
        return rfqReceivedDate;
    }

    public void setRfqReceivedDate(LocalDate rfqReceivedDate) {
        this.rfqReceivedDate = rfqReceivedDate;
    }

    public LocalDate getQuoteDueDate() {
        return quoteDueDate;
    }

    public void setQuoteDueDate(LocalDate quoteDueDate) {
        this.quoteDueDate = quoteDueDate;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getExpectedLaunch() {
        return expectedLaunch;
    }

    public void setExpectedLaunch(String expectedLaunch) {
        this.expectedLaunch = expectedLaunch;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getRaStatus() {
        return raStatus;
    }

    public void setRaStatus(String raStatus) {
        this.raStatus = raStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
    }

}
