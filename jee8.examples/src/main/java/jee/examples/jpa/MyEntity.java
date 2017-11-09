package jee.examples.jpa;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "MY_ENTITY")
@NamedQuery(name = "selectAll", query = "SELECT m FROM MyEntity m")
@NamedQuery(name = "byName", query = "SELECT m FROM MyEntity m WHERE m.name = :name")
@NamedQuery(name = "byDay", query = "SELECT m FROM MyEntity m WHERE m.day = :day")
public class MyEntity {

	@Id
	private long id;

	private String name;

	private LocalDate day;

	private long sum;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

}
