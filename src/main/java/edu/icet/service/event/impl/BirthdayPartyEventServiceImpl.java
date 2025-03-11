package edu.icet.service.event.impl;

import edu.icet.dto.BirthdayParty;
import edu.icet.service.event.BirthdayPartyEventService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BirthdayPartyEventServiceImpl implements BirthdayPartyEventService {
    private final List<BirthdayParty> birthdayParties = new ArrayList<>();
    @Override
    public BirthdayParty get(Integer id) {
        return birthdayParties.stream()
                .filter(party -> party.getBirthdayPartyId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public BirthdayParty get(String ownerName) {

        return birthdayParties.stream()
                .filter(party -> party.getOwnerName().equalsIgnoreCase(ownerName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BirthdayParty> getAll() {

        return birthdayParties;
    }

    @Override
    public List<BirthdayParty> getAll(Date date) {

        {
            return birthdayParties.stream()
                    .filter(party -> party.getBirthday().equals(date))
                    .collect(Collectors.toList());
        }

    }
    @Override
    public List<BirthdayParty> getAll(String username) {
        return birthdayParties.stream()
                .filter(party -> party.getOwnerName().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean add(BirthdayParty birthdayParty) {
        return birthdayParties.add(birthdayParty);
    }

    @Override
    public Boolean delete(BirthdayParty birthdayParty) {

        return birthdayParties.remove(birthdayParty);
    }

    @Override
    public Boolean delete(Integer id) {
        return birthdayParties.removeIf(birthdayParty -> birthdayParty.getBirthdayPartyId().equals(id));
    }

    @Override
    public Boolean update(BirthdayParty bdParty) {
            for (int i = 0; i < birthdayParties.size(); i++) {
                if (birthdayParties.get(i).getBirthdayPartyId().equals(bdParty.getBirthdayPartyId())) {
                    birthdayParties.set(i, bdParty);
                    return true;
                }
            }
            return false;
    }
}
