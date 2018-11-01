package com.deepti.singelton;

public class maintry {
	public static void main(String[] args) {
		Customer cust1 = new Customer(1, "ABx", "XYZ", 10000001, "PAss");
		Customer cust2 = new Customer(1, "ABx", "XYZ", 10000001, "PAss");
		Customer cust3 = cust1;
		System.out.println(cust1 == cust3);
		System.out.println("Equals: " + cust1.equals(cust2));

		/*
		 * FileOutputStream fos = new FileOutputStream("tryHash.txt");
		 * ObjectOutputStream oos = new ObjectOutputStream(fos); oos.writeObject(oos);
		 * 
		 * FileInputStream fis = new FileInputStream("tryHash.txt")
		 */

		System.out.println("Cust1: " + cust1.hashCode());
		System.out.println("Cust2: " + cust2.hashCode());
	}
}
