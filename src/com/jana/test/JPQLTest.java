package com.jana.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleToLongFunction;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.jana.beans.PriorityEmployee;
import com.jana.entites.Department;
import com.jana.entites.Employee;
import com.jana.helper.EntityManagerFactoryRegistry;
import com.sun.glass.ui.CommonDialogs.Type;
import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;

import oracle.net.aso.e;

public class JPQLTest {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean flag = false;

		try {
			entityManagerFactory = EntityManagerFactoryRegistry.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

//			showMultipleRecordOfEmployee(entityManager, employee);

			// showMultipleRecordOfDepartment(entityManager, department);
//			showAllEmployeebyRole(entityManager,"Senior COnsultant");
//			showMultipleColumnofEmployeeMultipleRecord(entityManager, 45000.00);
//			showEmployeeswithlessSalaryAsMap(entityManager, 55000.0);
//			showPriorityEmployeeWithLessSalary(entityManager, 100000.00);
//		 showEmployeesofDepartment(entityManager, "COnsultant");
//			showLessSalaryAmongAllEmployees(entityManager);
//			showMaxSalaryAmongEmployees(entityManager);
//			showAvgSalaryAmongAllEmployee(entityManager);
//			showSumOfAllEmployeesSalaries(entityManager);
//			showSumOfAllEmployeesSalariesWithDesignation(entityManager,"COnsultant");
//			showAvgSalaryAmongAllEmployeeWithDesignation(entityManager, "Senior COnsultant");
//			showCountofAllEmployees(entityManager);
//			showCountofAllEmployeeswithDesignation(entityManager, "Associate COnsultant");
//			showEmployeeNameinSortedOrder(entityManager);

			// showEmployeeNameinUpperCase(entityManager);
//			showEmployeeNameinLowerCase(entityManager);
//			showEmployeeNamewithLengthSize(entityManager);
//			showEmployeeNamewithConcat(entityManager);
			/*
			 * showEmployeeNameInDiffererentDesignation(entityManager, Arrays.asList(new
			 * String[] { "COnsultant", "Senior COnsultant" }));
			 */
//			showEmployeeNameWithLikeOperator(entityManager,Arrays.asList(new String[] {"Associate COnsultant","COnsultant"}),"m%a");
//			showEmployeeDetailsBasedOnSubquery(entityManager, "ecospace", "Associate COnsultant");
//			showEmployeeDetailsBasedOnSubquery1(entityManager, "EPIP", "Senior COnsultant");
			showEmployeeSBasedonDepartmentSucessGrowthRate(entityManager,10.00);

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

	/**
	 * multiple records as objects
	 */
	private static void showMultipleRecordOfEmployee(EntityManager entityManager, Employee employee) {
		TypedQuery<Employee> typedQuery = null;
		List<Employee> employees = null;
		typedQuery = entityManager.createQuery("from Employee", Employee.class);
		employees = typedQuery.getResultList();
		System.out.println("employee records:" + employees);
		/*
		 * for (Employee employee2 : employees) {
		 * System.out.println("employee data:"+employees);
		 * 
		 * }
		 */
	}

	private static void showMultipleRecordOfDepartment(EntityManager entityManager, Department department) {
		TypedQuery<Department> typedQuery = null;
		List<Department> departments = null;
		typedQuery = entityManager.createQuery("from Department", Department.class);
		departments = typedQuery.getResultList();
//		System.out.println("department data" + departments);
		for (Department department2 : departments) {
			System.out.println("department details" + department2);
			System.out.println(department2.getDepartmentName());
			System.out.println(department2.getDepartmentNo());
		}
	}

	private static void showAllEmployeebyRole(EntityManager entityManager, String designation)

	{
		TypedQuery<Employee> showAllEmployeebyRoleTypedQuery = null;
		List<Employee> employees = null;
		showAllEmployeebyRoleTypedQuery = entityManager.createQuery("from Employee e where e.designation=?1",
				Employee.class);
		showAllEmployeebyRoleTypedQuery.setParameter(1, designation);
		employees = showAllEmployeebyRoleTypedQuery.getResultList();

		printEmployees(employees);
		/*
		 * for (Employee employee : employees) {
		 * System.out.println("employees with role consultant:"+employee); }
		 */
	}

	/**
	 * multiple columns of multiple records [2 ways either as Object[] or JavaBean]
	 * 
	 * 
	 */
	private static void showMultipleColumnofEmployeeMultipleRecord(EntityManager entityManager, double salary)

	{
		TypedQuery<Object[]> showMultipleColumnofEmployeeRecordTypedQuery = null;
		List<Object[]> showmultipleColumsEmployeeRecords = null;
		showMultipleColumnofEmployeeRecordTypedQuery = entityManager.createQuery(
				"select e.employeeNo,e.employeeName,e.designation from Employee e where e.salary=?1", Object[].class);
		showMultipleColumnofEmployeeRecordTypedQuery.setParameter(1, salary);
		showmultipleColumsEmployeeRecords = showMultipleColumnofEmployeeRecordTypedQuery.getResultList();
		for (Object[] record : showmultipleColumsEmployeeRecords) {
			System.out.println(record[0] + ":" + record[1] + ":" + record[2]);
		}
	}

	private static void showEmployeeswithlessSalaryAsMap(EntityManager entityManager, double salary) {
		TypedQuery<Map> showEmployeesWithLessSalary = null;
		List<Map> records = null;
		showEmployeesWithLessSalary = entityManager.createQuery(
				"select e.employeeNo,e.employeeName,e.salary,e.city,e.location,e.role,e.designation,e.ExpInMonthsandYears,e.company from Employee e where e.salary=?1",
				Map.class);

		showEmployeesWithLessSalary.setParameter(1, salary);
		records = showEmployeesWithLessSalary.getResultList();
		for (Map map : records) {
			System.out.println(map.get("employeeNo") + "" + map.get("employeename") + "" + map.get("salary") + ""
					+ map.get("city") + "" + map.get("designation") + "" + map.get("role") + ""
					+ map.get("ExpInMonthsandYears") + "" + map.get("company"));
		}
	}

	private static void showAllOperatingbranches(EntityManager entityManager) {
		TypedQuery<String> showAllOperatingbranchesTypedQuery = null;
		List<String> branchNames = null;

	}

	private static void showPriorityEmployeeWithLessSalary(EntityManager entityManager, double lessSalary) {
		TypedQuery<PriorityEmployee> showPriorityEmployeesWithSalary = null;
		List<PriorityEmployee> priorityEmployees = null;
		showPriorityEmployeesWithSalary = entityManager.createQuery(
				"select new com.jana.beans.PriorityEmployee(e.employeeNo,e.employeeName,e.designation,e.salary)from Employee e where e.salary>=?1",
				PriorityEmployee.class);

		showPriorityEmployeesWithSalary.setParameter(1, lessSalary);
		priorityEmployees = showPriorityEmployeesWithSalary.getResultList();
		for (PriorityEmployee priorityEmployee : priorityEmployees) {
			System.out.println(priorityEmployee);
		}
	}

	private static void showLessSalaryAmongAllEmployees(EntityManager entityManager) {
		TypedQuery<Double> minsalaryTypedQuery = null;
		double minSalary;
		minsalaryTypedQuery = entityManager.createQuery("select min(e.salary) from Employee e", Double.class);
		minSalary = minsalaryTypedQuery.getSingleResult();

		System.out.println("less among all the employee:" + minSalary);

	}

	private static void showMaxSalaryAmongEmployees(EntityManager entityManager) {
		TypedQuery<Double> showMaxSalaryTypedQuery = null;
		double maxSalary;
		showMaxSalaryTypedQuery = entityManager.createQuery("select max(e.salary) from Employee e", Double.class);
		maxSalary = showMaxSalaryTypedQuery.getSingleResult();
		System.out.println("maxmium among all the employee:" + maxSalary);
	}

	private static void showAvgSalaryAmongAllEmployee(EntityManager entityManager) {
		TypedQuery<Double> avgSalarytypedQuery = null;
		double avgSalary;
		avgSalarytypedQuery = entityManager.createQuery("select avg(e.salary) from Employee e", Double.class);
		avgSalary = avgSalarytypedQuery.getSingleResult();
		System.out.println(avgSalary);
	}

	private static void showAvgSalaryAmongAllEmployeeWithDesignation(EntityManager entityManager, String designation) {
		TypedQuery<Double> avgSalaryWithDesignationtypedQuery = null;
		double avgSalaryWithDesignation;
		avgSalaryWithDesignationtypedQuery = entityManager
				.createQuery("select avg(e.salary) from Employee e where e.designation=:designation", Double.class);
		avgSalaryWithDesignationtypedQuery.setParameter("designation", designation);

		avgSalaryWithDesignation = avgSalaryWithDesignationtypedQuery.getSingleResult();
		System.out.println(avgSalaryWithDesignation);
	}

	private static void showSumOfAllEmployeesSalaries(EntityManager entityManager) {
		TypedQuery<Double> showsumEmployeessalaryTypedQuery = null;
		double sumsalary;
		showsumEmployeessalaryTypedQuery = entityManager.createQuery("select sum(e.salary) from Employee e",
				Double.class);
		sumsalary = showsumEmployeessalaryTypedQuery.getSingleResult();

		System.out.println("sum of All employee salary" + sumsalary);
	}

	private static void showSumOfAllEmployeesSalariesWithDesignation(EntityManager entityManager, String designation) {
		TypedQuery<Double> showsumEmployeessalaryTypedQuery = null;
		double sumsalaryOfparticularDesignation;
		showsumEmployeessalaryTypedQuery = entityManager
				.createQuery("select sum(e.salary) from Employee e where e.designation=:designation", Double.class);
		showsumEmployeessalaryTypedQuery.setParameter("designation", designation);
		sumsalaryOfparticularDesignation = showsumEmployeessalaryTypedQuery.getSingleResult();

		System.out.println("sum of All employee salary" + sumsalaryOfparticularDesignation);
	}

	private static void showCountofAllEmployees(EntityManager entityManager) {
		TypedQuery<Long> countofEmployeesTypedQuery = null;
		long countofEmployees;
		countofEmployeesTypedQuery = entityManager.createQuery("select count(*) from Employee e", Long.class);
		countofEmployees = countofEmployeesTypedQuery.getSingleResult();
		System.out.println("no :of employees:" + countofEmployees);
	}

	private static void showCountofAllEmployeeswithDesignation(EntityManager entityManager, String designation) {
		TypedQuery<Long> countofEmployeeswithDesignationTypedQuery = null;
		long countofEmployees;
		countofEmployeeswithDesignationTypedQuery = entityManager
				.createQuery("select count(*) from Employee e where e.designation=:designation", Long.class);
		countofEmployeeswithDesignationTypedQuery.setParameter("designation", designation);
		countofEmployees = countofEmployeeswithDesignationTypedQuery.getSingleResult();
		System.out.println("no :of employees:" + countofEmployees);
	}

	private static void showEmployeeNameinSortedOrder(EntityManager entityManager) {
		TypedQuery<String> typedQuery = null;
		List<String> employeeName = null;
		typedQuery = entityManager.createQuery("select distinct e.employeeName from Employee e order by e.employeeName",
				String.class);
		employeeName = typedQuery.getResultList();
		for (String string : employeeName) {
			System.out.println(string);
		}
	}

	private static void showEmployeeNameinUpperCase(EntityManager entityManager) {

		TypedQuery<String> employeeNamewithUpperCaseTypedquery = null;
		List<String> employeeNameInupperCase = null;

		employeeNamewithUpperCaseTypedquery = entityManager.createQuery(
				"select distinct(Upper(e.employeeName)) from Employee e order by e.employeeName", String.class);
		employeeNameInupperCase = employeeNamewithUpperCaseTypedquery.getResultList();
		for (String employeeName : employeeNameInupperCase) {
			System.out.println(employeeName);

		}
	}

	private static void showEmployeeNameinLowerCase(EntityManager entityManager) {
		TypedQuery<String> employeeNameinLowerCasetyppedQuery = null;
		List<String> employeeNameinLowerCase = null;

		employeeNameinLowerCasetyppedQuery = entityManager
				.createQuery("select lower(e.employeeName) from Employee e order by e.employeeName", String.class);
		employeeNameinLowerCase = employeeNameinLowerCasetyppedQuery.getResultList();
		for (String employeeName : employeeNameinLowerCase) {
			System.out.println(employeeName);
		}

	}

	private static void showEmployeeNamewithLengthSize(EntityManager entityManager) {
		TypedQuery<String> typedQuery = null;
		List<String> employeeNamewithLengthSize = null;

		typedQuery = entityManager.createQuery(
				"select e.employeeName from Employee e where length(e.employeeName)<=5 order by e.employeeName",
				String.class);
		employeeNamewithLengthSize = typedQuery.getResultList();
		for (String employeName : employeeNamewithLengthSize) {
			System.out.println(employeName);
		}
	}

	private static void showEmployeeNamewithConcat(EntityManager entityManager) {
		TypedQuery<String> typedQuery = null;
		List<String> employeeNamewithLengthSize = null;

		typedQuery = entityManager.createQuery(
				"select concat('Mr.', e.employeeName) from Employee e where length(e.employeeName)>=5  order by e.employeeName",
				String.class);
		employeeNamewithLengthSize = typedQuery.getResultList();
		for (String employeName : employeeNamewithLengthSize) {
			System.out.println(employeName);
		}
	}

	private static void showEmployeeNameInDiffererentDesignation(EntityManager entityManager,
			List<String> designation) {
		TypedQuery<String> typedQuery = null;
		List<String> employeeName = null;
		typedQuery = entityManager.createQuery(
				"select e.employeeName from Employee e where length(e.employeeName)>=6 and e.designation in(:designation) order by e.employeeName",
				String.class);
		typedQuery.setParameter("designation", designation);
		employeeName = typedQuery.getResultList();
		for (String string : employeeName) {
			System.out.println(string);

		}
	}

	private static void showEmployeeNameWithLikeOperator(EntityManager entityManager, List<String> designation,
			String startsWith) {
		TypedQuery<String> typedQuery = null;
		List<String> employeeNameWithLikeOperator = null;

		typedQuery = entityManager.createQuery(
				"select e.employeeName from Employee e where length(e.employeeName)>=4 and e.designation in(:designation) and e.employeeName like:name",
				String.class);
		typedQuery.setParameter("designation", designation);
		typedQuery.setParameter("name", startsWith);
		employeeNameWithLikeOperator = typedQuery.getResultList();
		for (String employeeName : employeeNameWithLikeOperator) {

			System.out.println(employeeName);
		}

	}

	private static void showEmployeesofDepartment(EntityManager entityManager, String designation) {
		TypedQuery<Department> typedQuery = null;
		List<Department> departments = null;
		typedQuery = entityManager.createQuery(
				"select d from Department d inner join d.employees e where e.designation=:designation",
				Department.class);
		typedQuery.setParameter("designation", designation);
		departments = typedQuery.getResultList();
		for (Department department : departments) {
			System.out.println(department.getDepartmentName());

		}
	}

	private static void showEmployeeDetailsBasedOnSubquery(EntityManager entityManager, String branchName,
			String designation) {
		TypedQuery<Employee> typedQuery = null;
		List<Employee> employees = null;
		typedQuery = entityManager.createQuery(
				"Select oe from Employee oe where oe.salary=(select distinct(max(e.salary)) "
						+ "from Employee e where e.branchName=:branchName and e.designation=:designation) and oe.branchName=:branchName and oe.designation=:designation",
				Employee.class);
		typedQuery.setParameter("designation", designation);
		typedQuery.setParameter("branchName", branchName);
		employees = typedQuery.getResultList();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName());
			System.out.println(employee.getBranchName());
			System.out.println(employee.getSalary());
			System.out.println(employee.getDesignation());
			System.out.println(employee.getLocation());
		}

	}

	private static void showEmployeeDetailsBasedOnSubquery1(EntityManager entityManager, String branchName,
			String designation) {
		TypedQuery<Employee> typedQuery = null;
		List<Employee> employees = null;
		typedQuery = entityManager.createQuery("Select oe from Employee oe where oe.salary in (select max(e.salary) "
				+ "from Employee e where e.branchName=:branchName and e.designation=:designation) and oe.branchName=:branchName and oe.designation=:designation",
				Employee.class);
		typedQuery.setParameter("designation", designation);
		typedQuery.setParameter("branchName", branchName);
		employees = typedQuery.getResultList();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeNo());
			System.out.println(employee.getCity());
			System.out.println(employee.getExpInMonthsandYears());
			System.out.println(employee.getEmployeeName());
			System.out.println(employee.getBranchName());
			System.out.println(employee.getSalary());
			System.out.println(employee.getDesignation());
			System.out.println(employee.getLocation());
			System.out.println(employee.getRole());
			System.out.println(
					"********************************************************************************************");
