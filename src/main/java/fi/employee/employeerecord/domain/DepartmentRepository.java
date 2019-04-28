package fi.employee.employeerecord.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
	List<Department> findByName(String name);
//	Optional<Department> findById(String id);
	List<Department> findAll();
	
}

