package classwork_26;

import java.util.ArrayList;
import java.util.List;

public class CustomServiceMain {

    public static void main(String[] args) {
        List<Customer> customers = new JsonService().generateCustomerData();
        CustomerService customerService = new CustomerService();
        System.out.println("Customers: " + customerService.getAllCustomersWithSpecificCity(customers, "wonderland") );




    }
}

