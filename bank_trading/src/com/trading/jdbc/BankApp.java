package com.trading.jdbc;
import java.util.Scanner;



//You are required to develop a console-based banking application using Java and JDBC.
//The application should allow users to create an account, deposit money, withdraw money, transfer funds, and check their balance.
//The application should store all data in a database table named bank _account.
//Implement Exception handling and input validations as needed.



public class BankApp {

	public static void main(String[] args) {
		
		
	       BankOperations operations = new BankOperations();
	        try (Scanner scanner = new Scanner(System.in)) {
	            while (true) {
	                System.out.println("\nBanking System:");
	                System.out.println("1. Create Account");
	                System.out.println("2. Deposit Money");
	                System.out.println("3. Withdraw Money");
	                System.out.println("4. Check Balance");
	                System.out.println("5. Transfer Funds");
	                System.out.println("6. Exit");
	                System.out.print("Choose an option: ");
	                int choice = scanner.nextInt();

	                switch (choice) {
	                    case 1 -> operations.createAccount(scanner);
	                    case 2 -> operations.depositMoney(scanner);
	                    case 3 -> operations.withdrawMoney(scanner);
	                    case 4 -> operations.checkBalance(scanner);
	                    case 5 -> operations.transferFunds(scanner);
	                    case 6 -> {
	                        System.out.println("Exiting application.");

	                        return;
	                    }
	                    default -> System.out.println("Invalid choice! Try again.");
	                }
	            }
	        }
	    }
	}