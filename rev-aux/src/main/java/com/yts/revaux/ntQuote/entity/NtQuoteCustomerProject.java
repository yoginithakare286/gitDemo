package com.yts.revaux.ntQuote.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nt_quote_customer_project")
public class NtQuoteCustomerProject  implements Serializable {

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

    @Column(name = "qsf")
    private String qsf;

    @Column(name = "rev")
    private String rev;

    @Column(name = "date")
    private ZonedDateTime date;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "overall_project_risk_evaluation")
    private String overallProjectRiskEvaluation;

    @Column(name = "assessment_date")
    private ZonedDateTime assessmentDate;

    @Column(name = "re_assessment_date")
    private ZonedDateTime reAssessmentDate;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_information")
    private String projectInformation;

    @Column(name = "project_manager")
    private String projectManager;

    @Column(name = "project_requirement")
    private String projectRequirement;

    @Column(name = "length_of_project")
    private String lengthOfProject;

    @Column(name = "new_mold")
    private String newMold;

    @Column(name = "transfer_mold")
    private String transferMold;

    @Column(name = "contact_review_date")
    private LocalDate contactReviewDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(
        value = {
            "projectConsiderations",
            "contractReviewInformations",
            "customerInputOutputVersions",
            "partInformationMasters",
            "comments",
            "termsConditions",
            "projectApprovals",
            "partInformationVersions",
            "customerPos",
            "vendorQuotes",
            "vendorPos",
            "rfqDetail",
            "ntQuoteProjectApproval",
        },
        allowSetters = true
    )
    private NtQuoteList ntQuote;
    
	public NtQuoteList getNtQuote() {
		return ntQuote;
	}

	public void setNtQuote(NtQuoteList ntQuote) {
		this.ntQuote = ntQuote;
	}

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

	public String getQsf() {
		return qsf;
	}

	public void setQsf(String qsf) {
		this.qsf = qsf;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOverallProjectRiskEvaluation() {
		return overallProjectRiskEvaluation;
	}

	public void setOverallProjectRiskEvaluation(String overallProjectRiskEvaluation) {
		this.overallProjectRiskEvaluation = overallProjectRiskEvaluation;
	}

	public ZonedDateTime getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(ZonedDateTime assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public ZonedDateTime getReAssessmentDate() {
		return reAssessmentDate;
	}

	public void setReAssessmentDate(ZonedDateTime reAssessmentDate) {
		this.reAssessmentDate = reAssessmentDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectInformation() {
		return projectInformation;
	}

	public void setProjectInformation(String projectInformation) {
		this.projectInformation = projectInformation;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getProjectRequirement() {
		return projectRequirement;
	}

	public void setProjectRequirement(String projectRequirement) {
		this.projectRequirement = projectRequirement;
	}

	public String getLengthOfProject() {
		return lengthOfProject;
	}

	public void setLengthOfProject(String lengthOfProject) {
		this.lengthOfProject = lengthOfProject;
	}

	public String getNewMold() {
		return newMold;
	}

	public void setNewMold(String newMold) {
		this.newMold = newMold;
	}

	public String getTransferMold() {
		return transferMold;
	}

	public void setTransferMold(String transferMold) {
		this.transferMold = transferMold;
	}

	public LocalDate getContactReviewDate() {
		return contactReviewDate;
	}

	public void setContactReviewDate(LocalDate contactReviewDate) {
		this.contactReviewDate = contactReviewDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NtQuoteCustomerProject [id=" + id + ", srNo=" + srNo + ", uid=" + uid + ", qsf=" + qsf + ", rev=" + rev
				+ ", date=" + date + ", customerName=" + customerName + ", contactName=" + contactName + ", phone="
				+ phone + ", email=" + email + ", overallProjectRiskEvaluation=" + overallProjectRiskEvaluation
				+ ", assessmentDate=" + assessmentDate + ", reAssessmentDate=" + reAssessmentDate + ", projectName="
				+ projectName + ", projectInformation=" + projectInformation + ", projectManager=" + projectManager
				+ ", projectRequirement=" + projectRequirement + ", lengthOfProject=" + lengthOfProject + ", newMold="
				+ newMold + ", transferMold=" + transferMold + ", contactReviewDate=" + contactReviewDate
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}

    
    
}
