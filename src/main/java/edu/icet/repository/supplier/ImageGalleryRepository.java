package edu.icet.repository.supplier;

import edu.icet.entity.supplier.ImageGalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageGalleryRepository extends JpaRepository<ImageGalleryEntity,Long> {
    Optional<ImageGalleryEntity> findBySupplierID(Long supplierID);
}
