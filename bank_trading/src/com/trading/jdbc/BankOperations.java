package com.trading.jdbc;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BankOperations {
	
	
	
//	You are required to develop a console-based banking application using Java and JDBC.
//	The application should allow users to create an account, deposit money, withdraw money, transfer funds, and check their balance.
//	The application should store all data in a database table named bank _account.
//	Implement Exception handling and input validations as needed.
	
    private Connection connection;


    public void BankApplication() {
		
		  try {
		Properties props = new Properties();
    	FileInputStream input = new FileInputStream ("db.Properties");
    	props. load (input);

    	String url = props.getProperty("db.url");
    	String username = props.getProperty ("db.user");
    	String password = props.getProperty("db.password");
    	
        Class.forName("org.postgresql.Driver");
        // Connect to the database
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to the database successfully!");
        
        
		  }
		  catch (Exception e) {
	            System.out.println(e);

	        }
        
	}
    public BankOperations() {
    	BankApplication();
    }
    
    
    
    
    
    
    
    
    
    
	public void createAccount(Scanner scanner) {
        System.out.print("Enter Account Name: ");
        String name = scanner.next();
        System.out.print("Enter initial deposit: ");
        double balance = scanner.nextDouble();

        String sql = "INSERT INTO bank_account (name, balance) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, balance);
            pstmt.executeUpdate();
            System.out.println("Account created successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }
	
	
	
	
	
	
	
	
	
	
	

    public void depositMoney(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        String sql = "UPDATE bank_account SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Account not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error depositing money: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    public void withdrawMoney(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        String checkSql = "SELECT balance FROM bank_account WHERE id = ?";
        String updateSql = "UPDATE bank_account SET balance = balance - ? WHERE id = ?";

        try (PreparedStatement checkStmt = connection.prepareStatement(checkSql);
             PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getDouble("balance") >= amount) {
                updateStmt.setDouble(1, amount);
                updateStmt.setInt(2, id);
                updateStmt.executeUpdate();
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient funds or account not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error withdrawing money: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    

    public void checkBalance(Scanner scanner) {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();

        String sql = "SELECT balance,name FROM bank_account WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	 String name = rs.getString("name");     
                 double balance = rs.getDouble("balance"); 
                 System.out.println("Account Name: " + name + ", Current Balance: " + balance);
                
 
            } else {
                System.out.println("Account not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error checking balance: " + e.getMessage());
        }
    }
    
    
    
    public void transferFunds(Scanner scanner) {
        System.out.print("Enter source account ID: ");
        int fromId = scanner.nextInt();
        System.out.print("Enter destination account ID: ");
        int toId = scanner.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        if (fromId == toId) {
            System.out.println("Source and destination accounts cannot be the same!");
            return;
        }

        String checkSql = "SELECT balance FROM bank_account WHERE id = ?";
        String withdrawSql = "UPDATE bank_account SET balance = balance - ? WHERE id = ?";
        String depositSql = "UPDATE bank_account SET balance = balance + ? WHERE id = ?";

        try (PreparedStatement checkStmt = connection.prepareStatement(checkSql);
             PreparedStatement withdrawStmt = connection.prepareStatement(withdrawSql);
             PreparedStatement depositStmt = connection.prepareStatement(depositSql)) {

            checkStmt.setInt(1, fromId);
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next() || rs.getDouble("balance") < amount) {
                System.out.println("Insufficient funds or source account not found!");
                return;
            }

            checkStmt.setInt(1, toId);
            rs = checkStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Destination account not found!");
                return;
            }

            connection.setAutoCommit(false);

            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, fromId);
            withdrawStmt.executeUpdate();

            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, toId);
            depositStmt.executeUpdate();

            connection.commit();
            System.out.println("Transfer successful!");
        } catch (SQLException e) {
            try {
                connection.rollback();
                System.out.println("Transfer failed, rolling back changes.");
            } catch (SQLException rollbackEx) {
                System.out.println("Rollback failed: " + rollbackEx.getMessage());
            }
            System.out.println("Error transferring funds: " + e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error resetting auto-commit: " + e.getMessage());
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
