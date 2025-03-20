package edu.icet.repository;

import edu.icet.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity,Long>{
    List<RoomEntity> findByPropertyId(Long propertyId);
    List<RoomEntity> findByBeds(Integer beds);
}
