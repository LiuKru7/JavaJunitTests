package chatgpt_online_store_Managment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private List<Product> products;
    private Double totalAmount;


    public Order(Integer id, List<Product> products) {
        this.id = id;
        this.products = products;
        this.totalAmount = getTotalAmount();
    }

    public double getTotalAmount (List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

}


