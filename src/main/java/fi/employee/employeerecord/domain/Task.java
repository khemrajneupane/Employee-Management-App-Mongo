package fi.employee.employeerecord.domain;

import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


//@Document(collection = "Task")
public class Task {
	@Id
	@Field
	private String id;
	@Indexed
	@Field
	private String name;
	@Field
	private String startime;
	@Field
	private String description;
	@Field
	private int budget;
	@Field
	private String isActive;

	public Task(String name, String startime, String description, int budget, String isActive) {
		super();
		this.name = name;
		this.startime = startime;
		this.description = description;
		this.budget = budget;
		this.isActive = isActive;
	}

	public Task() {
		super();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return String.format("Task [id=%s, name=%s, startime=%s, description=%s, budget=%s, isActive=%s]", id, name,
				startime, description, budget, isActive);
	}

}
