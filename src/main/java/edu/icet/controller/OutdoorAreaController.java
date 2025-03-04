package edu.icet.controller;

import edu.icet.dto.OutdoorArea;
import edu.icet.service.OutdoorAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier/venue/outdoorevent")
@RequiredArgsConstructor
@CrossOrigin

public class OutdoorAreaController {
    final OutdoorAreaService outdoorAreaService;

    @PostMapping("/add")
    public void save(@RequestBody OutdoorArea outdoorArea){
        outdoorAreaService.save(outdoorArea);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        outdoorAreaService.delete(id);
    }

    @PutMapping("/update-outdoorArea")
    public void update(@RequestBody OutdoorArea outdoorArea){
        outdoorAreaService.update(outdoorArea);
    }

    @GetMapping("/getAll")
    public List<OutdoorArea> getAll() {
        return outdoorAreaService.getAll();
    }
}

