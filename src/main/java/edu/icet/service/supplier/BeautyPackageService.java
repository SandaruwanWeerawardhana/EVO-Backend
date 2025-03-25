package edu.icet.service.supplier;

import edu.icet.dto.supplier.BeautyPackage;

import java.util.List;

public interface BeautyPackageService {

    List<BeautyPackage> getAll();
    BeautyPackage save(BeautyPackage beautyPackage);
    Boolean delete(Long id);
    BeautyPackage update(BeautyPackage beautyPackage);

}
