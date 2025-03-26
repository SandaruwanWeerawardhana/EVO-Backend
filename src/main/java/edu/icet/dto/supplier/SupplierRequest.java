package edu.icet.dto.supplier;

import edu.icet.dto.customer.Customer;
import edu.icet.dto.supplier.Location;
import edu.icet.util.SupplerRequestStatusType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupplierRequest {
    private Long id;

    @NotNull(message = "Supplier not be empty")
    private Supplier supplier;

    @NotNull(message = "Customer not be empty")
    private Customer customer;

    @NotNull(message = "RequestDate not be empty")
    private LocalDateTime requestDate;

    @NotNull(message = "Approve not be empty")
    private SupplerRequestStatusType requestStatus;

    @NotNull(message = "Location not be empty")
    private Location location;

    @NotNull(message = "DueDate not be empty")
    private LocalDateTime dueDateTime;
}
