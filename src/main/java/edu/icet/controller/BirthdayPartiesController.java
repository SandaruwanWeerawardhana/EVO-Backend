package edu.icet.controller;

import edu.icet.dto.BirthdayParty;
import edu.icet.service.BirthdayPartyEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/birthday-parties")
@RequiredArgsConstructor
@CrossOrigin
public class BirthdayPartiesController {
    final BirthdayPartyEventService service;
    @PostMapping("/add")
    private void addBirthdayParties (@RequestBody BirthdayParty birthdayParty){
        service.save(birthdayParty);
    }

    @GetMapping("/get-all")
    public List<BirthdayParty> getAllBirthdayParties(){
        return service.getAll();
    }

    @PutMapping("/update")
    public void updateBirthdayParties(@RequestBody BirthdayParty birthdayParty){
        service.update(birthdayParty);
    }

    @GetMapping("/get-all-by-date")
    public List<BirthdayParty> getAllByDate(Date date){
        return service.getAll(date);
    }

    @GetMapping("/get-all-by-username")
    public List<BirthdayParty> getAllByUserName(String username){
        return service.getAll(username);
    }

    @DeleteMapping("/delete")
    public void deleteBirthdayParties(@RequestBody BirthdayParty birthdayParty){
        service.delete(birthdayParty);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBirthdayParties(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/get-id")
    public BirthdayParty getBirthdayPartiesById (@PathVariable Integer id){
        return service.get(id);
    }

    @GetMapping("/get-name")
    public BirthdayParty getBirthdayPartiesByName(@PathVariable String ownerName){
        return service.get(ownerName);
    }

}
