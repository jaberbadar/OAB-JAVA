package com.trading.collection;

import java.util.Objects;

public class Employes {
	
	
	
	
	private int empId;
	private String empNmae;
	private String depName;
	private double salary;

	public Employes(int empId,String empNmae, String depName, double salary) {
		this.empId=empId;
		this.empNmae=empNmae;
		this.depName=depName;
		this.salary=salary;
				
	}
	
	
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpNmae() {
		return empNmae;
	}


	public void setEmpNmae(String empNmae) {
		this.empNmae = empNmae;
	}


	public String getDepName() {
		return depName;
	}


	public void setDepName(String depName) {
		this.depName = depName;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	@Override
	public String toString() {
		return "Employes [empId=" + empId + ", empNmae=" + empNmae + ", depName=" + depName + ", salary=" + salary
				+ "]";
	}


	@Override
	public int hashCode() {
		return this.empId;
	}
	



	@Override
	public boolean equals(Object obj) {
		Employes other = (Employes) obj;
		return Objects.equals(depName, other.depName) && empId == other.empId && Objects.equals(empNmae, other.empNmae)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	
	public int compareTo(Employes o) {
		return this.getEmpNmae().compareTo(o.getEmpNmae());
	}


}
