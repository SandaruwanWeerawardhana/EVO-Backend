package edu.icet.service;

import java.util.List;

public interface QuickReplies {

    Boolean save(QuickReplies quickReplies);
    Boolean delete(Long id);
    Boolean update (QuickReplies quickReplies);
    List<QuickReplies> getAll();

}
