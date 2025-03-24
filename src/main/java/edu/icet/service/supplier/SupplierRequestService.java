package edu.icet.service.supplier;

import edu.icet.dto.SupplierRequest;
import java.util.List;

public interface SupplierRequestService {
    void addSupplierRequest(SupplierRequest supplierRequest);
    List<SupplierRequest> getAll();
    SupplierRequest findById(Long id);
    void update(SupplierRequest supplierRequest);
    void delete(Long id);
}
