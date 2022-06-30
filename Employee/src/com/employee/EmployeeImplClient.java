package com.employee;

import java.util.Optional;

public class EmployeeImplClient {
	public static void main(String args[]) {
		EmployeeManagementImpl employeeMgmt = new EmployeeManagementImpl();

		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo.setEmpName("Deepali");
		employeePojo.setAge((byte) 21);
		Optional<EmployeePojo> employeePojoObj = employeeMgmt.saveEmployee(employeePojo);
		if(employeePojoObj.isPresent()) {
			System.out.println(employeePojo.getEmpId());
			System.out.println(employeePojo.getEmpName());
			System.out.println(employeePojo.getStatus());
			if(employeePojo.getStatus() == 's') {
				System.out.println("employee Saved successfully");
			}
		}
	}
	
}
