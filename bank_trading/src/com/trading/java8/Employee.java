package com.trading.java8;

public class Employee {
	
	private int empid;
	private String empName;
	private String city;
	private char gender;
	private Depertmant empdep;
	private double salary;

	
	
	
	public Employee(int empid, String empName, String city, char gender, Depertmant empdep, double salary) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.city = city;
		this.gender = gender;
		this.empdep = empdep;
		this.salary =  salary;

	}

	/**
	 * @return the empid
	 */
	public int getEmpid() {
		return empid;
	}
	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	/**
	 * @return the empdep
	 */
	public Depertmant getEmpdep() {
		return empdep;
	}
	/**
	 * @param empdep the empdep to set
	 */
	public void setEmpdep(Depertmant empdep) {
		this.empdep = empdep;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", city=" + city + ", gender=" + gender
				+ ", empdep=" + empdep + "]";
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	


	

}
