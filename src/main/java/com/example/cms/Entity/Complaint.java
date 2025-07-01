package com.example.cms.Entity;

import com.example.cms.ComplaintStatus;
import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    private String customerName;
    private String issueDescription;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;

    private LocalDateTime raisedOn;
    private LocalDateTime resolvedOn;

    public Duration getDuration() {
        if (raisedOn != null && resolvedOn != null) {
            return Duration.between(raisedOn, resolvedOn);
        }
        return null;
    }

    public Complaint() {
    }

    public Complaint(Long complaintId, String customerName, String issueDescription, ComplaintStatus status, LocalDateTime raisedOn, LocalDateTime resolvedOn) {
        this.complaintId = complaintId;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.status = status;
        this.raisedOn = raisedOn;
        this.resolvedOn = resolvedOn;
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
}
