package thangok.icommerce.productmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thangok.icommerce.productmanager.entity.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByProductCode(String productCode);
}
