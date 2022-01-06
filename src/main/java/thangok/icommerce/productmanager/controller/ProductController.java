package thangok.icommerce.productmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import thangok.icommerce.productmanager.dto.ProductDTO;
import thangok.icommerce.productmanager.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public Page<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productCode}")
    public Optional<ProductDTO> getByCode(@PathVariable("productCode") String productCode) {
        return productService.getByCode(productCode);
    }

    @GetMapping("/search/{searchText}")
    public Page<ProductDTO> searchProducts(@PathVariable("searchText") String searchText) {
        return productService.searchProducts(searchText);
    }

    @PostMapping("/")
    public ProductDTO createProduct(@RequestBody final ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
