package chatgpt_employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private String name;
    private String department;
    private Double salary;
    private Integer years;
}
