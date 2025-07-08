package com.example.cms.Controlller;

import com.example.cms.Entity.ComplaintStatus;
import com.example.cms.Dto.ComplaintReqDto;
import com.example.cms.Entity.Complaint;
import com.example.cms.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/Raisecomplaint")
    public ResponseEntity<ComplaintReqDto> raiseComplaint(@RequestBody ComplaintReqDto complaintDto) {
        return ResponseEntity.ok(complaintService.raiseComplaint(complaintDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        //return ResponseEntity.ok(complaintService.getAllComplaints());
        return new ResponseEntity<>(complaintService.getAllComplaints(), HttpStatus.FOUND);
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
