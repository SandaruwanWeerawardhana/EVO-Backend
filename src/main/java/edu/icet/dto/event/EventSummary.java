package edu.icet.dto.event;


import edu.icet.dto.customer.Customer;
import edu.icet.dto.supplier.ProfilePackages;
import edu.icet.dto.supplier.SupplierRequest;
import edu.icet.dto.supplier.Venue;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSummary {
    private Long id;
    private Event event;
    private Venue venue;
    private Date eventDate;
    private Time startTime;
    private Time endTime;

    @NotNull(message = "customer cannot be null")
    private Customer customer;

    @NotNull(message = "Head count cannot be null")
    private Integer headCount;

    private List<ProfilePackages> packages;
    private List<SupplierRequest> requests;
    private Double totalPrice;
}
