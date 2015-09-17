package com.mine.core.javaapi.guava;

public class Person {
	
	private Title title;
	private String name;
	private Double baseSalary;
	private final int id;
	
	public Person(Title title, String name, Double baseSalary, int id) {
		super();
		this.title = title;
		this.name = name;
		this.baseSalary = baseSalary;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [title=" + title + ", name=" + name + ", baseSalary="
				+ baseSalary + ", id=" + id + "]";
	}

	
	
	
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((baseSalary == null) ? 0 : baseSalary.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		
		if (id != other.id)
			return false;
		
		return true;
	}
	
	

}
