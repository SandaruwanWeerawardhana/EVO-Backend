package edu.icet.service.supplier.impl;

import edu.icet.dto.OutdoorArea;
import edu.icet.service.supplier.OutdoorAreaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OutdoorAreaServiceImpl implements OutdoorAreaService {
    final ModelMapper mapper;
    private final ArrayList<OutdoorArea> outdoorAreas = new ArrayList<>();
    @Override
    public List<OutdoorArea> getAll() {
        return outdoorAreas;
    }

    @Override
    public OutdoorArea save(OutdoorArea outdoorArea) {
        outdoorAreas.add(outdoorArea);
        return outdoorArea;
    }
    @Override
    public Boolean delete(Long id) {
        outdoorAreas.removeIf(outdoorArea -> outdoorArea.getId().equals(id));
        return outdoorAreas.isEmpty();
    }

    @Override
    public Boolean update(OutdoorArea outdoorArea) {
        if (outdoorArea == null || outdoorArea.getId() == null) return null;

        for (OutdoorArea bs : outdoorAreas) {
            if (bs.getId().equals(outdoorArea.getId())) {
                int index = outdoorAreas.indexOf(bs);
                outdoorAreas.set(index, outdoorArea);
                return true;
            }
        }
        return false;
    }}
