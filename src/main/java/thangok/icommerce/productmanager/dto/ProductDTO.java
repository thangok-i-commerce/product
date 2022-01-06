package thangok.icommerce.productmanager.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDTO implements Serializable {

    private String productCode;

    private String productName;
    private String description;

}
