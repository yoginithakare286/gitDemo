package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nt_quote")
public class NtQuoteList implements Serializable {

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
    @Column(name = "quote_key", nullable = false)
    private String quoteKey;

    @Column(name = "sales_person")
    private String salesPerson;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "quote_number")
    private String quoteNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "mold_number")
    private String moldNumber;

    @Column(name = "part_number")
    private String partNumber;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "mold_manual")
    private String moldManual;

    @Column(name = "customer_po")
    private String customerPo;

    @Column(name = "vendor_quote")
    private String vendorQuote;

    @Column(name = "vendor_po")
    private String vendorPo;

    @Column(name = "cad_file")
    private String cadFile;

    @Column(name = "quoted_price")
    private Integer quotedPrice;

    @Column(name = "delivery_time")
    private String deliveryTime;

    @Column(name = "quote_date")
    private LocalDate quoteDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteProjectConsiderations> projectConsiderations = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteContractReviewInformation> contractReviewInformations = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteCustomerInputOutputVersion> customerInputOutputVersions = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuotePartInformation> partInformationMasters = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteComments> comments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteTermsConditions> termsConditions = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtProjectApproval> projectApprovals = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuotePartInformationVersion> partInformationVersions = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteCustomerPo> customerPos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteVendorQuote> vendorQuotes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ntQuote")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "ntQuote" }, allowSetters = true)
    private Set<NtQuoteVendorPo> vendorPos = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = { "buyerRfqPricesDetail" }, allowSetters = true)
    private RfqDetail rfqDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "ntQuotes" }, allowSetters = true)
    private NtQuoteProjectApproval ntQuoteProjectApproval;

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

	public Set<NtQuoteProjectConsiderations> getProjectConsiderations() {
		return projectConsiderations;
	}

	public void setProjectConsiderations(Set<NtQuoteProjectConsiderations> projectConsiderations) {
		this.projectConsiderations = projectConsiderations;
	}

	public Set<NtQuoteContractReviewInformation> getContractReviewInformations() {
		return contractReviewInformations;
	}

	public void setContractReviewInformations(Set<NtQuoteContractReviewInformation> contractReviewInformations) {
		this.contractReviewInformations = contractReviewInformations;
	}

	public Set<NtQuoteCustomerInputOutputVersion> getCustomerInputOutputVersions() {
		return customerInputOutputVersions;
	}

	public void setCustomerInputOutputVersions(Set<NtQuoteCustomerInputOutputVersion> customerInputOutputVersions) {
		this.customerInputOutputVersions = customerInputOutputVersions;
	}

	public Set<NtQuotePartInformation> getPartInformationMasters() {
		return partInformationMasters;
	}

	public void setPartInformationMasters(Set<NtQuotePartInformation> partInformationMasters) {
		this.partInformationMasters = partInformationMasters;
	}

	public Set<NtQuoteComments> getComments() {
		return comments;
	}

	public void setComments(Set<NtQuoteComments> comments) {
		this.comments = comments;
	}

	public Set<NtQuoteTermsConditions> getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(Set<NtQuoteTermsConditions> termsConditions) {
		this.termsConditions = termsConditions;
	}

	public Set<NtProjectApproval> getProjectApprovals() {
		return projectApprovals;
	}

	public void setProjectApprovals(Set<NtProjectApproval> projectApprovals) {
		this.projectApprovals = projectApprovals;
	}

	public Set<NtQuotePartInformationVersion> getPartInformationVersions() {
		return partInformationVersions;
	}

	public void setPartInformationVersions(Set<NtQuotePartInformationVersion> partInformationVersions) {
		this.partInformationVersions = partInformationVersions;
	}

	public Set<NtQuoteCustomerPo> getCustomerPos() {
		return customerPos;
	}

	public void setCustomerPos(Set<NtQuoteCustomerPo> customerPos) {
		this.customerPos = customerPos;
	}

	public Set<NtQuoteVendorQuote> getVendorQuotes() {
		return vendorQuotes;
	}

	public void setVendorQuotes(Set<NtQuoteVendorQuote> vendorQuotes) {
		this.vendorQuotes = vendorQuotes;
	}

	public Set<NtQuoteVendorPo> getVendorPos() {
		return vendorPos;
	}

	public void setVendorPos(Set<NtQuoteVendorPo> vendorPos) {
		this.vendorPos = vendorPos;
	}

	public RfqDetail getRfqDetail() {
		return rfqDetail;
	}

	public void setRfqDetail(RfqDetail rfqDetail) {
		this.rfqDetail = rfqDetail;
	}

	public NtQuoteProjectApproval getNtQuoteProjectApproval() {
		return ntQuoteProjectApproval;
	}

	public void setNtQuoteProjectApproval(NtQuoteProjectApproval ntQuoteProjectApproval) {
		this.ntQuoteProjectApproval = ntQuoteProjectApproval;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NtQuoteList [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", quoteKey=" + quoteKey + ", salesPerson="
				+ salesPerson + ", customerName=" + customerName + ", quoteNumber=" + quoteNumber + ", status=" + status
				+ ", moldNumber=" + moldNumber + ", partNumber=" + partNumber + ", dueDate=" + dueDate + ", moldManual="
				+ moldManual + ", customerPo=" + customerPo + ", vendorQuote=" + vendorQuote + ", vendorPo=" + vendorPo
				+ ", cadFile=" + cadFile + ", quotedPrice=" + quotedPrice + ", deliveryTime=" + deliveryTime
				+ ", quoteDate=" + quoteDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", projectConsiderations="
				+ projectConsiderations + ", contractReviewInformations=" + contractReviewInformations
				+ ", customerInputOutputVersions=" + customerInputOutputVersions + ", partInformationMasters="
				+ partInformationMasters + ", comments=" + comments + ", termsConditions=" + termsConditions
				+ ", projectApprovals=" + projectApprovals + ", partInformationVersions=" + partInformationVersions
				+ ", customerPos=" + customerPos + ", vendorQuotes=" + vendorQuotes + ", vendorPos=" + vendorPos
				+ ", rfqDetail=" + rfqDetail + ", ntQuoteProjectApproval=" + ntQuoteProjectApproval + "]";
	}
    
    
    
    

}
