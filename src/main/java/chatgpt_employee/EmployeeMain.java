package chatgpt_employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John", "IT", 4500.50, 5));
        employees.add(new Employee("Sarah", "HR", 3800.75, 7));
        employees.add(new Employee("Michael", "IT", 5200.00, 10));
        employees.add(new Employee("Emma", "Sales", 3000.00, 3));
        employees.add(new Employee("Anna", "HR", 4000.25, 8));

        EmployeeRegister employeeRegister = new EmployeeRegister();

        System.out.println("Employees earning more than 4000: ");
        System.out.println(employeeRegister.getEmployeeWithSpecifiedSalary(employees, 4000));

        System.out.println("Employee with the highest salary: ");
        System.out.println(employeeRegister.getEmployeeWithHighestSalary(employees).getName() + " (" + employeeRegister.getEmployeeWithHighestSalary(employees).getSalary() + ")");

        System.out.println("Grouped by department: ");
        System.out.println(employeeRegister.getGroupEmployeeListByDepartment(employees));

        System.out.println("Sorted by experience:");
        System.out.println(employeeRegister.getEmployeeListByExperience(employees));

        System.out.println("Salary Statistics: ");
        System.out.println("Average: " + employeeRegister.getSalaryStatistic(employees).getAverage());
        System.out.println("Min: " + employeeRegister.getSalaryStatistic(employees).getAverage());
        System.out.println("Max: " + employeeRegister.getSalaryStatistic(employees).getAverage());

        System.out.println("Employees with >10 years of experience and earning less than the average :");
        System.out.println(employeeRegister.getEmployeeWithLeasThanAverageSalaryAndMoraThan10YearsExperience(employees));

    }
}
