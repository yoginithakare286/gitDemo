package com.yts.revaux.ntQuote.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rfq_detail_tbl")
public class RfqDetailTbl {
    @Id
    @Column(name = "rfq_id")
    private String rfqId;

    private String rfqStatus;
    private String customer;
    private String rfqReceivedDate;
    private String quoteDueDate;
    private String part;
    private String requestor;
    private Integer isDelete;
	public String getRfqId() {
		return rfqId;
	}
	public void setRfqId(String rfqId) {
		this.rfqId = rfqId;
	}
	public String getRfqStatus() {
		return rfqStatus;
	}
	public void setRfqStatus(String rfqStatus) {
		this.rfqStatus = rfqStatus;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getRfqReceivedDate() {
		return rfqReceivedDate;
	}
	public void setRfqReceivedDate(String rfqReceivedDate) {
		this.rfqReceivedDate = rfqReceivedDate;
	}
	public String getQuoteDueDate() {
		return quoteDueDate;
	}
	public void setQuoteDueDate(String quoteDueDate) {
		this.quoteDueDate = quoteDueDate;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "RfqDetailTbl [rfqId=" + rfqId + ", rfqStatus=" + rfqStatus + ", customer=" + customer
				+ ", rfqReceivedDate=" + rfqReceivedDate + ", quoteDueDate=" + quoteDueDate + ", part=" + part
				+ ", requestor=" + requestor + ", isDelete=" + isDelete + "]";
	}
    
    
}
