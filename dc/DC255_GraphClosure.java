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

/**
DC#255_Easy
This problem was asked by Microsoft.

The transitive closure of a graph is a measure of which vertices are reachable from other vertices. It can be represented as a matrix M, where M[i][j] == 1 if there is a path between vertices i and j, and otherwise 0.

For example, suppose we are given the following graph in adjacency list form:

graph = [
    [0, 1, 3],
    [1, 2],
    [2],
    [3]
]

The transitive closure of this graph would be:

[1, 1, 1, 1]
[0, 1, 1, 0]
[0, 0, 1, 0]
[0, 0, 0, 1]

Given a graph, find its transitive closure.
 **/
public class DC255_GraphClosure {
	// Idea : 
	// I already know direct paths between vertices because they're given
	// so, I need to find indirect paths. 
	// If there are existing paths between two vertices, which must start from one of vertices connected directly to one of the two vertices
	// 
	// Implementation :
	// 1. fill direct paths from the given conditions
	// 2. find other paths from vertices which are connected to a starting vertice(marked as 1)
	// use HashMap
	
	public static void findClosure(ArrayList<ArrayList<Integer>> list) {
		HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
		int n = list.size();
		int[][] closure = new int[n][n];
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				if(map.get(list.get(i).get(0))==null) {
					HashSet<Integer> set = new HashSet<>();
					set.add(list.get(i).get(j));
					map.put(list.get(i).get(0), set);
				} else {
					set = map.get(list.get(i).get(0));
					set.add(list.get(i).get(j));
				}
			}
		}

		Set<Map.Entry<Integer, HashSet<Integer>>> entries = map.entrySet();
		for(Map.Entry<Integer,HashSet<Integer>> e :  entries) {
			for(Integer i : e.values()) {
				int key = e.getKey();
				if(key==i) closure[key][i]=1;
				else {
					closure[key][i] = 1;

				}
			}
		}
	}

	public static void main(String[] args) {
	}
}
