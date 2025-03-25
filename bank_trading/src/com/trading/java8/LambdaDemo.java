package com.trading.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDemo {
	


	public static void main(String[] args) {
		
//		
//		
//		
//int result = sum(23,45);
//System.out.println(result);
//


		
//		MyFuncInterface obj =(x,y) -> x+y;
//		System.out.println(obj.sum("string1", "string2"));
//
	

	MyFuncInterface obj =(x,y) -> x+y;
	System.out.println(obj.sum(21, 19));
	
	
	Predicate<Integer> val =a -> a%2==0;
	System.out.println(val.test(21));

	 
	 
    List<String> wordList = Arrays.asList("sun", "apple", "sea", "banana", "snake", "cat");
    
    
//    List<String> wordwiths = Arrays.asList();
//    for (String name: wordList) {
//    	if (name.startsWith("S")) {
//    		wordwiths.add(name);
//    	}
//    }
//    
    
    wordList.stream().filter(n->n.startsWith("s")).forEach(x -> System.out.println(x));

    
    
//    Intermediate operation: n number of operations
//    terminal operation: Single terminal operation
//    Apply stream on a collection of numbers and then filter out all the odd numbers
//    then square those filtered odd numbers then sort them and display
    
    
    List<Integer> numbers = Arrays.asList(10, 3, 5, 8, 15, 21, 6, 13, 7);
    
    

    numbers.stream().filter(n -> n % 2 != 0).map(n -> n * n).sorted().forEach(x -> System.out.println(x));
    
    
    

   
//    List<Integer> SORTNUMBERnumbers = numbers.stream() notcomp
    

    List<Depertmant> deptList = new ArrayList<>();
    deptList.add(new Depertmant(1, "Sales"));
    deptList.add(new Depertmant(2, "IT"));
    deptList.add(new Depertmant (3,"Accounts"));
    deptList.add(new Depertmant(4,"Marketing"));
    
    deptList.stream().map(Depertmant :: getDepName).forEach(System.out :: println);
    
    
    
//    1.Group the Employees by city.
//    2. Print the names of all departments in the organization.
//    3. Find the employee with highest salary and display.
//    4. Find employee count in every department and display.
//    5. Print Average age of Male and Female Employees.
    
    List<Employee> empList = new ArrayList<>();
    empList.add(new Employee(1, "Ali", "Oman", 'M', deptList.get(0), 1200));
    empList.add(new Employee(2, "Ahmed", "Oman", 'M', deptList.get(0), 1700));
    empList.add(new Employee(3, "Salim", "Oman", 'M', deptList.get(0), 1300)); 
    empList.add(new Employee(4, "Jaber", "Oman", 'M', deptList.get(2), 1420)); 
    


    // 1. Group the Employees by City
    Map<String, List<Employee>> empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));

    System.out.println("Employees Grouped by City:");
    empByCity.forEach((city, employees) -> { System.out.println(city + " -> " + employees.size() + " employees");
    });

    // 2. Print Names of All Departments
    System.out.println("Departments in the Organization:");
    deptList.stream() .map(Depertmant::getDepName).forEach(System.out::println);

    // 3. Find the Employee with the Highest Salary
    Optional<Employee> highestSalaryEmp = empList.stream().max(Comparator.comparingDouble(Employee::getSalary));

    highestSalaryEmp.ifPresent(emp -> System.out.println("Highest Salary: " + emp.getSalary() + ", Employee: " + emp.getEmpName()));

    // 4. Find Employee Count in Every Department
    
    Map<Object, Long> empCountByDept = empList.stream().collect(Collectors.groupingBy(emp -> emp.getEmpdep().getDepName().toString(), Collectors.counting()));

    System.out.println("Employee Count in Each Department:");
    empCountByDept.forEach((dept, count) -> System.out.println("Department: " + dept + " | Employee Count: " + count));

    // 5. Print Average Salary of Male and Female Employees
    Map<Character, Double> avgSalaryByGender = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

    System.out.println("Average Salary by Gender:");
    avgSalaryByGender.forEach((gender, avgSalary) -> System.out.println("Gender: " + gender + " | Average Salary: " + avgSalary));
}

// Sum function (Fixed Syntax)
//private static int sum(int a, int b) {
//    return a + b;
}
