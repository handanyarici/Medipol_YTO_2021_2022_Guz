package service;

import model.Employee;

/**
 * Created by TCHYARICI on 02/23/2020
 */

public class EmployeeService
{
	public Employee getEmployee(Employee employee) {
		if(employee.getFName().length() > 4) {
			return employee;
		}
		throw new UnsupportedOperationException();
	}

	public boolean saveEmployee(Employee employee) {
		//save to db
		return !(employee.getFName().length() > 4);
	}
}