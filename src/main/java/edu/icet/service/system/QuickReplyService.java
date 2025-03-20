package edu.icet.service.system;

import edu.icet.dto.QuickReplies;
import edu.icet.dto.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuickReplyService {

    Boolean save(QuickReplies quickReplies);
    Boolean delete(Long id);
    Boolean update (QuickReplies quickReplies);
    List<QuickReplies> getAll();

}
