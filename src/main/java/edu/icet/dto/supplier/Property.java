package edu.icet.dto.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Property {
    private Long propertyId;

    @NotNull
    @NotBlank(message = "Name may not be empty!")
    private String name;

    private Hall hall;

    private Room room;

    private Pool pool;

    private OutdoorArea outdoorArea;

    private List<PropertyImage> images;
}
