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
DC#270_MEDIUM
This problem was asked by Twitter.

A network consists of nodes labeled 0 to N. You are given a list of edges (a, b, t), 
describing the time t it takes for a message to be sent from node a to node b. 
Whenever a node receives a message, it immediately passes the message on to a neighboring node, if possible.

Assuming all nodes are connected, 
determine how long it will take for every node to receive a message that begins at node 0.

For example, given N = 5, and the following edges:

edges = [
    (0, 1, 5),
    (0, 2, 3),
    (0, 5, 4),
    (1, 3, 8),
    (2, 3, 1),
    (3, 5, 10),
    (3, 4, 5)
]

You should return 9, because propagating the message from 0 -> 2 -> 3 -> 4 will take that much time.
 */
public class DC270 {
	// First, I need to find out the minimum time to reach each node.
	// Then, I need to find the maximum time among those times.
	// I Assume there's no circulation loop.
	// I visit each node and get the minimum time to get there.
	public static void getNeededTime(Vertex head) {
		int max = Integer.MIN_VALUE;
		List<Edge> list = head.e;
		for(int i=0; i<list.size(); i++) {
			Edge e = list.get(i);
			if((e.time+e.start.t<e.end.t && e.end.visited) || !e.end.visited) e.end.t = e.time+e.start.t;
			getNeededTime(e.end);
		}
	}	

	public static void main(String[] args) {
		Graph g = new Graph();
		Vertex v = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		v.addEdge(v1, 5);
		v.addEdge(v2, 3);
		v.addEdge(v5, 4);
		v1.addEdge(v3, 8);
		v2.addEdge(v3, 1);
		v3.addEdge(v5, 10);
		v3.addEdge(v4, 5);
		g.addVertex(v);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		getNeededTime(v);
		int max = Integer.MIN_VALUE;
		for(Vertex vtx : g.vertices) {
			max = Math.max(vtx.t, max);
		}
		System.out.println(max);
	}
}

class Graph {
	public List<Vertex> vertices;

	public Graph() {
		vertices = new ArrayList<>();
	}

	public void addVertex(Vertex v) {
		vertices.add(v);
	}
}

class Vertex {
	public int v;
	public List<Edge> e;
	public int t;
	public boolean visited = false;

	public Vertex(int v) {
		this.v = v;
		this.t = 0;
		this.e = new ArrayList<>();
	}

	public void addEdge(Vertex cp, int t) {
		e.add(new Edge(this, cp, t));
	}
}

class Edge {
	public Vertex start;
	public Vertex end;
	public int time;

	public Edge(Vertex s, Vertex e, int t) {
		this.start = s;
		this.end = e;
		this.time = t;
	}
}
