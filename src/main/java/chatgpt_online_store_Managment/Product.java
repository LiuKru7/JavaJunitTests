package chatgpt_online_store_Managment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private ProductCategory category;
    private Double price;
    private Integer stock;
}
