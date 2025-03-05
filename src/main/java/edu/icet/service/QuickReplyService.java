package edu.icet.service;

import edu.icet.dto.QuickReplies;
import edu.icet.dto.Supplier;

import java.util.List;

public interface QuickReplyService {

    Boolean save(QuickReplies quickReplies);
    Boolean delete(Long id);
    Boolean update (QuickReplies quickReplies);
    List<QuickReplies> getAll(Supplier supplier);

}
