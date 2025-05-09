package edu.icet.dto.supplier;

import edu.icet.dto.event.Event;
import edu.icet.util.EventType;
import edu.icet.util.VenueType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venue {
    private Long venueId;

    private Long capacity;

    private Location location;

    @Enumerated(EnumType.STRING)
    private VenueType venueType;

    private List<Property> properties;

    private List<VenueRequest> requests;

}
