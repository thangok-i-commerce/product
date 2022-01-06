package thangok.icommerce.productmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import thangok.icommerce.productmanager.external.dto.BrandDTO;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductLargeDTO implements Serializable {

    private Long id;

    private String productName;
    private String description;

    private BrandDTO brand;
    private String categoryCode;
    private String colorCode;

    private BigDecimal price;

}
