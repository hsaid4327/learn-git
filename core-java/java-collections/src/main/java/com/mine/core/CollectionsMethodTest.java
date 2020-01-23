package com.mine.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class tests the Collections Methods on Lists and Collections interface
 * 
 * @author hsaid-contractor
 *
 */
public class CollectionsMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		naturalSort();
		reverseNaturalSort();
		orderWithComparator();
		reverseList();
		checkDisjoint();
	}

	/**
	 * This sort is based on the natural order of the elements
	 */
	public static void naturalSort() {

		System.out.println("----Executring natural sort....");
		String[] colors = { "Red", "Blue", "Green", "Yellow", "Magenta" };
		List<String> unsortedList = Arrays.asList(colors);
		Collections.sort(unsortedList);
		System.out.printf("Sorted list: %s%n", unsortedList);

	}

	public static void reverseNaturalSort() {

		System.out.println("----Executring Reverse natural sort....");

		String[] colors = { "Red", "Blue", "Green", "Yellow", "Magenta" };
		List<String> unsortedList = Arrays.asList(colors);
		Collections.sort(unsortedList, Collections.reverseOrder());
		System.out.printf("Reversed Sorted list: %s%n", unsortedList);

	}

	public static void orderWithComparator() {
		List<Time> list = new ArrayList<Time>();
		// list.add(new Time(6, 24, 34));
		list.add(new Time(18, 14, 58));
		list.add(new Time(6, 05, 34));
		list.add(new Time(12, 14, 58));
		list.add(new Time(6, 24, 22));

		// output List elements
		System.out.printf("Unsorted array elements:%n%s%n", list);

		// sort in order using a comparator
		Collections.sort(list, new TimeComparator());

		// output List elements
		System.out.printf("Sorted list elements:%n%s%n", list);

	}

	public static void reverseList() {
		Character[] characterArray = { 'a', 'b', 'c', 'd', 'e' };

		List<Character> characterList = new ArrayList<Character>();
		characterList = Arrays.asList(characterArray);
		Collections.reverse(characterList);
		printList(characterList);

		Collections.fill(characterList, 'H');

		System.out.println("....... List filled with .......");

		printList(characterList);

	}

	public static void checkDisjoint() {
		String[] colors = { "Red", "Blue", "Green", "Yellow", "Magenta" };
		List<String> list1 = Arrays.asList(colors);
		String[] colors2 = { "Black", "White", "Brown", "Torquoise" };
		List<String> list2 = Arrays.asList(colors2);

		System.out.printf("It is %s that two lists have no elmenets in common",
				Collections.disjoint(list1, list2));

	}

	public static void printList(List<?> list) {

		System.out.printf("%s%-19s", list, "");
	}

	public static class TimeComparator implements Comparator<Time> {

		@Override
		public int compare(Time time1, Time time2) {
			int hourDifference = time1.getHour() - time2.getHour();

			if (hourDifference != 0) // test the hour first
				return hourDifference;

			int minuteDifference = time1.getMin() - time2.getMin();

			if (minuteDifference != 0) // then test the minute
				return minuteDifference;

			int secondDifference = time1.getSec() - time2.getSec();
			return secondDifference;
		}

	}

	public static class Time {
		public Time(int hour, int min, int sec) {
			super();
			this.hour = hour;
			this.min = min;
			this.sec = sec;
		}

		public int getHour() {
			return hour;
		}

		public int getMin() {
			return min;
		}

		public int getSec() {
			return sec;
		}

		private final int hour;
		private final int min;
		private final int sec;

		@Override
		public String toString() {
			return "Time [hour=" + hour + ", min=" + min + ", sec=" + sec + "]";
		}

	}

}
