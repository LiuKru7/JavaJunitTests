package classwork_26;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonService {

   public List<Customer> generateCustomerData() {
       List<Customer> customers = new ArrayList<>();
       var filePath = "src/main/resources/customersList.json";
       ObjectMapper mapper = new ObjectMapper();

       try {
           customers = mapper.readValue(new File(filePath), new TypeReference<>() {
           });
           return customers;
       } catch (IOException e) {
           System.out.println("Nepavyko nuskaityti");
       }
       return  null;
   }
}
