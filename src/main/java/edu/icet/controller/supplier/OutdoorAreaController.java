package edu.icet.controller.supplier;

import edu.icet.dto.supplier.OutdoorArea;
import edu.icet.service.supplier.OutdoorAreaService;
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
    public OutdoorArea save(@RequestBody OutdoorArea outdoorArea){
        return outdoorAreaService.save(outdoorArea);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return outdoorAreaService.delete(id);
    }

    @PutMapping("/update-outdoorArea")
    public boolean update(@RequestBody OutdoorArea outdoorArea){
       return outdoorAreaService.update(outdoorArea);
    }

    @GetMapping("/getAll")
    public List<OutdoorArea> getAll() {
        return outdoorAreaService.getAll();
    }
}

