package com.icici.sharemarket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icici.sharemarket.pojo.EmployeePojo;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeRestController {

	@GetMapping(path = "/getEmployee", produces = "application/json")
	public EmployeePojo getEmployees() {
		EmployeePojo empPojo = new EmployeePojo();
		empPojo.setAge(21);
		empPojo.setEmpName("Deepali");
		return empPojo;

	}
}
