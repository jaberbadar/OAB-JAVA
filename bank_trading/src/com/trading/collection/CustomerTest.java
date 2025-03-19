package com.trading.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerTest {

	public static void main(String[] args) {
		
		
		
		
        List<Customer> custList = new ArrayList<>();
        custList.add(new Customer(101, "ahmed", "oman"));
        custList.add(new Customer(102, "ali", "oman"));
        custList.add(new Customer(103, "hasan", "usa"));
        custList.add(new Customer(104, "jaber", "ksa"));
        custList.add(new Customer(105, "jon", "oman"));


        Scanner value = new Scanner(System.in);

        
        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Show All");
            System.out.println("5. Exit");

            int choice = value.nextInt();
            
            if (choice == 1) addCustomer(custList, value);
            else if (choice == 2) updateCustomer(custList, value);
            else if (choice == 3) deleteCustomer(custList, value);
            else if (choice == 4) showAll(custList);
            else break;
        }
        value.close();
    }
        
  
	
	 public static void addCustomer(List<Customer> custList, Scanner value) {
	        System.out.print("Enter Customer ID: ");
	        int id = value.nextInt();
	        value.nextLine();  
	        System.out.print("Enter Customer Name: ");
	        String name = value.nextLine();
	        System.out.print("Enter Customer Nationality: ");
	        String nationality = value.nextLine();
	        
	        custList.add(new Customer(id, name, nationality));
	        System.out.println("Customer added successfully.");
	    }
		
    public static void updateCustomer(List<Customer> custList, Scanner value) {
        System.out.print("Enter Customer ID to update: ");
        int id = value.nextInt();
        value.nextLine();
        
        for (Customer c : custList) {
            if (c.getCustId() == id) {
                System.out.print("Enter New Name: ");
                c.setCustNmae(value.nextLine());
                System.out.print("Enter New Nationality: ");
                c.setnationality(value.nextLine());
                System.out.println("Customer updated");
                return;
            }
        }
        System.out.println("Customer not found");
    }
    
    public static void deleteCustomer(List<Customer> custList, Scanner value) {
        System.out.print("Enter Customer ID to delete: ");
        int id = value.nextInt();
        Iterator<Customer> iterator = custList.iterator();
        
        while (iterator.hasNext()) {
            if (iterator.next().getCustId() == id) {
                iterator.remove();
                System.out.println("Customer deleted.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }
    
    
    
    public static void showAll(List<Customer> custList) {
    	for (Customer c : custList) {
            System.out.println(c);
        }
        
    }
	
	
		

	}


