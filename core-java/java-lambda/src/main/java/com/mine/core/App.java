package com.mine.core;

interface Executable {
	//public void exectue ();
	public int execute(int a);
	
}

interface StringExecutable {
	public String execute(String s);
}

class Runner {
	public void run(Executable e) {
		System.out.println("...... Executing a block of code......");
		e.execute(12);
		
	}
	
	public void run (StringExecutable e) {
		System.out.println("...... Executing a block of code......");
		e.execute("Passed");
	}
}

// Different Syntax for Lambda Expression

/* 
 
 ()->System.out.println("this is a lambda expression")
 
 
 ()->{
System.out.println("this is the first line");
System.out.println("This is the second line");}
*/


/*
()->{
			System.out.println("this is the first line");
			System.out.println("This is the second line");
			return 8;
		               
		});
*
*
*/

/*
 * ()->8 	
 */

/*
 * (int a)->{
			System.out.println("this is the first line");
			System.out.println("This is the second line");
			return a+8;
		               
		}
 */

/*
 * (int a, int b)->{
			System.out.println("this is the first line");
			System.out.println("This is the second line");
			return a+b;
		               
		}
 */

/*
 * (a)->{

			return a+8;
		               
		}
 */


public class App {

	public static void main(String[] args) {
		int b = 20;
		//must not do this b =22;		
		Runner runner = new Runner();
		runner.run(new Executable() {


//			@Override
//			public void exectue() {
//				System.out.println("Hello world");
//				
//				
//			}

			@Override
			public int execute(int a) {
				
				return a+7+b;
			}
			
		});
		
		System.out.println("###########################################");
		
		//runner.run(()->System.out.println("this is a lambda expression"));
		
		runner.run((int a)->{
            System.out.println(a+8);
			return a+8+b;
		               
		});
		
		runner.run((String s)->{
			return "I "+s;
		});

	}

}
