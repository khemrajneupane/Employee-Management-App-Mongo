package fi.employee.employeerecord.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.employee.employeerecord.domain.Department;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;
import fi.employee.employeerecord.domain.Task;
import fi.employee.employeerecord.domain.TaskRepository;


@Controller
public class EmployeeController {

@Autowired
private EmployeeRepository employeerepository;
@Autowired
private DepartmentRepository departmentrepository;
@Autowired
private TaskRepository taskrepository;

@RequestMapping(value = {"/", "/login","/home"})
public String login() {	
    return "login";
}

// Add new employee
//@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/add")
public String addEmployee(Model model){
	model.addAttribute("employee", new Employee());
	model.addAttribute("department", new Department());
	model.addAttribute("task", new Task());
	model.addAttribute("department", departmentrepository.findAll());
	model.addAttribute("task", taskrepository.findAll());
    return "addemployee";
}

@RequestMapping(value = "/addep")
public String addDepartment(Model model){
	model.addAttribute("department", new Department());
	//model.addAttribute("department", departmentrepository.findAll());
	//model.addAttribute("employee", employeerepository.findAll());
    return "addep";
}

//adding tasks
@RequestMapping(value = "/addtask")
public String addTask(Model model){
	model.addAttribute("task", new Task());
    return "addtask";
}


@RequestMapping(value ="/employeelist")
	public String employeeStore(Model model) {
	model.addAttribute("employees", employeerepository.findAll());
	model.addAttribute("departments", departmentrepository.findAll());
	model.addAttribute("tasks", taskrepository.findAll());
		return "employeelist";
	}

//Long list
//@RequestMapping(value ="/history")
//public String history(Model model) {
//model.addAttribute("employees", employeerepository.findAll());
//	return "history";
//}

////Creating History
@RequestMapping(value ="/history")
public String historyStore(@PathVariable("id") String id,Model model) {
	model.addAttribute("employee", employeerepository.findById(id));
	model.addAttribute("department", departmentrepository.findAll());
	model.addAttribute("task", taskrepository.findAll());
	return "history";
}
//For Restful Api creation:
//Get all 
@RequestMapping(value="/employees/all", method = RequestMethod.GET)
public @ResponseBody List<Employee> employeeListRest(){
	return (List<Employee>) employeerepository.findAll();
}
//Get all Tasks only
@RequestMapping(value="/tasks", method = RequestMethod.GET)
public @ResponseBody List<Task> tasks(){
	return (List<Task>) taskrepository.findAll();
}
//Get all Departments only
@RequestMapping(value="/department", method = RequestMethod.GET)
public @ResponseBody List<Department> department(){
	return (List<Department>) departmentrepository.findAll();
}
//For Restful Api creation to get employees by ids
@RequestMapping(value="/employee/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Employee> findEmployeeRest(@PathVariable("id") String id){
	return employeerepository.findById(id);
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Employee employee, Department department, Task task){
	employeerepository.save(employee);
	departmentrepository.save(department);
	taskrepository.save(task);
    return "redirect:/employeelist";
}
@RequestMapping(value = "/savedep", method = RequestMethod.POST)
public String save(Department department){
	departmentrepository.save(department);
    return "redirect:/add";//employeelist savetask
}

@RequestMapping(value = "/savetask", method = RequestMethod.POST)
public String save(Task task){
	taskrepository.save(task);
    return "redirect:/add";//employeelist
}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteEmployee(@PathVariable("id") String id, Model model) {
	employeerepository.deleteById(id);
	departmentrepository.deleteById(id);
	taskrepository.deleteById(id);
	
//	model.addAttribute("department", departmentrepository.findAll());
//	model.addAttribute("task", taskrepository.findAll());
    return "redirect:../employeelist";
}
// editing employee

@RequestMapping(value = "/edit/{id}")
public String editEmployee(@PathVariable("id") String id, Model model){
model.addAttribute("employee", employeerepository.findById(id));
model.addAttribute("department", departmentrepository.findAll());
model.addAttribute("task", taskrepository.findAll());
return "editemployee";
}
////updating employee
//
@RequestMapping(value = "/update/{id}")
public String updateEmployee(@PathVariable("id") String id, Model model){
model.addAttribute("employee", employeerepository.findById(id));
//model.addAttribute("department", departmentrepository.findAll());
//model.addAttribute("task", taskrepository.findAll());
return "history";
}

//Search by task name
	@GetMapping(value = "/search")
	public String searchName(@RequestParam(name = "fname") String fname, Model model) {
		model.addAttribute("employees", employeerepository.findByFnameIgnoreCaseContaining(fname));
		return "employeelist";
	}
	//Search by task name
		@GetMapping(value = "/histori")
		public String searchHistory(@RequestParam(name = "fname") String fname, Model model) {
			model.addAttribute("employees", employeerepository.findByFname(fname));
			return "history";
		}

}