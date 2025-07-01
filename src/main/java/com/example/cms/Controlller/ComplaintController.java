package com.example.cms.Controlller;

import com.example.cms.ComplaintStatus;
import com.example.cms.Dto.ComplaintReqDto;
import com.example.cms.Entity.Complaint;
import com.example.cms.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/Raisecomplaint")
    public ResponseEntity<ComplaintReqDto> raiseComplaint(@RequestBody Complaint complaint) {
        return ResponseEntity.ok(complaintService.raiseComplaint(complaint));
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<ComplaintReqDto>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ComplaintReqDto> updateStatus(@PathVariable Long id, @RequestParam ComplaintStatus status) {
        return ResponseEntity.ok(complaintService.updateStatus(id, status));
    }

    @GetMapping("/status-count")
    public ResponseEntity<Map<ComplaintStatus, Long>> getStatusCount() {
        return ResponseEntity.ok(complaintService.getStatusCount());
    }
}
