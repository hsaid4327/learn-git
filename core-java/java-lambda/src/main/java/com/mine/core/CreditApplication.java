package com.mine.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreditApplication {
	private Person person;
	private Integer creditScore;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	public CreditApplication(Person person, Integer creditScore) {
		super();
		this.person = person;
		this.creditScore = creditScore;
	}

	public static List<CreditApplication> buildCreditApplications(){
		Random rd = new Random();
		List<Person> applicants = Person.createRoster();
		List<CreditApplication> applications = new ArrayList<CreditApplication>();
		for(Person p: applicants){
			CreditApplication cp = new CreditApplication(p, rd.nextInt(8));
			applications.add(cp);
		}
		
		return applications;
	}

	@Override
	public String toString() {
		return "CreditApplication [person=" + person + ", creditScore=" + creditScore + "]";
	}

}
