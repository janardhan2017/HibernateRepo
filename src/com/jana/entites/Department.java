package com.jana.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="pjr_department")
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="department_no")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int departmentNo;
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="success_Growth_rt_percent")
	private double successGrowthRate;
	
	private String status;
	
	@NotNull
	@OneToMany(mappedBy="department",fetch=FetchType.LAZY)
	
	private Set<Employee> employees;


	public int getDepartmentNo() {
		return departmentNo;
	}


	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	

	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

	public double getSuccessGrowthRate() {
		return successGrowthRate;
	}


	public void setSuccessGrowthRate(double successGrowthRate) {
		this.successGrowthRate = successGrowthRate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Department [departmentNo=" + departmentNo + ", departmentName=" + departmentName
				+ ", successGrowthRate=" + successGrowthRate + ", status=" + status + ", employees=" + employees + "]";
	}


	



	
}
