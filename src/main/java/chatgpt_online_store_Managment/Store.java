package chatgpt_online_store_Managment;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Store {
    public List<Customer> createCustomers () {
        Product product1 =( new Product("Laptop", ProductCategory.ELECTRONICS, 1000.00, 5));
        Product product2 =( new Product("Smartphone", ProductCategory.ELECTRONICS, 800.00, 0));
        Product product3 =( new Product("T-Shirt", ProductCategory.FASHION, 20.00, 10));
        Product product4 =( new Product("Blender", ProductCategory.HOME_APPLIANCES, 100.00, 10));
        Product product5 =( new Product("Fiction book", ProductCategory.BOOKS, 15.00, 100));

        Order order1 = new Order(1, List.of(product1,product3));
        Order order2 = new Order(2, List.of(product5));
        Order order3 = new Order(3, List.of(product4, product2));

        Customer john = new Customer("JohnDoe", "johndoe@gmail.com", List.of(order1,order3));
        Customer jane = new Customer("Jane Smith", "janesmith@gmail.com", List.of(order2));

        return List.of(john,jane);
    }

    public List<Product> getOutOfStockProducts (List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream()
                        .flatMap(order -> order.getProducts().stream().
                                filter(product -> product.getStock() == 0)))
                .toList();
    }

    public List<Product> getElectronicsProducts (List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals(ProductCategory.ELECTRONICS))
                .toList();
    }

    public Product getMostExpensiveElectronicsProduct (List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .orElse(null);
    }

    public double getTotalRevenue (List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public List<Order> getJohnDoeOrders (List<Customer> customers) {
        return customers.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase("john doe"))
                .flatMap(customer -> customer.getOrders().stream())
                .toList();
    }
    public Map<ProductCategory, List<Product>> getProductsByCategory (List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public List<Customer> getSortedList(List<Customer> customers) {
        return customers.stream()
                .sorted((c1, c2) -> Double.compare(
                        c1.getOrders().stream().mapToDouble(Order::getTotalAmount).sum(),
                        c2.getOrders().stream().mapToDouble(Order::getTotalAmount).sum()
                ))
                .toList();
    }

    public List<Order> getOrderAbove500 (List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getTotalAmount() > 500)
                .toList();
    }

}
