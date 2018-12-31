package alg.rcs;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Boxes {
	static int max = 0;
	static List<Box> getBoxes() {
		List<Box> list = new ArrayList<>();
		list.add(new Box(11,45,15));
		list.add(new Box(17,27,33));
		list.add(new Box(26,38,25));
		list.add(new Box(28,44,33));
		list.add(new Box(34,16,56));
		list.add(new Box(22,57,81));
		list.add(new Box(44,88,70));
		list.add(new Box(71,100,99));
		return list;
	}

	static boolean checkValid(Box n, Box p) {
		System.out.println(n + ", previous = " + p);
		if(p==null) return true;
		if(n.width<p.width&&n.depth<p.depth) return true;
		return false;
	}

	static void getMax(List<Box> list, int idx, Box prev, int sum) {
		if(idx==list.size()) {
			if(max<sum) {
				max = sum;
				System.out.println("ADD to RESULT : " + prev + " , SUM : " + sum);
			} 
		} else {
			for(int i = idx; i < list.size(); i++) {
				Box cur = (Box)list.get(i);
				if(checkValid(cur, prev)) {
					getMax(list, i+1, prev, sum);
					getMax(list, i+1, cur, sum+cur.height);
				} else {
					getMax(list, i+1, prev, sum);
				}
			}
		}
	}


	public static void main(String[] args) {
		// 1. first sort with one of dimensions
		List<Box> list = getBoxes();
		list.forEach(u->System.out.println(u));
		list.sort((Box a, Box b) -> b.height-a.height);
		System.out.println();
		list.forEach(u->System.out.println(u));

		System.out.println();
		// 2. check if one can be on the top of the previous one
		// if ok, add it to result list, if not, skip because anyway you can not chnage the order already sorted in height
		getMax(list, 0, null, 0);
		System.out.println(max);

/*		System.out.println();
		System.out.println("Sort1");
		List<Box> list = getBoxes();
		for( Box b : list ) {
			System.out.println(b);
		}
		list.forEach(b->System.out.println(b));

		Collections.sort(list, new Comparator<Box>(){
			public int compare(Box a, Box b) {
				return a.height - b.height;
			}
		});

		list.forEach(b->System.out.println(b));

		System.out.println();
		System.out.println("Sort2");
		list = getBoxes();
		list.forEach(b->System.out.println(b));
		list.sort(new Comparator<Box>() {
			public int compare(Box a, Box b) {
				return a.height - b.height;
			}
		});
		list.forEach(b->System.out.println(b));

		System.out.println();
		System.out.println("Sort3");

		list = getBoxes();
		list.forEach(b->System.out.println(b));
		list.sort((Box a, Box b) -> (a.height-b.height));
		list.forEach(b->System.out.println(b));*/
	}
}

class MyComparator implements Comparator<Box> {
	public int compare(Box a, Box b) {
		return a.height - b.height;
	}
}

class Box implements Comparator<Box> {
	public int height;
	public int width;
	public int depth;

	public Box(int h, int w, int d) {
		height = h;
		width = w;
		depth = d;
	}

	public int compare(Box a, Box b) {
		return a.height - b.height;
	}

	public String toString() {
		return ("height : " + height + " , width : " + width + ", depth : " + depth);
	}
}
