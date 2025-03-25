package edu.icet.service.event.impl;

import edu.icet.dto.event.GetTogether;
import edu.icet.entity.event.GetTogetherEntity;
import edu.icet.repository.event.GetTogetherRepository;
import edu.icet.service.event.GetTogetherEventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTogetherEventServiceImpl implements GetTogetherEventService {

    final GetTogetherRepository getTogetherRepository;
    final ModelMapper modelMapper;

    @Override
    public boolean add(GetTogether getTogether) {

        GetTogetherEntity entity = getTogetherRepository.save(modelMapper.map(getTogether, GetTogetherEntity.class));
        getTogetherRepository.save(entity);
        return true;

    }

    @Override
    public boolean delete(Integer id) {
        if (id == null) {
            return false;
        }
        getTogetherRepository.deleteById(id);
        return true;
    }

    @Override
    public List<GetTogether> getAll() {
        return getTogetherRepository.findAll().stream().map(getTogether -> modelMapper.map(getTogether,GetTogether.class)).toList();
    }

    @Override
    public boolean update(GetTogether getTogether) {
        getTogetherRepository.save(modelMapper.map(getTogether, GetTogetherEntity.class));
        return true;
    }

    @Override
    public GetTogether get(Integer id) {
        return getTogetherRepository.findById(id).map(getTogether -> modelMapper.map(getTogether, GetTogether.class)).orElse(null);
        }
    }




