package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "rfq_detail")
public class RfqDetail implements Serializable {

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

    @Column(name = "rfq_id")
    private String rfqId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "rfq_status")
    private String rfqStatus;

    @Column(name = "rfq_type")
    private String rfqType;

    @Column(name = "customer")
    private String customer;

    @Column(name = "rfq_received_date")
    private LocalDate rfqReceivedDate;

    @Column(name = "quote_due_date")
    private LocalDate quoteDueDate;

    @Column(name = "part")
    private String part;

    @Column(name = "buyer")
    private String buyer;

    @Column(name = "expected_launch")
    private String expectedLaunch;

    @Column(name = "requestor")
    private String requestor;

    @Column(name = "ra_status")
    private String raStatus;

    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "customer_feedback")
    private String customerFeedback;

    @JsonIgnoreProperties(value = { "rfqDetail", "vendor" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "rfqDetail")
    @org.springframework.data.annotation.Transient
    private BuyerRfqPricesDetail buyerRfqPricesDetail;

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

	public BuyerRfqPricesDetail getBuyerRfqPricesDetail() {
		return buyerRfqPricesDetail;
	}

	public void setBuyerRfqPricesDetail(BuyerRfqPricesDetail buyerRfqPricesDetail) {
		this.buyerRfqPricesDetail = buyerRfqPricesDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RfqDetail [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", rfqId=" + rfqId + ", orderDate="
				+ orderDate + ", startDate=" + startDate + ", endDate=" + endDate + ", itemDescription="
				+ itemDescription + ", rfqStatus=" + rfqStatus + ", rfqType=" + rfqType + ", customer=" + customer
				+ ", rfqReceivedDate=" + rfqReceivedDate + ", quoteDueDate=" + quoteDueDate + ", part=" + part
				+ ", buyer=" + buyer + ", expectedLaunch=" + expectedLaunch + ", requestor=" + requestor + ", raStatus="
				+ raStatus + ", isDelete=" + isDelete + ", customerFeedback=" + customerFeedback
				+ ", buyerRfqPricesDetail=" + buyerRfqPricesDetail + "]";
	}
    
    

}
