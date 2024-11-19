package chatgpt_online_store_Managment;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private String email;
    private List<Order> orders;


}

