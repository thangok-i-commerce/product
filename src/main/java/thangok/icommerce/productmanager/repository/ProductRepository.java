package thangok.icommerce.productmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thangok.icommerce.productmanager.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(" SELECT p " +
            " FROM Product p " +
            " WHERE (:brandCode IS NULL OR p.brandCode = :brandCode) " +
            " AND (:categoryCode IS NULL OR p.categoryCode = :categoryCode) " +
            " AND (:colorCode IS NULL OR p.colorCode = :colorCode) " +
            " AND (:priceFrom IS NULL OR p.price >= :priceFrom) " +
            " AND (:priceTo IS NULL OR p.price <= :priceTo) " +
            " "
    )
    List<Product> query(
            @Param(value = "brandCode") String brandCode,
            @Param(value = "categoryCode") String categoryCode,
            @Param(value = "colorCode") String colorCode,
            @Param(value = "priceFrom") Long priceFrom,
            @Param(value = "priceTo") Long priceTo
    );
}
