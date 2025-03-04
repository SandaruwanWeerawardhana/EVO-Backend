package edu.icet.dto;

import edu.icet.util.VenueType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venue {
    @NotNull(message ="Id Can't be null" )
    private Long id;
    @NotEmpty(message = "supplier id can not be null")
    @Positive
    private Long supplierId;
    @NotEmpty(message = "location can not be null")
    private String location;
    @NotEmpty(message = "venue type can not be null")
    private VenueType type;
}
