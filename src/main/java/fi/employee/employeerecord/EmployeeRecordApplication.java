package fi.employee.employeerecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import fi.employee.employeerecord.domain.Department;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;
import fi.employee.employeerecord.domain.Task;
import fi.employee.employeerecord.domain.TaskRepository;
import fi.employee.employeerecord.domain.User;
import fi.employee.employeerecord.domain.UserRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("fi.employee.employeerecord")
public class EmployeeRecordApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeeRecordApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRecordApplication.class, args);
	}
	private	EmployeeRepository emprepo;
	private DepartmentRepository deprepo;
//	private UserRepository usr;
	private TaskRepository taskrepo;


	public EmployeeRecordApplication(EmployeeRepository emprepo, DepartmentRepository deprepo, UserRepository usr, TaskRepository taskrepo) {
		this.emprepo = emprepo;
		this.deprepo = deprepo;
//		this.usr = usr;
		this.taskrepo = taskrepo;
	}
	
	
	@Bean
	public ApplicationRunner demo(EmployeeRepository emprepo, DepartmentRepository deprepo, UserRepository usr, TaskRepository taskrepo) {
		return (args) -> {
			this.emprepo.deleteAll();
			this.deprepo.deleteAll();
			this.taskrepo.deleteAll();

//			deprepo.save(new Department("IT"));
//			deprepo.save(new Department("Law"));
			deprepo.save(new Department("Marketing"));
//			taskrepo.save(new Task("Application","1979","Building app program",3500,"N"));
//			taskrepo.save(new Task("Advocacy","1980","Reviewing legal implications",7000,"Y"));
			taskrepo.save(new Task("Promotion","1980","4 ps of marketing",9000,"N"));
//			emprepo.save(new Employee("Madhan","Bhadari","madan@gadhan.com","45396108","Dhanushmod-9", deprepo.findByName("IT").get(0), taskrepo.findByName("Application").get(0)));
//			emprepo.save(new Employee("Khem","Neupane","khem@gmail.com","4444444","Tammistonkatu-9", deprepo.findByName("Law").get(0), taskrepo.findByName("Advocacy").get(0)));
			emprepo.save(new Employee("Babita","Gartaula","babi@gmail.com","555555","Tammistonkatu-9", deprepo.findByName("Marketing").get(0), taskrepo.findByName("Promotion").get(0)));
			
			//Create users: admin/admin user/user
//			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
//			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
//			usr.save(user1);
//			usr.save(user2);
	
	

		};
	}

}
