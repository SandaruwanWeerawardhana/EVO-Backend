package edu.icet.dto.event;


import edu.icet.util.SupplierCategoryType;
import lombok.Data;

@Data
public class EventSupplierResponse {
    private Long supplierId;
    private String businessName;
    private String businessContactNumber;
    private String businessEmail;
    private SupplierCategoryType category;
    private String profileImageUrl;
    private Boolean availability;
}




