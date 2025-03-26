package edu.icet.service.supplier.impl;


import edu.icet.dto.supplier.BookingSlot;
import edu.icet.dto.supplier.SupplierRequest;
import edu.icet.entity.supplier.SupplierRequestEntity;

import edu.icet.repository.admin.SupplierRequestReporsitory;
import edu.icet.service.supplier.BookingSlotService;
import edu.icet.service.supplier.SupplierRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class SupplierRequestServiceImpl implements SupplierRequestService {

    private final SupplierRequestReporsitory requestReporsitory;
    private final ModelMapper mapper;

    private BookingSlotService bookingSlotService;

    @Override
    public void addSupplierRequest(SupplierRequest supplierRequest) {
        if (requestReporsitory.existsById(supplierRequest.getId()) && !isBookingOverLapped(supplierRequest)) {
            requestReporsitory.save(mapper.map(supplierRequest, SupplierRequestEntity.class));
        }
    }

    private boolean isBookingOverLapped(SupplierRequest supplierRequest) {
        List<BookingSlot> bookingSlots = bookingSlotService.getAll();

        LocalDateTime requestTime = supplierRequest.getDueDateTime();

        for (BookingSlot slot : bookingSlots) {

            LocalDateTime endTime = slot.getEndTime();
            boolean overlapped = !requestTime.isAfter(endTime);

            if (overlapped) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SupplierRequest> getAll() {
        List<SupplierRequest> supplierRequestList = new ArrayList<>();

        List<SupplierRequestEntity> all = requestReporsitory.findAll();

        all.forEach(supplierRequest -> supplierRequestList.add(mapper.map(supplierRequest, SupplierRequest.class)));
        return supplierRequestList;
    }

    @Override
    public SupplierRequest findById(Long id) {
        if (requestReporsitory.existsById(id)) {
            return mapper.map(requestReporsitory.findById(id), SupplierRequest.class);
        }
        throw new IllegalArgumentException("Supplier not found");
    }

    @Override
    public void update(SupplierRequest supplierRequest) {
        if (requestReporsitory.existsById(supplierRequest.getSupplierId())) {
            requestReporsitory.save(mapper.map(supplierRequest, SupplierRequestEntity.class));
        }
        throw new IllegalArgumentException("Updating fail! supplier request does not exist");
    }

    @Override
    public void delete(Long id) {
        if (requestReporsitory.existsById(id)) {
            requestReporsitory.deleteById(id);
        }
        throw new IllegalArgumentException("Supplier does not exist!");
    }
}
