package alg.lmda;

@FunctionalInterface
interface CompareInf {
	public int compareTo(Computer c1, Computer c2);
}

public class CompInf {
	public static int compare(Computer c1, Computer c2, CompareInf inf) {
		return inf.compareTo(c1,c2);
	}

	public static void main(String args[]) {
		Computer c1 = new Computer();
		Computer c2= new Computer();
		c1.setAge(10);
		c2.setAge(29);
		//int res =  compare(c1, c2, (d1,d2) -> 2*d1.getAge()-d2.getAge());
//		CompareInf cI = CompareInf.compareTo(Computer::getAge);
		int res =  compare(c1, c2, (d1,d2) -> { return 2*d1.getAge()-d2.getAge();});
//		int res2 =  compare(c1, c2, cI);
		System.out.println(res);
//		System.out.println(res2);
	}
}

class Computer {
	private int age;

	public void setAge(int a) {
		this.age = a;
	}

	public int getAge() {
		return this.age;
	}
}
