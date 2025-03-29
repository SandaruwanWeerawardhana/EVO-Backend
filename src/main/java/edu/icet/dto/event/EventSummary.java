package edu.icet.dto.event;


import edu.icet.dto.customer.Customer;
import edu.icet.dto.supplier.ProfilePackage;
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

    private Venue venue;

    @NotNull(message = "customer cannot be null")
    private Customer customer;

    @NotNull(message = "Head count cannot be null")
    private Integer headCount;

    private List<ProfilePackage> packages;

    private Double totalPrice;
}
