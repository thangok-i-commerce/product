package thangok.icommerce.productmanager.service;

import org.springframework.data.domain.Page;
import thangok.icommerce.productmanager.dto.ProductDTO;

import java.util.Optional;

public interface ProductService {

    Page<ProductDTO> getAllProducts();

    Page<ProductDTO> searchProducts(String searchText);

    Optional<ProductDTO> getByCode(String productCode);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO deleteProduct(String productCode);

}
