package edu.icet.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSummary {
    private Integer id;
    @NotNull
    private Integer eventId;
    @NotNull
    private Long venueId;
    @NotNull
    private Integer customerId;
    @NotNull
    private List<Supplier> supplierList;
    @NotNull
    private Double totalPrice;
}
