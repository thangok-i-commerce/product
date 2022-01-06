package thangok.icommerce.productmanager.external.service.impl;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import thangok.icommerce.productmanager.external.dto.BrandDTO;
import thangok.icommerce.productmanager.external.service.BrandService;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public Optional<BrandDTO> getByCode(String brandCode) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<BrandDTO> response = restTemplate
                .exchange(
                        "http://localhost:8081/api/brand/{brandCode}",
                        HttpMethod.GET,
                        entity,
                        BrandDTO.class,
                        brandCode
                );

        BrandDTO brandDTO = response.getBody();

        return Optional.ofNullable(brandDTO);
    }
}
