package com.yts.revaux.ntQuote.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuoteMachineSetup {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private UUID uid;

    @Column(name = "machine_size", nullable = false)
    private String machineSize;

    @Column(name = "machine_rate", nullable = false)
    private Double machineRate;

    @Column(name = "setup_time", nullable = false)
    private Double setupTime;

    @Column(nullable = false)
    private String standard;

    @Column(nullable = false)
    private String metric;

    @Column(name = "platen_size")
    private String platenSize;

    @Column(name = "min_mold_height")
    private Double minMoldHeight;

    @Column(name = "toggel_machine")
    private Double toggelMachine;

    @Column(name = "max_daylight")
    private Double maxDaylight;

    @Column(name = "min_mold_hv")
    private Double minMoldHv;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_delete", nullable = false)
    private Integer isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

	public String getMachineSize() {
		return machineSize;
	}

	public void setMachineSize(String machineSize) {
		this.machineSize = machineSize;
	}

	public Double getMachineRate() {
		return machineRate;
	}

	public void setMachineRate(Double machineRate) {
		this.machineRate = machineRate;
	}

	public Double getSetupTime() {
		return setupTime;
	}

	public void setSetupTime(Double setupTime) {
		this.setupTime = setupTime;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getPlatenSize() {
		return platenSize;
	}

	public void setPlatenSize(String platenSize) {
		this.platenSize = platenSize;
	}

	public Double getMinMoldHeight() {
		return minMoldHeight;
	}

	public void setMinMoldHeight(Double minMoldHeight) {
		this.minMoldHeight = minMoldHeight;
	}

	public Double getToggelMachine() {
		return toggelMachine;
	}

	public void setToggelMachine(Double toggelMachine) {
		this.toggelMachine = toggelMachine;
	}

	public Double getMaxDaylight() {
		return maxDaylight;
	}

	public void setMaxDaylight(Double maxDaylight) {
		this.maxDaylight = maxDaylight;
	}

	public Double getMinMoldHv() {
		return minMoldHv;
	}

	public void setMinMoldHv(Double minMoldHv) {
		this.minMoldHv = minMoldHv;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "QuoteMachineSetup [id=" + id + ", uid=" + uid + ", machineSize=" + machineSize + ", machineRate="
				+ machineRate + ", setupTime=" + setupTime + ", standard=" + standard + ", metric=" + metric
				+ ", platenSize=" + platenSize + ", minMoldHeight=" + minMoldHeight + ", toggelMachine=" + toggelMachine
				+ ", maxDaylight=" + maxDaylight + ", minMoldHv=" + minMoldHv + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", isDelete=" + isDelete + "]";
	}





}
