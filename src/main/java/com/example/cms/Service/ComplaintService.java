package com.example.cms.Service;

import com.example.cms.ComplaintStatus;
import com.example.cms.Dto.ComplaintReqDto;
import com.example.cms.Entity.Complaint;
import com.example.cms.Repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public ComplaintReqDto raiseComplaint(Complaint complaint) {
        complaint.setStatus(ComplaintStatus.OPEN);
        complaint.setRaisedOn(LocalDateTime.now());
        complaint.setResolvedOn(null);
        return toDto(complaintRepository.save(complaint));
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public ComplaintReqDto updateStatus(Long id, ComplaintStatus newStatus) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        ComplaintStatus currentStatus = complaint.getStatus();
        if (currentStatus == ComplaintStatus.RESOLVED) {
            throw new IllegalStateException("Cannot change status of a resolved complaint.");
        }

        if (currentStatus == ComplaintStatus.OPEN || newStatus == ComplaintStatus.IN_PROGRESS) {
            complaint.setStatus(newStatus);
        } else if (currentStatus == ComplaintStatus.IN_PROGRESS || newStatus == ComplaintStatus.RESOLVED) {
            complaint.setStatus(newStatus);
            complaint.setResolvedOn(LocalDateTime.now());
        }else if(newStatus==ComplaintStatus.RESOLVED)
        {
            LocalDateTime resolvedDate=LocalDateTime.now();
            complaint.setResolvedOn(resolvedDate);
            long durationvar= ChronoUnit.DAYS.between(resolvedDate,complaint.getRaisedOn());
            complaint.setResolutionTime(durationvar);
        }
        else {
            throw new IllegalStateException("Invalid status transition.");
        }

        return toDto(complaintRepository.save(complaint));
    }

    public Map<ComplaintStatus, Long> getStatusCount() {
        return complaintRepository.findAll().stream()
                .collect(Collectors.groupingBy(Complaint::getStatus, Collectors.counting()));
    }

    private ComplaintReqDto toDto(Complaint complaint) {
        ComplaintReqDto dto = new ComplaintReqDto();
        dto.setComplaintId(complaint.getComplaintId());
        dto.setCustomerName(complaint.getCustomerName());
        dto.setIssueDescription(complaint.getIssueDescription());
        dto.setStatus(complaint.getStatus());
        dto.setRaisedOn(complaint.getRaisedOn());
        dto.setResolvedOn(complaint.getResolvedOn());
       // Duration duration = complaint.getDuration();
     //   dto.setDuration(duration != null ? formatDuration(duration) : null);
        return dto;
    }

//    private String formatDuration(Duration duration) {
//        long hours = duration.toHours();
//        long minutes = duration.toMinutesPart();
//        long seconds = duration.toSecondsPart();
//        return String.format("%02dh %02dm %02ds", hours, minutes, seconds);
//    }
}



