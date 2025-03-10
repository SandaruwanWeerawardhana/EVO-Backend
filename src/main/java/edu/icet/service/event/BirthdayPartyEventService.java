package edu.icet.service.event;

import edu.icet.dto.BirthdayParty;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface BirthdayPartyEventService {
    BirthdayParty get (Integer id);
    BirthdayParty get (String ownerName);
    List<BirthdayParty> getAll ();
    List<BirthdayParty> getAll (Date date);
    //One user can create multiple birthday parties.Though their username get all
    List<BirthdayParty> getAll (String username);
    Boolean save (BirthdayParty birthdayParty);
    Boolean delete (BirthdayParty birthdayParty);
    Boolean delete (Integer id);
    Boolean update (BirthdayParty bdParty);
}
