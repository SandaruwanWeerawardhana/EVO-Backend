package edu.icet.dto.supplier;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageGallery {
    private Long id;
    private Long supplierID;
    private List<String> images;
}
