package com.mtmm.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.mtmm.entities.Company;
import com.mtmm.entities.Employee;
import com.mtmm.helper.EntityManagerFactoryRegistry;

public class MTMMJpaTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
Company company=null;
Employee employee=null;
Map<String,Employee> employees=null;

		boolean flag=false;
		try
		{
			entityManagerFactory=EntityManagerFactoryRegistry.getEntityManagerFactory();
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			employees=new HashMap<>();
			employee=new Employee();
			
			employee.setCampus("ecospace");
			employee.setDesgination("associate consultant");
			employee.setEmployeeName("janardhan");
			employee.setLocation("bangalore");
			entityManager.persist(employee);
			
			employees.put("Emp1", employee);
			
			
			employee.setCampus("cv raman");
			employee.setDesgination("consultant");
			employee.setEmployeeName("ram kumaar");
			employee.setLocation("chennai");
			entityManager.persist(employee);
			
			employees.put("Emp1", employee);

			employee.setCampus("gachiboli");
			employee.setDesgination("senior consultant");
			employee.setEmployeeName("ganesh");
			employee.setLocation("hyderabad");
			entityManager.persist(employee);
			
			employees.put("Emp1", employee);

			company=new Company();
			company.setCompanyName("oracle");
			company.setCompanyLocation("all over india");
			company.setCompanyType("software and technologies");
			company.setEmployees(employees);
			
			
			
			entityManager.persist(company);
			
			
			flag=true;
			
		}
		finally {
			
			if(transaction!=null)
			{
				if(flag)
				{
					transaction.commit();
				}else
				{
					transaction.rollback();
				}
				entityManager.close();
			}
			EntityManagerFactoryRegistry.closeEntityManagerFactory();
		}
	}
}
