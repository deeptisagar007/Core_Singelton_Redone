package com.deepti.singelton;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SingleTon implements Serializable, Cloneable {

	private static SingleTon singletonInstance = null;
	private static boolean singletonFlag = false;

	public synchronized static SingleTon getInstance() throws InstantiationException {
		/*
		 * System.out.
		 * println("Step 2: Make a method which will return Class object/instance ");
		 * System.out.
		 * println("Step 3: Make a Private ClassName_Type variable to return as class object"
		 * ); System.out.println(
		 * "Step 4: Make getInstance() synchronized so that no multiple threads can access getInstance() method at the same time"
		 * ); System.out.println(
		 * "Step 5: Check if the customerInstance == null, if null means this is the first time getInstance() is been called"
		 * );
		 */
		if (singletonInstance == null) {
			singletonFlag = true;
			singletonInstance = new SingleTon();
		}
		return singletonInstance;
	}

	protected Object readResolve() {
		System.out.println("in ReadResolve Method");
		return singletonInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		CloneNotSupportedException cloneNotSupported = new CloneNotSupportedException("Clone cannot be created");
		return cloneNotSupported;
	}

	private SingleTon() throws InstantiationException {
		if (singletonFlag) {
			throw new InstantiationException("Can only create one Instance");
		}
		// System.out.println("First Step: Make Constructor Private ");
		// System.out.println("==> No body will able to access constructor method
		// outside the class");
	}

}
