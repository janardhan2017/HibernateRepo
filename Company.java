package com.mtmm.entities;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "my_company")
public class Company implements Serializable {
	@Id
	@Column(name = "company_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int companyNo;
	@Column(name = "company_name")
	protected String companyName;
	@Column(name = "company_type")
	protected String companyType;
	@Column(name = "company_location")
	protected String companyLocation;

	@ManyToMany
	@MapKeyColumn(name = "company_serial_no")
	@JoinTable(name = "company_employee", joinColumns = { @JoinColumn(name = "company_no") }, inverseJoinColumns = {
			@JoinColumn(name = "employee_no") })
	protected Map<String, Employee> employees;

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public Map<String, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<String, Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Company [companyNo=" + companyNo + ", companyName=" + companyName + ", companyType=" + companyType
				+ ", companyLocation=" + companyLocation + ", employees=" + employees + "]";
	}

}
