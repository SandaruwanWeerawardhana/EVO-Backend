package edu.icet.service.impl;

import edu.icet.dto.Photographer;
import edu.icet.service.PhotographerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotographerServiceImpl implements PhotographerService {
    final ModelMapper mapper;
    private final List<Photographer> photographerList = new ArrayList<>();

    @Override
    public List<Photographer> getAll() {
        return new ArrayList<>(photographerList);
    }

    @Override
    public void save(Photographer photographer) {
        Optional<Photographer> existingPhotographer = photographerList.stream()
                .filter(p -> p.getEmail().equals(photographer.getEmail()) || p.getContactNumber().equals(photographer.getContactNumber()))
                .findFirst();

        if (existingPhotographer.isPresent()) {
            throw new IllegalArgumentException("Photographer with this email or contact number already exists.");
        }

        photographer.setId((long) (photographerList.size() + 1));
        photographerList.add(photographer);
    }

    @Override
    public Photographer search(Photographer query) {
        return photographerList.stream()
                .filter(p ->
                        (query.getId() != null && p.getId().equals(query.getId())) ||
                                (query.getName() != null && p.getName().equalsIgnoreCase(query.getName())) ||
                                (query.getEmail() != null && p.getEmail().equalsIgnoreCase(query.getEmail())) ||
                                (query.getContactNumber() != null && p.getContactNumber().equals(query.getContactNumber()))
                )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Photographer not found"));
    }

    @Override
    public void update(Photographer photographer) {
        for (int i = 0; i < photographerList.size(); i++) {
            if (photographerList.get(i).getId().equals(photographer.getId())) {
                photographerList.set(i, photographer);
                return;
            }
        }
        throw new IllegalArgumentException("Photographer not found for update.");
    }

    @Override
    public void delete(Long id) {
        boolean removed = photographerList.removeIf(p -> p.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Photographer not found for deletion.");
        }
    }
}
