package july4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kruksalsClient {

	public static void main(String[] args) {
		int vces = 6;
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 10));
		edges.add(new Edge(1, 2, 10));
		edges.add(new Edge(2, 3, 10));
		edges.add(new Edge(0, 3, 40));
		edges.add(new Edge(3, 4, 2));
		edges.add(new Edge(4, 5, 3));
		edges.add(new Edge(5, 6, 3));
		edges.add(new Edge(4, 6, 8));

		kruskals(edges, vces);
	}

	private static void kruskals(ArrayList<Edge> graph, int vces) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(graph);
		ArrayList<Edge> mstGraph = new ArrayList<>();

		int[] dsets = new int[vces + 1];
		int[] ranks = new int[vces + 1];
		for (int i = 0; i < dsets.length; i++) {
			dsets[i] = i;
			ranks[i] = 1;
		}

		while (pq.size() > 0) {
			Edge re = pq.remove();

			int v1set = find(dsets, re.v1);
			int v2set = find(dsets, re.v2);

			if (v1set != v2set) {
				mstGraph.add(re);
				union(dsets, ranks, v1set, v2set);
			}
		}

		System.out.println(mstGraph);
	}

	private static void union(int[] dsets, int[] ranks, int v1set, int v2set) {
		if (ranks[v1set] < ranks[v2set]) {
			dsets[v1set] = v2set;
		} else if (ranks[v1set] > ranks[v2set]) {
			dsets[v2set] = v1set;
		} else {
			dsets[v1set] = v2set;
			ranks[v2set]++;
		}
	}

	private static int find(int[] dsets, int v) {
		if (dsets[v] != v) {
			dsets[v] = find(dsets, dsets[v]);
		}

		return dsets[v];
	}

	private static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int weight;

		Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		public String toString() {
			return "[" + this.v1 + ", " + this.v2 + ", " + this.weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
