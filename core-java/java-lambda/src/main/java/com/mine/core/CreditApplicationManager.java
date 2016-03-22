package com.mine.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CreditApplicationManager {

	public static void main(String[] args) {
		List<CreditApplication> applications = CreditApplication.buildCreditApplications();
		//processApplications(applications, c -> c.getPerson().getAge()>18 && c.getCreditScore()>1, c->c.getPerson().getEmailAddress(), email->System.out.println(email));
        List<CreditApplication> result = processApplicationsAndReturn(applications, c -> c.getPerson().getAge()>18 && c.getCreditScore()>1, c-> {return c;});
	    print(result);
	}
    public static <T, R> void processApplications(Iterable<T> applications, Predicate<T> criteria, Function<T, R> processor, Consumer<R> block){
    	for(T t: applications){
    		if(criteria.test(t)){
    			R r = processor.apply(t);
    			block.accept(r);
    		}
    	}
    }
    public static <T, R> List<T> processApplicationsAndReturn(Iterable<T> applications, Predicate<T> criteria, Function<T, T> processor){
    	List<T> successfulApplicants = new ArrayList<T>();;
    	for(T t: applications){
    		if(criteria.test(t)){
    			t = processor.apply(t);
    			successfulApplicants.add(t);
    		}
    	}
    	return successfulApplicants;
    }
    public static <T> void print(List<T> result){
    	for(T t: result){
    		System.out.println(t);
    	}
    }
}
