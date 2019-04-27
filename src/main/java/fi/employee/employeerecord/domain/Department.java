package fi.employee.employeerecord.domain;

import java.util.List;

//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



//@Document(collection = "Department")
public class Department {
	@Id
	@Field
	private String id;
	@Indexed
	@Field
	private String name;

	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Department [id=%s, name=%s]", id, name);
	}

}
