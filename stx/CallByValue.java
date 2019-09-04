/**
 * TODO : 
 * 1. Time/Space Complexity Analysis
 * 		BUT, MOST OF ALL, IT IS IMPORTANT TO 1.1. LIST POSSIBLE/AVAILABLE SOLUTIONS AND 1.2. THINK ABOUT COMPLEXITY FIRST AND IN ADVANCE,
 * 		1.3. START WITH BEST COMPLEXITY SOLUTION
 * 2. Improve Algorithm/Performance
 * 3. Learn unfamiliar syntax 
 * 4. Any other ways to consider + compare in terms of Time/Space complexity
 *
 */
package alg.stx;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
/*
 * http://www.javadude.com/articles/passbyvalue.htm
 */
public class CallByValue {
	public static void moveTo(Person p) {
		p = new Person(2, "Other", new Department(2, "Web"));
		System.out.println(p.toString());
	}

	public static void main(String[] args) {
		Department d=new Department(1, "IT");
		Person p = new Person(1, "Jason", d);
		moveTo(p);
		System.out.println(p.toString());
	}
}

class Person {
	int id;
	String name;
	Department dep;

	public Person(int id, String n, Department d) {
		this.id = id;
		this.name = n;
		this.dep =d;
	}

	public String toString() {
		StringBuffer b = new StringBuffer(this.id);
		b.append(" : " + this.name).append("\n").append(dep.toString());
		return b.toString();
	}
}

class Department {
	int id;
	String name;

	public Department(int id, String n) {
		this.id = id;
		this.name = n;
	}

	public String toString() {
		StringBuffer b = new StringBuffer(this.id);
		b.append(" : " + name);
		return b.toString();
	}
}
