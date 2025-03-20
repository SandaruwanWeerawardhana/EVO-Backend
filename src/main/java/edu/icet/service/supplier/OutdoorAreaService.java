package edu.icet.service.supplier;

import edu.icet.dto.OutdoorArea;
import edu.icet.entity.OutdoorAreaEntity;

import java.util.List;

public interface OutdoorAreaService {
    List<OutdoorArea> getAll();
    OutdoorArea save(OutdoorArea outdoorArea);
    Boolean delete(Long id);
    Boolean update(OutdoorArea outdoorArea);
}
