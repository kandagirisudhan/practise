package org.example.basic.Altimetrik;

import org.example.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManipulation {

    public static void main(String args[]) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        // How many male & Female employee are there in the organization
        Map<String, Long> mapVal = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.counting()));
        System.out.println(mapVal);

        //Print the name of all departments in the organization?
        List<String> emp = employeeList.stream().distinct().map(Employee::getDepartment).collect(Collectors.toList());
        System.out.println(emp);

        // What is the average age of male and female employees?
        Map<String, Double> mapCheck = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(mapCheck);

        // Get the details of highest paid employee in the organization?
        Optional<Employee> maxSal = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(maxSal.get().getName() + ":" + maxSal.get().getSalary());

        // Get the names of all employees who have joined after 2015?
        List<String> join_15 = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());
        System.out.println(join_15);

        //Count the number of employees in each department?
        Map<String, Long> dep_emp_count = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(dep_emp_count);

        dep_emp_count.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "=" + e.getValue());
        });

        //What is the average salary of each department?
        Map<String, Double> avg_dept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avg_dept);

        //Get the details of youngest male employee in the product development department?

        Optional<Employee> val = employeeList.stream().filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development").collect(Collectors.minBy(Comparator.comparingDouble(Employee::getAge)));
        System.out.println(val.get());

        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper =
                employeeList.stream()
                        .filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
                        .min(Comparator.comparingInt(Employee::getAge));

        // Who has the most working experience in the organization?
        Optional<Employee> more_exp = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getYearOfJoining)).findFirst();
        System.out.println(more_exp);

        //How many male and female employees are there in the sales and marketing team?
        Map<String, Long> mapvalues = employeeList.stream().filter(p -> p.getDepartment() == "Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(mapvalues);

        //What is the average salary of male and female employees?
        Map<String, Double> mapGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(mapGender);

        //List down the names of all employees in each department?
        Map<String, List<Employee>> sepmap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        sepmap.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "=" + e.getValue());
        });

        //What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics employeeSalaryStatistics=
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println( employeeSalaryStatistics.getAverage());
        System.out.println( employeeSalaryStatistics.getSum());

        //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean,List<Employee>> empMapPar=employeeList.stream().collect(Collectors.partitioningBy(e->e.getAge()>25));
        empMapPar.entrySet().stream().forEach(e->{
            if(e.getKey()){
                System.out.println("Employees older than 25 years :"+e.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
            }else{
                System.out.println("Employees younger than or equal to 25 years :"+e.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
            }
        });

        // Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Employee> e =employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getAge)));
//        Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));


        System.out.println(e.get().getName());
        System.out.println(e.get().getAge());
        System.out.println(e.get().getDepartment());
        Optional<Employee> sort=employeeList.stream().sorted((e1,e2)->e2.getAge() -e1.getAge()).findFirst();
        //employeeList.stream().sorted(Comparator.comparingDouble(Employee::getAge)).findFirst();
        System.out.println(sort.get());
    }


}
