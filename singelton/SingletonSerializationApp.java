package com.deepti.singelton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SingletonSerializationApp {

	public static void serialize(SingleTon singletonObject) {
		FileOutputStream fileOutptStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutptStream = new FileOutputStream("SingletonObject.txt");
			objectOutputStream = new ObjectOutputStream(fileOutptStream);
			objectOutputStream.writeObject(singletonObject);
			System.out.println("Object is Serialized");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				fileOutptStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static SingleTon deSerialize() {

		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		SingleTon deSerializedSingleton = null;
		Object object = null;
		try {
			fileInputStream = new FileInputStream("SingletonObject.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			object = objectInputStream.readObject();
			deSerializedSingleton = (SingleTon) object;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return deSerializedSingleton;
	}

	public static void main(String[] args) throws InstantiationException {
		System.out.println("SingletonSerialization Main Starts");
		SingleTon singletonObject = SingleTon.getInstance();
		SingleTon deSerializedSingleton = null;
		System.out.println("1) Serialize");
		System.out.println("2) DeSerialize");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			serialize(singletonObject);
			break;
		case 2:
			deSerializedSingleton = deSerialize();
			System.out.println("This is SingletonObject: " + singletonObject);
			System.out.println("This is deserializeResult: " + deSerializedSingleton);
			break;

		default:
			sc.close();
			System.exit(0);
			break;
		}

		System.out.println("SingletonSerialization Main Ends");
	}

}
