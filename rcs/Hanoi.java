package alg.rcs;

import java.util.Stack;
import java.util.Iterator;

public class Hanoi {

	static void moveDisks(int n, Tower org, Tower buf, Tower dst) {
		if(n==0) return;
		if(n==1) { Integer disk = org.slideOff();
			dst.slideOnto(disk);
			return;
		};
		if(n==2) {
			Integer disk1 = org.slideOff();
			buf.slideOnto(disk1);
			Integer disk2 = org.slideOff();
			dst.slideOnto(disk2);
			dst.slideOnto(buf.slideOff());
		}
		if(n>=3) {
			moveDisks(n-1, org, dst, buf);
			Integer disk = org.slideOff();
			dst.slideOnto(disk);
			moveDisks(n-1, buf, org, dst);
		}
	}

	public static void main(String args[]) {
		int diskNum = 7;
		Tower org = new Tower("ORG");
		for(int i =0; i < diskNum; i++) {
			org.s.push(new Integer(i));
		}
		Tower buf = new Tower("BUF");
		Tower dst = new Tower("DST");
		org.print();
		buf.print();
		dst.print();
		moveDisks(diskNum, org, buf, dst);
		org.print();
		buf.print();
		dst.print();
	}
}

class Tower {
	String name;
	public Tower(String n) {
		this.name = n;
	}
	public Stack<Integer> s = new Stack<>();

	public Integer slideOff() {
		return s.pop();
	}

	public void slideOnto(Integer disk) {
		s.push(disk);
	}
	public void print() {
		Iterator itr = s.iterator();
		System.out.println(name + " : " );
		while(itr.hasNext()){
			System.out.print(itr.next() + "	"); 
		}
		System.out.println();
	}
}
