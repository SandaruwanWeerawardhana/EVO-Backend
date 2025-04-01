package edu.icet.service.supplier;

import edu.icet.dto.supplier.SupplierRequest;
import java.util.List;

public interface SupplierRequestService {
    SupplierRequest addSupplierRequest(SupplierRequest supplierRequest);
    List<SupplierRequest> getAll();
    SupplierRequest findById(Long id);
    SupplierRequest update(SupplierRequest supplierRequest);
    Boolean delete(Long id);
}
