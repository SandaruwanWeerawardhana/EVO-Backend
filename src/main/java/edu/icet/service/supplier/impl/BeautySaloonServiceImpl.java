package edu.icet.service.supplier.impl;

import edu.icet.dto.BeautySaloon;
import edu.icet.service.supplier.BeautySaloonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeautySaloonServiceImpl implements BeautySaloonService {

    private final ModelMapper mapper;
    private final List<BeautySaloon> beautySaloons = new ArrayList<>();

    @Override
    public List<BeautySaloon> getAll() {

        return new ArrayList<>(beautySaloons);
    }

    @Override
    public List<BeautySaloon> add(BeautySaloon beautySaloon) {
        beautySaloons.add(beautySaloon);
        return new ArrayList<>(beautySaloons);
    }

    @Override
    public boolean delete(String id) {
        return beautySaloons.removeIf(saloon -> saloon.getId().equals(id));
    }

    @Override
    public boolean update(BeautySaloon beautySaloon) {
        Optional<BeautySaloon> existingSaloon = beautySaloons.stream()
                .filter(saloon -> saloon.getId().equals(beautySaloon.getId()))
                .findFirst();

        existingSaloon.ifPresent(saloon -> {
            beautySaloons.remove(saloon);
            beautySaloons.add(beautySaloon);
        });

        return existingSaloon.isPresent();
    }

    @Override
    public BeautySaloon get(String id) {
        beautySaloons.stream()
                .filter(saloon -> saloon.getId().equals(id))
                .findFirst();
        return null;
    }
}
