package HPA1.maping;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@OneToMany(cascade=CascadeType.ALL/*mappedBy = "EmployeeLabtop"*/) 
	@JoinColumn(name="Employee_ID")
	private Set<Laptop> labtop = new HashSet<Laptop>();
	
	public Employee() {
	}

	public Set<Laptop> getLabtop() {
		return labtop;
	}

	public void setLabtop(Set<Laptop> labtop) {
		this.labtop = labtop;
	}

	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	
	public Employee(String firstName, String lastName, Set<Laptop> labtop) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.labtop = labtop;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		Employee emp = (Employee) obj;
		if(this.firstName == emp.firstName && this.lastName == emp.lastName)
			return true;
		else
			return false;
		
		//return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}*/
}
