package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.SupplierRequest;
import edu.icet.entity.supplier.SupplierRequestEntity;
import edu.icet.repository.admin.SupplierRequestReporsitory;
import edu.icet.service.supplier.SupplierRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class SupplierRequestServiceImpl implements SupplierRequestService {

    private final SupplierRequestReporsitory requestReporsitory;
    private final ModelMapper mapper;

    @Override
    public void addSupplierRequest(SupplierRequest supplierRequest) {
        requestReporsitory.save(mapper.map(supplierRequest, SupplierRequestEntity.class));
    }

    @Override
    public List<SupplierRequest> getAll() {
        List<SupplierRequest> supplierRequestList = new ArrayList<>();

        List<SupplierRequestEntity> all = requestReporsitory.findAll();

        all.forEach(supplierRequest -> {
            supplierRequestList.add(mapper.map(supplierRequest, SupplierRequest.class));
        });

        return supplierRequestList;
    }

    @Override
    public SupplierRequest findById(Long id) {
        return mapper.map(requestReporsitory.findById(id), SupplierRequest.class);
    }

    @Override
    public void update(SupplierRequest supplierRequest) {
        requestReporsitory.save(mapper.map(supplierRequest,SupplierRequestEntity.class));
    }

    @Override
    public void delete(Long id) {
        requestReporsitory.deleteById(id);
    }
}
