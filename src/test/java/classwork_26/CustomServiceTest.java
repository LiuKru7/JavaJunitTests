package classwork_26;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private List<Customer> createTestData () {
        Order order1 = new Order("Laptop", 1200.50, 1);
        Order order2 = new Order("Headphones", 150.75, 2);
        Order order3 = new Order("Smartphone", 899.99, 1);
        Customer customer1 = new Customer("Alice", 30, "123 Elm Street", "Wonderland", Arrays.asList(order1, order2));
        Customer customer2 = new Customer("Bob", 40, "456 Oak Avenue", "Springfield", Arrays.asList(order3));
        return List.of(customer1,customer2);
    }

    @Test
    void testFindMostExpensiveProduct() {
        List<Customer> customers = createTestData();

        CustomerService customerService = new CustomerService();

        Order mostExpensiveProduct = customerService.getMostExpensiveProduct(customers);

        assertEquals("Laptop", mostExpensiveProduct.getName(), "The most expensive product should be Laptop");
        assertEquals(1200.50, mostExpensiveProduct.getPrice(), "The price of the most expensive product should be 1200.50");
    }

    @Test
    void testQuantityOfAllProducts () {
        List<Customer> customers = createTestData();
        CustomerService customerService = new CustomerService();
        int quantityOfAllProducts = customerService.getQuantityOfAllProducts(customers);

        assertEquals(4,quantityOfAllProducts);
    }
    @Test
    void testAllCustomerWithSpecificCity() {
        List<Customer> customers = createTestData();
        CustomerService customerService = new CustomerService();
        List<Customer> customersWithSpecificCity = customerService.getAllCustomersWithSpecificCity(customers, "Wonderland");
        assertEquals(1, customersWithSpecificCity.size());
        assertEquals("Wonderland", customersWithSpecificCity.get(0).getCity());
        assertEquals("Alice", customersWithSpecificCity.get(0).getName());

    }

    @Test
    void testAllProductsBySpecificAge () {
        List<Customer> customers = createTestData();
        CustomerService customerService = new CustomerService();

        List<Order> productList = customerService.getAllProductsBySpecificAge(customers,35,45);

        assertEquals(1, productList.size() );
        assertEquals("Smartphone", productList.get(0).getName());
    }
    @Test
    void testCustomersListWhoSpecificProduct () {
        List<Customer> customers = createTestData();
        CustomerService customerService = new CustomerService();

        List<Customer> customersWithSpecificProducts = customerService.getCustomersListWhoSpecificProduct(customers, "Smartphone");

        assertEquals(1, customersWithSpecificProducts.size() );
        assertEquals("Bob", customersWithSpecificProducts.get(0).getName());

    }

}





