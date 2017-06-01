package HPA1.maping;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int flightnumber;
	private String from;
	private String to;
	private Date date;
	
	public Flight() {
	}
	public Flight(int flightnumber, String from, String to, Date date) {
		this.flightnumber = flightnumber;
		this.from = from;
		this.to = to;
		this.date = date;
	}
	
	
	public int getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}
	
	@Column(name = "\"FROM\"")
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	@Column(name = "\"TO\"")
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
		
		
}
