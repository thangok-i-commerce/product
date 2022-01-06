package thangok.icommerce.productmanager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    private String productCode;

    private String productName;
    private String description;

}
