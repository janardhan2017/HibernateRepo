package com.jana.beans;

public class PriorityEmployee {

	private int employeeNo;
	private String employeeName;
	private String designation;
	private double salary;
	public PriorityEmployee(int employeeNo, String employeeName, String designation, double salary) {
		super();
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "PriorityEmployee [employeeNo=" + employeeNo + ", employeeName=" + employeeName + ", designation="
				+ designation + ", salary=" + salary + "]";
	}
	
}
