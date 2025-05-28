package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
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
import jakarta.validation.constraints.NotNull;

@Entity
public class VendorProfile implements Serializable {

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

    @NotNull
    @Column(name = "vendor_id", nullable = false)
    private String vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "contact")
    private String contact;

    @Column(name = "entry_date")
    private ZonedDateTime entryDate;

    @Column(name = "trade_currency_id")
    private String tradeCurrencyId;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "address_3")
    private String address3;

    @Column(name = "mail_id")
    private String mailId;

    @Column(name = "status")
    private String status;

    @Column(name = "rating")
    private String rating;

    @Column(name = "is_delete_flag")
    private Integer isDeleteFlag;

    @Column(name = "related_buyer_uid")
    private String relatedBuyerUid;

    @Column(name = "country")
    private String country;

    @Column(name = "country_flag")
    private String countryFlag;

    @JsonIgnoreProperties(value = { "rfqDetail", "vendor" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "vendor")
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

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public ZonedDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(ZonedDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public String getTradeCurrencyId() {
		return tradeCurrencyId;
	}

	public void setTradeCurrencyId(String tradeCurrencyId) {
		this.tradeCurrencyId = tradeCurrencyId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getIsDeleteFlag() {
		return isDeleteFlag;
	}

	public void setIsDeleteFlag(Integer isDeleteFlag) {
		this.isDeleteFlag = isDeleteFlag;
	}

	public String getRelatedBuyerUid() {
		return relatedBuyerUid;
	}

	public void setRelatedBuyerUid(String relatedBuyerUid) {
		this.relatedBuyerUid = relatedBuyerUid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryFlag() {
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
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
		return "VendorProfile [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", vendorId=" + vendorId
				+ ", vendorName=" + vendorName + ", contact=" + contact + ", entryDate=" + entryDate
				+ ", tradeCurrencyId=" + tradeCurrencyId + ", address1=" + address1 + ", address2=" + address2
				+ ", address3=" + address3 + ", mailId=" + mailId + ", status=" + status + ", rating=" + rating
				+ ", isDeleteFlag=" + isDeleteFlag + ", relatedBuyerUid=" + relatedBuyerUid + ", country=" + country
				+ ", countryFlag=" + countryFlag + ", buyerRfqPricesDetail=" + buyerRfqPricesDetail + "]";
	}
    
    
    

}
