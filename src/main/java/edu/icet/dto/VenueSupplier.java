package edu.icet.dto;

import edu.icet.util.VenueType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class VenueSupplier {
        @NotEmpty(message = "supplier id can not be null")
        @Positive
        private Long supplierId;
        @NotEmpty(message = "location can not be null")
        private String location;
        @NotEmpty(message = "venue type can not be null")
        private VenueType type;
}
