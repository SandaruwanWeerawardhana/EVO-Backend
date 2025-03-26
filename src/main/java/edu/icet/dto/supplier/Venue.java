package edu.icet.dto.supplier;

import edu.icet.util.EventType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private Long venueId;
    @NotEmpty(message = "supplier id can not be null")
    @Positive
    private Supplier supplier;
    @NotEmpty(message = "location can not be null")
    private Location location;
    @NotEmpty(message = "venue type can not be null")
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private Long capacity;
}
