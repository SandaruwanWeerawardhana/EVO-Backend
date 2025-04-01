package edu.icet.service.event;

import edu.icet.dto.event.BirthdayParty;

import java.util.Date;
import java.util.List;

public interface BirthdayPartyEventService {
    BirthdayParty get(Long id);
    BirthdayParty get(String ownerName);
    List<BirthdayParty> getAll ();
    List<BirthdayParty> getAll (String username);
    Boolean add(BirthdayParty birthdayParty);
    Boolean delete (BirthdayParty birthdayParty);
    Boolean delete (Long id);
    Boolean update (BirthdayParty bdParty);
}
