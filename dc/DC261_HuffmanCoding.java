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
package alg.dc;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;
/**
 * 
This problem was asked by Amazon.

Huffman coding is a method of encoding characters based on their frequency. 
Each letter is assigned a variable-length binary string, such as 0101 or 111110, 
where shorter lengths correspond to more common letters. 
To accomplish this, a binary tree is built such that the path from the root to any leaf uniquely maps to a character. 
When traversing the path, descending to a left child corresponds to a 0 in the prefix, 
while descending right corresponds to 1.

Here is an example tree (note that only the leaf nodes have letters):

        *
      /   \
    *       *
   / \     / \
  *   a   t   *
 /             \
c               s

With this encoding, cats would be represented as 0000110111.

Given a dictionary of character frequencies, build a Huffman tree, 
and use it to determine a mapping between characters and their encoded binary strings.
 */
public class DC261_HuffmanCoding {
	//
	// Each node can have both of * or both of character or one * and one character
	// To make it shorter, from depth 2, each node should have one character and one *
	// when less than or equal to 4 characters are left, assign them all to the nodes who can be assigned
	public static void makeHuffmanTree(PriorityQueue q) {
		if(q.size()<=0) return;
		TreeNode root = new TreeNode("*");
		if(q.size()<=2) {
			if(!q.isEmpty()) {
				root.left = new TreeNode(q.pull());
			}
			if(!q.isEmpty()) {
				root.right = new TreeNode(q.pull());
			}
			return;
		}
		Queue<TreeNode> q = new ArrayList<>();
		root.left = new TreeNode("*");
		root.left.left = new TreeNode("*");
		root.left.right = new TreeNode(q.pull().ch);
		root.right  = new TreeNode("*");
		root.right.left = new TreeNode(q.pull().ch);
		root.right.right = new TreeNode("*");
		q.offer(root.left.left);
		q.offer(root.right.right);
		while(!q.isEmpty()) {
			if(pq.size()>4) {
				TreeNode n = q.pull();
				n.left = new TreeNode("*");
				n.right = new TreeNode(pq.pull().ch);
				q.offer(n.left);
			} else {
				if(
				TreeNode n = q.pull();

			}
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Freq> pq = new PriorityQueue<>();
		pq.add(new Freq(10, 'a'));
		pq.add(new Freq(8, 'b'));
		pq.add(new Freq(15, 's'));
		pq.add(new Freq(23, 't'));
		pq.add(new Freq(5, 'e'));
	}
}

class Freq implements Comparable<Freq> {
	public int freq;
	public Character ch;
	public Freq(int f, Character c) {
		this.freq = f;
		this.ch = c;
	}

	@override
	public int compareTo(Freq f) {
		return f.freq.compareTo(this.freq);
	}
}
