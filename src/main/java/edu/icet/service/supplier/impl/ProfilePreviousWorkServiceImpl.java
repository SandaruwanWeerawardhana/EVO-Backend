package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.ProfilePreviousWork;
import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.supplier.ProfilePreviousWorkEntity;
import edu.icet.repository.supplier.ProfilePreviousWorkRepository;
import edu.icet.service.supplier.ProfilePreviousWorkService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProfilePreviousWorkServiceImpl implements ProfilePreviousWorkService {
    private final ModelMapper mapper;
    private final ProfilePreviousWorkRepository repository;

    @Override
    public List<ProfilePreviousWork> getAll() {
        return repository.findAll()
                .stream()
                .map(profilePreviousWorkEntity -> mapper.map(profilePreviousWorkEntity, ProfilePreviousWork.class))
                .toList();
    }

    @Override
    public ProfilePreviousWork save(ProfilePreviousWork profilePreviousWork) {
        return mapper.map(repository.save(mapper.map(profilePreviousWork, ProfilePreviousWorkEntity.class)), ProfilePreviousWork.class );
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public ProfilePreviousWork search(Long id) {

        ProfilePreviousWorkEntity profilePreviousWorkEntity = repository.findById(id).orElse(null);

        return profilePreviousWorkEntity != null
                ? mapper.map(profilePreviousWorkEntity, ProfilePreviousWork.class)
                : null;
    }


    @Override
    public ProfilePreviousWork update(ProfilePreviousWork profilePreviousWork) {
       if (repository.existsById(profilePreviousWork.getPreviousWorkID())) {
           return mapper.map(
                   repository.save(mapper.map(profilePreviousWork, ProfilePreviousWorkEntity.class)),
                   ProfilePreviousWork.class);
       }

       throw new IllegalArgumentException("Profile Previous Work does not exist!");
    }
}
