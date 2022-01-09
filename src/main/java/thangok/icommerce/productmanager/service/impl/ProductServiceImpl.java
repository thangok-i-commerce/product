package thangok.icommerce.productmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import thangok.icommerce.productmanager.aop.executiontime.LogExecutionTime;
import thangok.icommerce.productmanager.aop.io.LogIO;
import thangok.icommerce.productmanager.dto.ProductDTO;
import thangok.icommerce.productmanager.entity.Product;
import thangok.icommerce.productmanager.external.dto.BrandDTO;
import thangok.icommerce.productmanager.external.service.BrandService;
import thangok.icommerce.productmanager.repository.ProductRepository;
import thangok.icommerce.productmanager.service.ProductService;
import thangok.icommerce.productmanager.service.exception.BrandNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandService brandService;

    @Override
    public Page<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            return Page.empty();
        }

        List<ProductDTO> result = new ArrayList<>();
        productList.stream().map(x -> new ProductDTO() {{
            setId(x.getId());
            setProductName(x.getProductName());
            setDescription(x.getDescription());
            setCategoryCode(x.getCategoryCode());
            setColorCode(x.getColorCode());
            setPrice(x.getPrice());
            setBrandCode(x.getBrandCode());
        }}).forEach(result::add);

        return new PageImpl<>(result);
    }

    @Override
    public Page<ProductDTO> queryProduct(String brandCode, String categoryCode, String colorCode, Long priceFrom, Long priceTo) {
        List<Product> productList = productRepository.query(brandCode, categoryCode, colorCode, priceFrom, priceTo);
        if (productList.isEmpty()) {
            return Page.empty();
        }

        List<ProductDTO> result = new ArrayList<>();
        productList.stream().map(x -> new ProductDTO() {{
            setId(x.getId());
            setProductName(x.getProductName());
            setDescription(x.getDescription());
            setCategoryCode(x.getCategoryCode());
            setColorCode(x.getColorCode());
            setPrice(x.getPrice());
            setBrandCode(x.getBrandCode());
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
    public ProductDTO createProduct(ProductDTO productDTO) throws BrandNotFoundException {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setCategoryCode(productDTO.getCategoryCode());
        product.setColorCode(productDTO.getColorCode());
        product.setPrice(productDTO.getPrice());

        Optional<BrandDTO> brandDTO = brandService.getByCode(productDTO.getBrandCode());
        if (!brandDTO.isPresent()) {
            throw new BrandNotFoundException(productDTO.getBrandCode());
        }
        product.setBrandCode(brandDTO.get().getBrandCode());

        Product result = productRepository.save(product);
        return new ProductDTO() {{
            setId(result.getId());
            setProductName(result.getProductName());
            setDescription(result.getDescription());
            setCategoryCode(result.getCategoryCode());
            setColorCode(result.getColorCode());
            setPrice(result.getPrice());
            setBrandCode(result.getBrandCode());
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
