package thangok.icommerce.productmanager.service;

import org.springframework.data.domain.Page;
import thangok.icommerce.productmanager.dto.ProductDTO;
import thangok.icommerce.productmanager.service.exception.BrandNotFoundException;

import java.util.Optional;

public interface ProductService {

    Page<ProductDTO> getAllProducts();

    Page<ProductDTO> queryProduct(
            String brandCode,
            String categoryCode,
            String colorCode,
            Long priceFrom,
            Long priceTo
    );

    Page<ProductDTO> searchProducts(String searchText);

    Optional<ProductDTO> getByCode(String productCode);

    ProductDTO createProduct(ProductDTO productDTO) throws BrandNotFoundException;

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO deleteProduct(String productCode);

}
