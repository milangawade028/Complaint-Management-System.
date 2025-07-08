package com.example.cms.Dto;

import com.example.cms.Entity.ComplaintStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ComplaintReqDto {
    private Long complaintId;
    private String customerName;
    private String issueDescription;
    private ComplaintStatus status;
    private LocalDateTime raisedOn;
    private LocalDateTime resolvedOn;
    private long resolutionTime;

    public ComplaintReqDto() {
    }

    public ComplaintReqDto(Long complaintId, String customerName, String issueDescription, ComplaintStatus status, LocalDateTime raisedOn, LocalDateTime resolvedOn, String duration) {
        this.complaintId = complaintId;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.status = status;
        this.raisedOn = raisedOn;
        this.resolvedOn = resolvedOn;
       // this.duration = duration;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public LocalDateTime getRaisedOn() {
        return raisedOn;
    }

    public void setRaisedOn(LocalDateTime raisedOn) {
        this.raisedOn = raisedOn;
    }

    public LocalDateTime getResolvedOn() {
        return resolvedOn;
    }

    public void setResolvedOn(LocalDateTime resolvedOn) {
        this.resolvedOn = resolvedOn;
    }

    public long getResolutionTime() {
        return resolutionTime;
    }

    public void setResolutionTime(long resolutionTime) {
        this.resolutionTime = resolutionTime;
    }
}
