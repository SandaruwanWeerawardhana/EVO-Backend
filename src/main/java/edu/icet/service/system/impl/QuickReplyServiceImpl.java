package edu.icet.service.system.impl;

import edu.icet.dto.QuickReplies;
import edu.icet.dto.Supplier;
import edu.icet.service.system.QuickReplyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuickReplyServiceImpl implements QuickReplyService {
    @Override
    public Boolean save(QuickReplies quickReplies) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean update(QuickReplies quickReplies) {
        return null;
    }

    @Override
    public List<QuickReplies> getAll(Supplier supplier) {
        return List.of();
    }
}
