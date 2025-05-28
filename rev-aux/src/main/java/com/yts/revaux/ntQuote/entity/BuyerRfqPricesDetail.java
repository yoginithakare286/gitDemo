package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "buyer_rfq_prices_detail")
public class BuyerRfqPricesDetail implements Serializable {

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

    @Column(name = "line")
    private String line;

    @NotNull
    @Column(name = "material_id", nullable = false)
    private String materialId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "est_unit_price", precision = 21, scale = 2)
    private BigDecimal estUnitPrice;

    @Column(name = "act_unit_price", precision = 21, scale = 2)
    private BigDecimal actUnitPrice;

    @Column(name = "award_flag")
    private String awardFlag;

    @Column(name = "quote_id")
    private String quoteId;

    @Column(name = "received_date")
    private ZonedDateTime receivedDate;

    @Column(name = "lead_days", precision = 21, scale = 2)
    private BigDecimal leadDays;

    @Column(name = "rank")
    private String rank;

    @Column(name = "split_quantity_flag")
    private Integer splitQuantityFlag;

    @Column(name = "material_description")
    private String materialDescription;

    @Column(name = "last_updated")
    private String lastUpdated;

    @Column(name = "invite_ra_flag")
    private Integer inviteRaFlag;

    @Column(name = "award_acceptances_date")
    private ZonedDateTime awardAcceptancesDate;

    @Column(name = "order_acceptances_date")
    private ZonedDateTime orderAcceptancesDate;

    @Column(name = "order_acceptances_flag")
    private Integer orderAcceptancesFlag;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "material_image")
    private String materialImage;

    @Column(name = "technical_scrutiny_flag")
    private Integer technicalScrutinyFlag;

    @Column(name = "vendor_attributes")
    private String vendorAttributes;

    @Column(name = "margin_factor", precision = 21, scale = 2)
    private BigDecimal marginFactor;

    @Column(name = "fob", precision = 21, scale = 2)
    private BigDecimal fob;

    @Column(name = "shipping_factor", precision = 21, scale = 2)
    private BigDecimal shippingFactor;

    @Column(name = "freight", precision = 21, scale = 2)
    private BigDecimal freight;

    @Column(name = "final_shipment_cost", precision = 21, scale = 2)
    private BigDecimal finalShipmentCost;

    @Column(name = "tariff", precision = 21, scale = 2)
    private BigDecimal tariff;

    @Column(name = "calculated_tariffs_cost", precision = 21, scale = 2)
    private BigDecimal calculatedTariffsCost;

    @Column(name = "total_cumberland_price", precision = 21, scale = 2)
    private BigDecimal totalCumberlandPrice;

    @Column(name = "landed_price", precision = 21, scale = 2)
    private BigDecimal landedPrice;

    @Column(name = "approval_to_gain", precision = 21, scale = 2)
    private BigDecimal approvalToGain;

    @Column(name = "mold_size_mold_weight")
    private String moldSizeMoldWeight;

    @Column(name = "mold_life_expectancy", precision = 21, scale = 2)
    private BigDecimal moldLifeExpectancy;

    @Column(name = "total_cost_comparison", precision = 21, scale = 2)
    private BigDecimal totalCostComparison;

    @Column(name = "length")
    private String length;

    @Column(name = "width")
    private String width;

    @Column(name = "guage")
    private String guage;

    @Column(name = "tolerance")
    private String tolerance;

    @JsonIgnoreProperties(value = { "buyerRfqPricesDetail" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private RfqDetail rfqDetail;

    @JsonIgnoreProperties(value = { "buyerRfqPricesDetail" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private VendorProfile vendor;

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

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getEstUnitPrice() {
		return estUnitPrice;
	}

	public void setEstUnitPrice(BigDecimal estUnitPrice) {
		this.estUnitPrice = estUnitPrice;
	}

	public BigDecimal getActUnitPrice() {
		return actUnitPrice;
	}

	public void setActUnitPrice(BigDecimal actUnitPrice) {
		this.actUnitPrice = actUnitPrice;
	}

	public String getAwardFlag() {
		return awardFlag;
	}

	public void setAwardFlag(String awardFlag) {
		this.awardFlag = awardFlag;
	}

	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	public ZonedDateTime getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(ZonedDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}

	public BigDecimal getLeadDays() {
		return leadDays;
	}

	public void setLeadDays(BigDecimal leadDays) {
		this.leadDays = leadDays;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Integer getSplitQuantityFlag() {
		return splitQuantityFlag;
	}

	public void setSplitQuantityFlag(Integer splitQuantityFlag) {
		this.splitQuantityFlag = splitQuantityFlag;
	}

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getInviteRaFlag() {
		return inviteRaFlag;
	}

	public void setInviteRaFlag(Integer inviteRaFlag) {
		this.inviteRaFlag = inviteRaFlag;
	}

	public ZonedDateTime getAwardAcceptancesDate() {
		return awardAcceptancesDate;
	}

	public void setAwardAcceptancesDate(ZonedDateTime awardAcceptancesDate) {
		this.awardAcceptancesDate = awardAcceptancesDate;
	}

	public ZonedDateTime getOrderAcceptancesDate() {
		return orderAcceptancesDate;
	}

	public void setOrderAcceptancesDate(ZonedDateTime orderAcceptancesDate) {
		this.orderAcceptancesDate = orderAcceptancesDate;
	}

	public Integer getOrderAcceptancesFlag() {
		return orderAcceptancesFlag;
	}

	public void setOrderAcceptancesFlag(Integer orderAcceptancesFlag) {
		this.orderAcceptancesFlag = orderAcceptancesFlag;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialImage() {
		return materialImage;
	}

	public void setMaterialImage(String materialImage) {
		this.materialImage = materialImage;
	}

	public Integer getTechnicalScrutinyFlag() {
		return technicalScrutinyFlag;
	}

	public void setTechnicalScrutinyFlag(Integer technicalScrutinyFlag) {
		this.technicalScrutinyFlag = technicalScrutinyFlag;
	}

	public String getVendorAttributes() {
		return vendorAttributes;
	}

	public void setVendorAttributes(String vendorAttributes) {
		this.vendorAttributes = vendorAttributes;
	}

	public BigDecimal getMarginFactor() {
		return marginFactor;
	}

	public void setMarginFactor(BigDecimal marginFactor) {
		this.marginFactor = marginFactor;
	}

	public BigDecimal getFob() {
		return fob;
	}

	public void setFob(BigDecimal fob) {
		this.fob = fob;
	}

	public BigDecimal getShippingFactor() {
		return shippingFactor;
	}

	public void setShippingFactor(BigDecimal shippingFactor) {
		this.shippingFactor = shippingFactor;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public BigDecimal getFinalShipmentCost() {
		return finalShipmentCost;
	}

	public void setFinalShipmentCost(BigDecimal finalShipmentCost) {
		this.finalShipmentCost = finalShipmentCost;
	}

	public BigDecimal getTariff() {
		return tariff;
	}

	public void setTariff(BigDecimal tariff) {
		this.tariff = tariff;
	}

	public BigDecimal getCalculatedTariffsCost() {
		return calculatedTariffsCost;
	}

	public void setCalculatedTariffsCost(BigDecimal calculatedTariffsCost) {
		this.calculatedTariffsCost = calculatedTariffsCost;
	}

	public BigDecimal getTotalCumberlandPrice() {
		return totalCumberlandPrice;
	}

	public void setTotalCumberlandPrice(BigDecimal totalCumberlandPrice) {
		this.totalCumberlandPrice = totalCumberlandPrice;
	}

	public BigDecimal getLandedPrice() {
		return landedPrice;
	}

	public void setLandedPrice(BigDecimal landedPrice) {
		this.landedPrice = landedPrice;
	}

	public BigDecimal getApprovalToGain() {
		return approvalToGain;
	}

	public void setApprovalToGain(BigDecimal approvalToGain) {
		this.approvalToGain = approvalToGain;
	}

	public String getMoldSizeMoldWeight() {
		return moldSizeMoldWeight;
	}

	public void setMoldSizeMoldWeight(String moldSizeMoldWeight) {
		this.moldSizeMoldWeight = moldSizeMoldWeight;
	}

	public BigDecimal getMoldLifeExpectancy() {
		return moldLifeExpectancy;
	}

	public void setMoldLifeExpectancy(BigDecimal moldLifeExpectancy) {
		this.moldLifeExpectancy = moldLifeExpectancy;
	}

	public BigDecimal getTotalCostComparison() {
		return totalCostComparison;
	}

	public void setTotalCostComparison(BigDecimal totalCostComparison) {
		this.totalCostComparison = totalCostComparison;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getGuage() {
		return guage;
	}

	public void setGuage(String guage) {
		this.guage = guage;
	}

	public String getTolerance() {
		return tolerance;
	}

	public void setTolerance(String tolerance) {
		this.tolerance = tolerance;
	}

	public RfqDetail getRfqDetail() {
		return rfqDetail;
	}

	public void setRfqDetail(RfqDetail rfqDetail) {
		this.rfqDetail = rfqDetail;
	}

	public VendorProfile getVendor() {
		return vendor;
	}

	public void setVendor(VendorProfile vendor) {
		this.vendor = vendor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BuyerRfqPricesDetail [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", line=" + line + ", materialId="
				+ materialId + ", quantity=" + quantity + ", estUnitPrice=" + estUnitPrice + ", actUnitPrice="
				+ actUnitPrice + ", awardFlag=" + awardFlag + ", quoteId=" + quoteId + ", receivedDate=" + receivedDate
				+ ", leadDays=" + leadDays + ", rank=" + rank + ", splitQuantityFlag=" + splitQuantityFlag
				+ ", materialDescription=" + materialDescription + ", lastUpdated=" + lastUpdated + ", inviteRaFlag="
				+ inviteRaFlag + ", awardAcceptancesDate=" + awardAcceptancesDate + ", orderAcceptancesDate="
				+ orderAcceptancesDate + ", orderAcceptancesFlag=" + orderAcceptancesFlag + ", materialName="
				+ materialName + ", materialImage=" + materialImage + ", technicalScrutinyFlag=" + technicalScrutinyFlag
				+ ", vendorAttributes=" + vendorAttributes + ", marginFactor=" + marginFactor + ", fob=" + fob
				+ ", shippingFactor=" + shippingFactor + ", freight=" + freight + ", finalShipmentCost="
				+ finalShipmentCost + ", tariff=" + tariff + ", calculatedTariffsCost=" + calculatedTariffsCost
				+ ", totalCumberlandPrice=" + totalCumberlandPrice + ", landedPrice=" + landedPrice
				+ ", approvalToGain=" + approvalToGain + ", moldSizeMoldWeight=" + moldSizeMoldWeight
				+ ", moldLifeExpectancy=" + moldLifeExpectancy + ", totalCostComparison=" + totalCostComparison
				+ ", length=" + length + ", width=" + width + ", guage=" + guage + ", tolerance=" + tolerance
				+ ", rfqDetail=" + rfqDetail + ", vendor=" + vendor + "]";
	}
    
    
    

}
