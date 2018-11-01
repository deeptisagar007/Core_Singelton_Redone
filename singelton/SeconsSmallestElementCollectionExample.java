package com.deepti.singelton;

import java.util.Set;
import java.util.TreeSet;

public class SeconsSmallestElementCollectionExample {

	public int getSmallestElement(int mainArrays[]) {

		Set<Integer> mainArraysSet = new TreeSet<Integer>();
		int lowestElement = 0;
		for (int i : mainArrays) {
			mainArraysSet.add(i);
		}
		System.out.println("SortedSet: " + mainArraysSet);
		Object objectArray[] = mainArraysSet.toArray();
		int intForObject[] = new int[10];

		for (Object obji : objectArray) {
			int count = 0;
			intForObject[count] = (Integer) objectArray[count];
			count++;
		}
		lowestElement = (Integer) objectArray[0];

		return lowestElement;
	}

	public static void main(String[] args) {
		System.out.println("Main Sarts");
		int mainIntArrays[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11, 12, 13, 14, 15, 9, 8, 7, 6, 5, 4, 3, 2, 10, 1, 0 };
		SeconsSmallestElementCollectionExample mainObject = new SeconsSmallestElementCollectionExample();
		int smallestElement = mainObject.getSmallestElement(mainIntArrays);
		System.out.println("Smallest Element is: " + smallestElement);
		System.out.println("Main Ends");
	}

}
