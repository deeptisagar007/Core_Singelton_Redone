package com.deepti.singelton;

public class A {

	int num;

	String str;

	@Override
	public boolean equals(Object a3) {
		A temp = (A) a3;
		// if(this.num == temp.num)
		// return true;

		// if (this.str.equals(temp.str))
		// return true;
		if (this.str == temp.str) {
			return true;
		}

		return false;
	}

	public static void main(String a[]) {
		A a1 = new A();
		a1.str = "hi";
		A a2 = new A();
		a2.str = "hi";

		System.out.println(a1.equals(a2));
	}

}