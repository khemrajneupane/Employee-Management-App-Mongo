package fi.employee.employeerecord.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends MongoRepository <Employee, String>{
	List<Employee> findByFname(String fname);
	Optional<Employee> findById(String id);
	List<Employee> findAll();
	List<Employee> findByFnameIgnoreCaseContaining(String fname);
	//void deleteById(String id);
//	Optional<Employee> findById(Long id);

}
