package edu.icet.service.event;

import edu.icet.dto.BirthdayParty;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface BirthdayPartyEventService {
    BirthdayParty get(Integer id);
    BirthdayParty get(String ownerName);
    List<BirthdayParty> getAll ();
    List<BirthdayParty> getAll (Date date);
    List<BirthdayParty> getAll (String username);
    Boolean add(BirthdayParty birthdayParty);
    Boolean delete (BirthdayParty birthdayParty);
    Boolean delete (Integer id);
    Boolean update (BirthdayParty bdParty);
}
