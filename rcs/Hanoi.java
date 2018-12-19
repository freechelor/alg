package alg.rcs;

import java.util.Stack;

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
			Integer disk = org.slideOff();
			buf.slideOnto(disk);
			moveDisks(n-1, org, buf, dst);
		}
	}

	public static void main(String args[]) {
		int diskNum = 4;
		Tower org = new Tower();
		for(int i =0; i < diskNum; i++) {
			org.s.push(new Integer(i));
		}
		Tower buf = new Tower();
		Tower dst = new Tower();
		moveDisks(diskNum, org, buf, dst);
	}
}

class Tower {
	public Tower() {
	}
	public Stack<Integer> s = new Stack<>();

	public Integer slideOff() {
		return s.pop();
	}

	public void slideOnto(Integer disk) {
		s.push(disk);
	}
}
