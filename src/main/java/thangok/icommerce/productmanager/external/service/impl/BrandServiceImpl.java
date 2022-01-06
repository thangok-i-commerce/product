package thangok.icommerce.productmanager.external.service.impl;

import org.springframework.stereotype.Service;
import thangok.icommerce.productmanager.external.dto.BrandDTO;
import thangok.icommerce.productmanager.external.service.BrandService;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public Optional<BrandDTO> getByCode(String brandCode) {
        return Optional.empty();
    }
}
