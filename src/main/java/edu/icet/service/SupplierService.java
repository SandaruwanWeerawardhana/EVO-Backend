package edu.icet.service;

import java.util.List;

public interface SupplierService {

    void addSupplier(Supplier supplier) ;

    List<Supplier> getAll();

    void deleteSupplier(Integer id);

    void updateSupplier(Supplier supplier);

}
