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
    public boolean save(ProfilePreviousWork profilePreviousWork) {
        return repository.save(mapper.map(profilePreviousWork, ProfilePreviousWorkEntity.class)) != null;
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
    public ProfilePreviousWork search(ProfilePreviousWork profilePreviousWork) {
        if (profilePreviousWork != null) {
            if (profilePreviousWork.getPreviousWorkID() != null) {
                return searchByPreviousWorkID(profilePreviousWork.getPreviousWorkID());
            } else {
                return searchBySupplier(profilePreviousWork.getSupplier());
            }
        }
        return null;
    }

    private ProfilePreviousWork searchByPreviousWorkID(Long previousWorkID) {
        ProfilePreviousWorkEntity entity = repository.findByPreviousWorkID(previousWorkID);

        return entity != null ? mapper.map(entity, ProfilePreviousWork.class) : null;
    }

    private ProfilePreviousWork searchBySupplier(Supplier supplier) {
        ProfilePreviousWorkEntity entity = repository.findBySupplier(supplier);

        return entity != null ? mapper.map(entity, ProfilePreviousWork.class) : null;
    }


    @Override
    public boolean update(ProfilePreviousWork profilePreviousWork) {
       if (repository.existsById(profilePreviousWork.getPreviousWorkID())) {
           repository.save(mapper.map(profilePreviousWork, ProfilePreviousWorkEntity.class));
           return true;
       }

       return false;
    }
}
