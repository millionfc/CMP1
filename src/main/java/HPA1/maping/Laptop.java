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
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String type;
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="Staff_ID") 
	private Employee employee;
	
	public Laptop() {
	}
	
	public Laptop(String brand, String type, Employee employee) {
		this.brand = brand;
		this.type = type;
		this.employee = employee;
	}

	public Laptop(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
		
	
}
