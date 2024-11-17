package classwork_26;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private String name;
    private int age;
    private String address;
    private String city;
    private List<Order> orders;
}

