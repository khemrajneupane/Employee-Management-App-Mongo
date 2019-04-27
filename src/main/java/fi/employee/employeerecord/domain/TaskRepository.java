package fi.employee.employeerecord.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository <Task, String>{
	List<Task> findByName(String name);
	Optional<Task> findById(String id);
	List<Task> findAll();
}
