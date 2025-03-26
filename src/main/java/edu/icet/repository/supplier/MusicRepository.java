package edu.icet.repository.supplier;

import edu.icet.entity.supplier.MusicEntity;
import edu.icet.entity.supplier.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicRepository extends JpaRepository<MusicEntity,Long> {
    List<MusicEntity> findBySupplier(SupplierEntity supplier);
    List<MusicEntity>findByTeamSize(Integer teamSize);
}
