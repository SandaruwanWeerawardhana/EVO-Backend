package edu.icet.dto.event;


import edu.icet.dto.customer.Customer;
import edu.icet.dto.supplier.ProfilePackages;
import edu.icet.dto.supplier.Venue;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSummary {
    private Long eventSummaryId;

    private Event event;

    @NotNull(message = "venue cannot be null")
    private Venue venue;

    @NotNull(message = "customer cannot be null")
    private Customer customer;

    @NotNull(message = "Head count cannot be null")
    private Integer headCount;

    private List<ProfilePackages> packages;

    private Double totalPrice;
}
