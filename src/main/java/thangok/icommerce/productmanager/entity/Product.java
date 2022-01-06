package thangok.icommerce.productmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "brand_code")
    private String brandCode;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "price")
    private BigDecimal price;

}
