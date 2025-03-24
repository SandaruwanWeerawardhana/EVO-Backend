package edu.icet.service.event.impl;

import edu.icet.dto.BirthdayParty;
import edu.icet.entity.BirthdayPartyEntity;
import edu.icet.repository.BirthdayPartyRepository;
import edu.icet.service.event.BirthdayPartyEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BirthdayPartyEventServiceImpl implements BirthdayPartyEventService {
    private final BirthdayPartyRepository birthdayPartyRepository;
    private final ModelMapper modelMapper;

    @Override
    public BirthdayParty get(Long id) {
        return birthdayPartyRepository.findById(id)
                .map(entity -> modelMapper.map(entity, BirthdayParty.class))
                .orElse(null);
    }

    @Override
    public BirthdayParty get(String ownerName) {
        return birthdayPartyRepository.findAll().stream()
                .filter(entity -> entity.getOwnerName().equalsIgnoreCase(ownerName))
                .findFirst()
                .map(entity -> modelMapper.map(entity, BirthdayParty.class))
                .orElse(null);
    }

    @Override
    public List<BirthdayParty> getAll() {
        List<BirthdayParty> birthdayParties = new ArrayList<>();
        birthdayPartyRepository.findAll().forEach(entity -> birthdayParties.add(modelMapper.map(entity, BirthdayParty.class)));
        return birthdayParties;
    }

    @Override
    public List<BirthdayParty> getAll(Date date) {
        return birthdayPartyRepository.findAll().stream()
                .filter(entity -> entity.getBirthday().equals(date))
                .map(entity -> modelMapper.map(entity, BirthdayParty.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BirthdayParty> getAll(String username) {
        return birthdayPartyRepository.findAll().stream()
                .filter(entity -> entity.getOwnerName().equalsIgnoreCase(username))
                .map(entity -> modelMapper.map(entity, BirthdayParty.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean add(BirthdayParty birthdayParty) {
        if (birthdayParty == null) {
            return false;
        }
        birthdayPartyRepository.save(modelMapper.map(birthdayParty, BirthdayPartyEntity.class));
        return true;
    }

    @Override
    public Boolean delete(BirthdayParty birthdayParty) {
        if (birthdayParty == null || birthdayParty.getBirthdayPartyId() == null) {
            return false;
        }
        birthdayPartyRepository.deleteById(birthdayParty.getBirthdayPartyId());
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        if (id == null) {
            return false;
        }
        birthdayPartyRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean update(BirthdayParty bdParty) {
        if (bdParty == null || bdParty.getBirthdayPartyId() == null) {
            return false;
        }
        BirthdayPartyEntity updatedEntity = birthdayPartyRepository.save(modelMapper.map(bdParty, BirthdayPartyEntity.class));
        return updatedEntity.getBirthdayPartyId().equals(bdParty.getBirthdayPartyId());
    }
}
