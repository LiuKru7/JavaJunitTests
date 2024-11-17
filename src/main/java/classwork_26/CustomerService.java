package classwork_26;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerService {
    List<Customer> customers = new ArrayList<>();

    public Order getMostExpensiveProduct(List<Customer> customers) {
       return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .max(Comparator.comparingDouble(Order::getPrice))
                .orElse(null);
    }

    public int getQuantityOfAllProducts(List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .mapToInt(Order::getQuantity)
                .sum();
    }

    public List<Customer> getAllCustomersWithSpecificCity (List<Customer> customers, String city) {
        return customers.stream()
                .filter(customer -> customer.getCity().equalsIgnoreCase(city))
                .toList();
    }

     public List<Order> getAllProductsBySpecificAge(List<Customer> customers, int minAge, int maxAge) {

        return customers.stream()
                .filter(customer -> customer.getAge() < maxAge && customer.getAge() > minAge)
                .flatMap(customer -> customer.getOrders().stream())
                .toList();
     }

     public List<Customer> getCustomersListWhoSpecificProduct (List<Customer> customers, String product) {
//        List<Customer> customersWithSpecificProducts = new ArrayList<>();
//         for (Customer customer : customers) {
//             for (Order order : customer.getOrders()) {
//                 if (order.getName().equalsIgnoreCase(product)){
//                     customersWithSpecificProducts.add(customer);
//                 }
//             }
//         }
//
//         return customersWithSpecificProducts;

         return customers.stream()
                 .filter(customer -> customer.getOrders().stream()
                         .anyMatch(order -> order.getName().equalsIgnoreCase(product)))
                 .collect(Collectors.toList());
     }
}