//			System.out.println(employee);
		}
	}

	private static void showEmployeeSBasedonDepartmentSucessGrowthRate(EntityManager entityManager,
			double successGrowthRate) {

		TypedQuery<Employee> typedQuery=null;
		List<Employee> employees=null;
		typedQuery=entityManager.createQuery("select e from Employee e inner join e.department d where d.successGrowthRate>=:successGrowthRate",Employee.class);
		typedQuery.setParameter("successGrowthRate", successGrowthRate);
		employees=typedQuery.getResultList();
//		printEmployees(employees);
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeNo());
			System.out.println(employee.getCity());
			System.out.println(employee.getExpInMonthsandYears());
			System.out.println(employee.getEmployeeName());
			System.out.println(employee.getBranchName());
			System.out.println(employee.getSalary());
			System.out.println(employee.getDesignation());
			System.out.println(employee.getLocation());
			System.out.println(employee.getRole());
			System.out.println(
					"********************************************************************************************");
		}
	}
	
	private static void showEmployeesofDepartmentName(EntityManager entityManager,String departmentName)
	{
		TypedQuery<Employee> typedQuery=null;
		List<Employee> employeesWIthParticularDepartmentName=null;
		typedQuery=entityManager.createQuery("select e from Employee e where e.department.departmentName:departmentName",Employee.class);
typedQuery.setParameter("departmentName", departmentName);
employeesWIthParticularDepartmentName=typedQuery.getResultList();
	for (Employee employee : employeesWIthParticularDepartmentName) {
		System.out.println(employee.getEmployeeName());
		System.out.println(employee.getDesignation());
	}
	}

	private static void printEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);

		}
	}

	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end
	// end

}