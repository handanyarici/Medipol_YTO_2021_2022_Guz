package controller;

import model.Employee;
import service.EmployeeService;

/**
 * Created by TCHYARICI on 02/23/2020
 */
public class EmployeeController
{
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String getProjectedEmployee()
	{
		final Employee actualEmployee = employeeService.getEmployee();
		return actualEmployee.getfName();
	}

	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}
}
