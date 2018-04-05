import cn.it.ws.cxf.b.Employee;
import cn.it.ws.cxf.b.EmployeeManager;
import cn.it.ws.cxf.b.EmployeeService;

public class _Main2 {
	public static void main(String[] args) {
		EmployeeService em = new EmployeeService();
		EmployeeManager employeeManager = em.getEmployeeManagerPort();
		Employee employee = new Employee();
		employee.setAge(25);
		employeeManager.add(employee);
		System.out.println(employeeManager.query().get(0).getAge());
	}
}
