package edu.icet.service;

import edu.icet.dto.OutdoorArea;

import java.util.List;

public interface OutdoorAreaService {
    List <OutdoorArea> getAll();
    OutdoorArea save(OutdoorArea outdoorArea);
    Boolean delete(Long id);
    Boolean update(OutdoorArea outdoorArea);

}
