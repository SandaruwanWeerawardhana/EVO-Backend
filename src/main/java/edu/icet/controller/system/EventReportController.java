package edu.icet.controller.system;

import edu.icet.dto.event.EventReport;
import edu.icet.service.event.EventReportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/event_report")
@Slf4j
public class EventReportController {
    final EventReportService eventReportService;

    @PostMapping("/save")
    public ResponseEntity<String> saveEventReport(@Valid @RequestBody EventReport eventReport, HttpServletRequest request){
        if(eventReportService.saveEventReport(eventReport)){
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add EventReport detail: {}",os,eventReport);
            return ResponseEntity.ok("event report saved successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added event report");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEventReport(@PathVariable Long id , @Valid @RequestBody EventReport eventReport, HttpServletRequest request){
        if(eventReportService.updateEventReport(id,eventReport)){
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Update EventReport detail: {}",os,eventReport);
            return ResponseEntity.ok("event report update successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't update event report");
        }
    }

    @GetMapping("/get_event_report/{id}")
    public ResponseEntity<EventReport> getEventReportById(@PathVariable Long id){
        EventReport eventReport = eventReportService.getEventReportById(id);
        if(eventReport != null){
            return new ResponseEntity<>(eventReport, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get_all_event_report")
    public ResponseEntity<List<EventReport>> getAllEventReports(){
        List<EventReport> allEventReports = eventReportService.getAllEventReports();
        if(allEventReports != null){
            return new ResponseEntity<>(allEventReports, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEventReportById(@PathVariable Long id,HttpServletRequest request){
        if(eventReportService.deleteEventReportById(id)){
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | delete EventReport id: {}",os,id);
            return ResponseEntity.ok("event report delete successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("try again!, Can't delete event report");
        }
    }
}
