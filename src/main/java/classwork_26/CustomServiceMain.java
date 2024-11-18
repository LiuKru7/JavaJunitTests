package classwork_26;

import java.util.List;

public class CustomServiceMain {

    public static void main(String[] args) {

        List<Customer> customers = new JsonService().generateCustomerData();
        CustomerService customerService = new CustomerService();

        System.out.println("Customers: " + customerService.getAllCustomersWithSpecificCity(customers, "wonderland") );
        System.out.println("Most expensive product: " + customerService.getMostExpensiveProduct(customers).getName());
        System.out.println("Quantity of all products: " + customerService.getQuantityOfAllProducts(customers));
        System.out.println("Products: " + customerService.getAllProductsBySpecificAge(customers, 25, 35));
        System.out.println("Customers: " + customerService.getCustomersListWhoSpecificProduct(customers, "Book"));

    }
}

