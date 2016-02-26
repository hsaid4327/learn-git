package com.mine.core.datastructure;

public class Point {
	private Double x;
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	private Double y;
	public static void main(String[] args) {
	  Point first = new Point();
	  Point second = first;
	  second.setX(3.5);
	  
	  System.out.printf("The first.x ------> %.2f%n", first.getX());
	  System.out.printf("The second.x ------> %.2f%n", second.getX());
		
		

	}

}
