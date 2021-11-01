package controller;

import model.Employee;
import service.EmployeeService;

/**
 * Created by TCHYARICI on 02/23/2020
 */
@SuppressWarnings("ALL")
public class EmployeeController
{
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String getProjectedEmployee(Employee employee)
	{
		final Employee actualEmployee = employeeService.getEmployee(employee);
		return actualEmployee.getFName();
	}

	public boolean saveEmployee(Employee employee) {
		return  employeeService.saveEmployee(employee);
	}
}
