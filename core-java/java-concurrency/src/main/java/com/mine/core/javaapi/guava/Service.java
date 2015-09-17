package com.mine.core.javaapi.guava;

import java.util.HashMap;
import java.util.Map;

public class Service {
	private static Map<Integer, Person> map = new HashMap<Integer, Person>();

	static {
		Person person_1 = new Person(Title.Manager, "John Doe", new Double(
				120.00), 1);
		Person person_2 = new Person(Title.Supervisor, "John Doe_2",
				new Double(100.00), 2);
		Person person_3 = new Person(Title.Worker, "John Doe_3", new Double(
				80.00), 3);

		map.put(person_1.getId(), person_1);
		map.put(person_2.getId(), person_2);
		map.put(person_3.getId(), person_3);
	}

	public static Person findPerson(Integer id) {
		return map.get(id);
	}

	public static Double calculateSalary(Person person) {
		switch (person.getTitle()) {
		case Manager:
			return person.getBaseSalary() * 2.1;
		case Supervisor:
			return person.getBaseSalary() * 1.5;
		case Worker:
			return person.getBaseSalary() * 1.2;	

		}
		return 0.0;
	}

}
