package com.deepti.singelton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainApplication {

	public static void serializeObject(final Customer customer) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("customerObjectsFile.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(customer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Customer deSerializeObject() {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		Customer customerObject = null;
		try {
			fileInputStream = new FileInputStream("customerObjectsFile.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = null;
			try {
				object = objectInputStream.readObject();
				customerObject = (Customer) object;
				// System.out.println("This is object value: " + customerObject);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customerObject;
	}

	public static void main(String[] args) {
		System.out.println("Main Starts");
		Customer customer1 = new Customer(1, "Deepti", "XYZ Street", 1000001, "Pass123");
		Customer returnCustomerResult = null;
		System.out.println("1) For serialize");
		System.out.println("2) For De-Serialize");
		System.out.println("Enter the choice");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			serializeObject(customer1);
			break;
		case 2:
			returnCustomerResult = deSerializeObject();

			System.out.println("customer1 hashCode: " + "\t" + customer1.hashCode());
			System.out.println("returnResult hashcode: " + "\t" + returnCustomerResult.hashCode());
			System.out.println("customer1 " + "\t" + customer1);
			System.out.println("returnResult " + "\t" + returnCustomerResult);
			if (customer1 == returnCustomerResult) {
				System.out.println("Both are equal");
			} else {
				System.out.println("Not equal");
			}

			System.out.println("customer1: " + customer1.toString());
			System.out.println("returnCustomerResult:" + returnCustomerResult.toString());
			break;
		default:
			System.exit(0);
			break;
		}
		sc.close();
		System.out.println("Main Ends");
	}

}
