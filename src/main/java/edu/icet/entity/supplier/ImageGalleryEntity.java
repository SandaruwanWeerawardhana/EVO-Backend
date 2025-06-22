package edu.icet.entity.supplier;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

@Generated
@Data
@Entity
@Table(name = "imageGallery")
public class ImageGalleryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierID;

    @ElementCollection
    @CollectionTable(name = "gallery_images", joinColumns = @JoinColumn(name = "gallery_id"))
    @Column(name = "image_url", length = 2048)
    private List<String> images = new ArrayList<>();
}
