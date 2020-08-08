package com.mtmm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_employee")
public class Employee implements Serializable {
	@Id
	@Column(name = "employee_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int employeeNo;
	@Column(name="employee_name")
	protected String employeeName;
	protected String Desgination;
	protected String location;
	protected String campus;
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
	public String getDesgination() {
		return Desgination;
	}
	public void setDesgination(String desgination) {
		Desgination = desgination;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", employeeName=" + employeeName + ", Desgination=" + Desgination
				+ ", location=" + location + ", campus=" + campus + "]";
	}

}
