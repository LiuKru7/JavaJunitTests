package chatgpt_employee;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRegister {

    public List<String> getEmployeeWithSpecifiedSalary (List<Employee> employees, double salary) {
        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .map(Employee::getName)
                .toList();
    }

    public Employee getEmployeeWithHighestSalary (List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Map<String, List<Employee>> getGroupEmployeeListByDepartment (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public  List<Employee> getEmployeeListByExperience (List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getYears))
                .toList();
    }

    public DoubleSummaryStatistics getSalaryStatistic (List<Employee> employees){
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
    }

    public List<Employee> getEmployeeWithLeasThanAverageSalaryAndMoraThan10YearsExperience(List<Employee> employees) {
        double averageSalary = getSalaryStatistic(employees).getAverage();
        return employees.stream()
                .filter(e->e.getSalary() < averageSalary)
                .filter(e -> e.getYears() > 10)
                .toList();
    }
}
