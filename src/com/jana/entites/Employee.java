package com.jana.entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity

@Table(name="pjr_employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_no")
	private int employeeNo;
	@Column(name="employee_Name")
	private String employeeName;
	@Column(name="branch_name")
	private String branchName;
	private String location;
	private String city;
	private double salary;
	private String role;
	private String designation;
	private String ExpInMonthsandYears;
	private  String company;
	@NotNull
	@ManyToOne
	@JoinColumn(name="department_no",nullable=true)
	private Department department;
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
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getExpInMonthsandYears() {
		return ExpInMonthsandYears;
	}
	public void setExpInMonthsandYears(String expInMonthsandYears) {
		ExpInMonthsandYears = expInMonthsandYears;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", employeeName=" + employeeName + ", branchName=" + branchName
				+ ", location=" + location + ", city=" + city + ", salary=" + salary + ", role=" + role
				+ ", designation=" + designation + ", ExpInMonthsandYears=" + ExpInMonthsandYears + ", company="
				+ company + ", department=" + department + "]";
	}
	
	
	
	

}
