package edu.icet.controller;

import edu.icet.dto.BirthdayParty;
import edu.icet.service.event.BirthdayPartyEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/birthday-parties")
@RequiredArgsConstructor
@CrossOrigin
public class BirthdayPartiesController {

    private final BirthdayPartyEventService service;
    @PostMapping("/add")
    private boolean add(@RequestBody BirthdayParty birthdayParty) {

        return service.add(birthdayParty);
    }

    @GetMapping("/get-all")
    public List<BirthdayParty> getAll() {
        return service.getAll();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody BirthdayParty birthdayParty) {

        return service.update(birthdayParty);
    }

    @GetMapping("/get-all-by-date")
    public List<BirthdayParty> getAll(Date date) {
        return service.getAll(date);
    }

    @GetMapping("/get-all-by-username")
    public List<BirthdayParty> getAll(String username) {
        return service.getAll(username);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody BirthdayParty birthdayParty) {
        return service.delete(birthdayParty);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping("/get-id/{id}")
    public BirthdayParty get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/get-name/{ownerName}")
    public BirthdayParty get(@PathVariable("ownerName") String ownerName) {
        return service.get(ownerName);
    }

}
