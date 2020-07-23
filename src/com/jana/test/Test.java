package com.jana.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.jana.entites.Department;
import com.jana.entites.Employee;
import com.jana.helper.EntityManagerFactoryRegistry;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;
		Employee employee = null;
		Department department = null;
		Set<Employee> employees = null;

		try {
			entityManagerFactory = EntityManagerFactoryRegistry.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			employees = new HashSet<>();
			
			department = new Department();
			department.setDepartmentName("Database");
			department.setStatus("Active");
			department.setSuccessGrowthRate(55.25);

			employee = new Employee();
			employee.setEmployeeName("mohan");
			employee.setBranchName("einstein");
			employee.setCity("pune");
			employee.setLocation("palace nagar");
			employee.setSalary(50000.00);
			employee.setRole("oracle & plsql developer");
			employee.setExpInMonthsandYears("5years 6months");
			employee.setDesignation("Consultant");
			employee.setCompany("jana techonology and solutions pvt LtD");
			employee.setDepartment(department);
			entityManager.persist(employee);

			employees.add(employee);

			employee = new Employee();
			employee.setEmployeeName("sudheer");
			employee.setBranchName("ecospace");
			employee.setCity("bangalore");
			employee.setLocation("Belandur");
			employee.setSalary(37000.00);
			employee.setRole("mysql Developer & support");
			employee.setExpInMonthsandYears("3 years 5 months");
			employee.setDesignation("Associate Consultant");
			employee.setCompany("jana techonology and solutions pvt LtD");
			employee.setDepartment(department);
			entityManager.persist(employee);

			employees.add(employee);

			employee = new Employee();
			employee.setEmployeeName("ram");
			employee.setBranchName("EPIP");
			employee.setCity("bangalore");
			employee.setLocation("Whitefield");
			employee.setSalary(85500.00);
			employee.setRole("oracel, mysql,mango db Developer & SME");
			employee.setExpInMonthsandYears("7years 2months");
			employee.setDesignation("Senior COnsultant");
			employee.setDepartment(department);
			employee.setCompany("jana techonology and solutions pvt LtD");

			entityManager.persist(employee);

			employees.add(employee);
			employee = new Employee();
			employee.setEmployeeName("richard");
			employee.setBranchName("cv raman");
			employee.setCity("delhi");
			employee.setLocation("nehru");
			employee.setRole("sql & hadoop developer ");
			employee.setExpInMonthsandYears("1year 5 months");
			employee.setCompany("jana techonology and solutions pvt LtD");
			employee.setDesignation("senior software engineer");
			employee.setSalary(24500.00);
			employee.setDepartment(department);
			entityManager.persist(employee);
			
			
			
			employees.add(employee);

			
			
			
			department.setEmployees(employees);

			entityManager.persist(department);

			
			
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();

				} else {
					transaction.rollback();
				}
				entityManager.close();

			}
			EntityManagerFactoryRegistry.closeEntityManagerFactory();
		}
	}

}
