package com.hackerrank.queue;

import java.util.HashMap;
import java.util.Map;


public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "2");

		Map map2 = (Map) map.clone();
		map2.put("1", "4");

		System.out.println(map.get("1"));
		System.out.println(map2.get("1"));

		A a = new A();
		B b = new B();
		b.s = "a";
		a.i = 0;
		a.b = b;

		A aa = (A) a.clone();
		aa.b.s = "a";

		System.out.println(a);
		System.out.println(aa);

		System.out.println(a.b);
		System.out.println(aa.b);

	}

}

class A implements Cloneable {
	B b;
	int i;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		A a = (A) super.clone();
		a.b = (B) this.b.clone();
		return a;
	}
}

class B implements Cloneable {
	String s;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}