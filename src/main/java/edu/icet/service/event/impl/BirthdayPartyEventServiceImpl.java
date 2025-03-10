package edu.icet.service.event.impl;

import edu.icet.dto.BirthdayParty;
import edu.icet.service.event.BirthdayPartyEventService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BirthdayPartyEventServiceImpl implements BirthdayPartyEventService {
    @Override
    public BirthdayParty get(Integer id) {
        return null;
    }

    @Override
    public BirthdayParty get(String ownerName) {
        return null;
    }

    @Override
    public List<BirthdayParty> getAll() {
        return List.of();
    }

    @Override
    public List<BirthdayParty> getAll(Date date) {
        return List.of();
    }

    @Override
    public List<BirthdayParty> getAll(String username) {
        return List.of();
    }

    @Override
    public Boolean save(BirthdayParty birthdayParty) {
        return null;
    }

    @Override
    public Boolean delete(BirthdayParty birthdayParty) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Boolean update(BirthdayParty bdParty) {
        return null;
    }
}
