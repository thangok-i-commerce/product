package thangok.icommerce.productmanager.external.service;

import thangok.icommerce.productmanager.external.dto.BrandDTO;

import java.util.Optional;

public interface BrandService {

    Optional<BrandDTO> getByCode(String brandCode);

}
