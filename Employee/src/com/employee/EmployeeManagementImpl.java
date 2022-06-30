package com.employee;

import java.util.Optional;
import java.util.Random;

public class EmployeeManagementImpl {
	
     
	public int generateEmpId() {
		Random rm = new Random();
		int empId=rm.nextInt(1000);
		return empId;
	}
	Optional<EmployeePojo> saveEmployee(EmployeePojo employeeObj)
	{
		Optional<EmployeePojo> employeeObj1= Optional.of(employeeObj);
		int empId =generateEmpId();
		employeeObj.setEmpId(empId);
		employeeObj.setStatus('f');
		return employeeObj1;
	}
	
}
