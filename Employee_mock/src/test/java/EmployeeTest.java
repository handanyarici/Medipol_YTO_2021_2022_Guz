import controller.EmployeeController;
import model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import service.EmployeeService;

public class EmployeeTest {

    @Test
    public void testProjectedEmployee(){
        EmployeeController employeeController = new EmployeeController(new EmployeeService());
        Employee employee = new Employee();
        employee.setFName("handan");
        String actual = employeeController.getProjectedEmployee(employee);
        Assert.assertEquals("handan", actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testProjectedEmployeeWithException(){
        EmployeeService service = new EmployeeService();
        EmployeeController employeeController = new EmployeeController(service);
        Employee employee = new Employee();
        employee.setFName("ayse");
        employeeController.getProjectedEmployee(employee);
    }

    @Test
    public void testMockProjectedEmployee(){
        Employee employee = new Employee();
        employee.setFName("ayse");
        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        Employee mockEmployee = new Employee();
        mockEmployee.setFName("ahmetcan");
        PowerMockito.when(mock.getEmployee(employee)).thenReturn(mockEmployee);
        EmployeeController employeeController = new EmployeeController(mock);
        Assert.assertEquals("ahmetcan", employeeController.getProjectedEmployee(employee) );
    }

    @Test
    public void testSaveEmployee(){
        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        Employee mockEmployee = new Employee();
        mockEmployee.setFName("ahmetcan");
        PowerMockito.when(mock.saveEmployee(mockEmployee)).thenReturn(true);
        EmployeeController employeeController = new EmployeeController(mock);
        Assert.assertTrue(employeeController.saveEmployee(mockEmployee));
    }
}
