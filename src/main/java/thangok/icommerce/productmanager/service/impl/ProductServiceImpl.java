package thangok.icommerce.productmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import thangok.icommerce.productmanager.aop.executiontime.LogExecutionTime;
import thangok.icommerce.productmanager.aop.io.LogIO;
import thangok.icommerce.productmanager.dto.ProductDTO;
import thangok.icommerce.productmanager.entity.Product;
import thangok.icommerce.productmanager.repository.ProductRepository;
import thangok.icommerce.productmanager.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            return null;
        }

        List<ProductDTO> result = new ArrayList<>();
        productList.stream().map(x -> new ProductDTO() {{
            setProductCode(x.getProductCode());
            setProductName(x.getProductName());
            setDescription(x.getDescription());
        }}).forEach(result::add);

        return new PageImpl<>(result);
    }

    @Override
    public Page<ProductDTO> searchProducts(String searchText) {
        return null;
    }

    @Override
    public Optional<ProductDTO> getByCode(String productCode) {
        return Optional.empty();
    }

    @LogExecutionTime
    @LogIO
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductCode(productDTO.getProductCode());
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());

        Product result = productRepository.save(product);
        return new ProductDTO() {{
            setProductCode(result.getProductCode());
            setProductName(result.getProductName());
            setDescription(result.getDescription());
        }};
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO deleteProduct(String productCode) {
        return null;
    }
}
