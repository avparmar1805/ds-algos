package GraphStory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Graph {

	private HashMap<String, HashMap<String, Integer>> vces = new HashMap();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vName) {
		return vces.containsKey(vName);
	}

	public void addVertex(String vName) {
		if (!containsVertex(vName)) {
			vces.put(vName, new HashMap());
		}
	}

	public boolean containsEdge(String v1Name, String v2Name) {
		if (containsVertex(v1Name) && containsVertex(v2Name)) {
			return vces.get(v1Name).containsKey(v2Name) && vces.get(v2Name).containsKey(v1Name);
		}
		return false;
	}

	public void addEdge(String v1Name, String v2Name, int weight) {
		if (containsVertex(v1Name) && containsVertex(v2Name)) {
			vces.get(v1Name).put(v2Name, weight);
			vces.get(v2Name).put(v1Name, weight);
		}
	}

	public void removeEdge(String v1Name, String v2Name) {
		if (containsEdge(v1Name, v2Name)) {
			vces.get(v1Name).remove(v2Name);
			vces.get(v2Name).remove(v1Name);
		}
	}

	public void removeVertex(String vName) {
		if (containsVertex(vName)) {
			for (String nbrName : vces.get(vName).keySet()) {
				vces.get(nbrName).remove(vName);
			}
			vces.remove(vName);
		}
	}

	public void display() {
		System.out.println(" --------------- ");
		for (String vName : vces.keySet()) {
			System.out.println(vName + " => " + vces.get(vName));
		}
		System.out.println(" --------------- ");
	}

	public int countEdges() {
		int sum = 0;

		for (String vName : vces.keySet()) {
			sum += vces.get(vName).size();
		}

		return sum / 2;
	}

	public boolean hasPath(String v1Name, String v2Name) {
		return hasPath(v1Name, v2Name, new HashSet<String>(), "");
	}

	private boolean hasPath(String src, String dest, HashSet<String> visited, String psf) {

		if (src.equals(dest)) {
			System.out.println(psf + dest);
			return true;
		}

		visited.add(src);
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				boolean found = hasPath(nbr, dest, visited, psf + src);
				if (found) {
					return true;
				}
			}
		}

		return false;
	}

	public void printAllPaths(String v1Name, String v2Name) {
		printAllPaths(v1Name, v2Name, new HashSet<String>(), "", 0);
	}

	private void printAllPaths(String src, String dest, HashSet<String> visited, String psf, int csf) {

		if (src.equals(dest)) {
			System.out.println(psf + dest + "@" + csf);
		}

		visited.add(src);
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				printAllPaths(nbr, dest, visited, psf + src, csf + vces.get(src).get(nbr));
			}
		}
		visited.remove(src);
	}

	int sc = 0;
	String scp = "";
	int lc = 0;
	String lcp = "";
	int jlc = 0;
	String jlp = "";

	PriorityQueue<Pair> pq;

	private class Pair implements Comparable<Pair> {
		int cost;
		String path;

		Pair(int cost, String path) {
			this.cost = cost;
			this.path = path;
		}

		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	public void multisolver(String src, String dest, int k, int jlw) {
		sc = Integer.MAX_VALUE;
		scp = "";
		lc = Integer.MIN_VALUE;
		lcp = "";
		jlc = Integer.MAX_VALUE;
		jlp = "";
		pq = new PriorityQueue();
		multisolver(src, dest, new HashSet<>(), "", 0, jlw, k);
		System.out.println(scp + "@ " + sc);
		System.out.println(lcp + "@ " + lc);
		System.out.println(jlp + "@ " + jlc);
		System.out.println(pq.peek().path + "@ " + pq.peek().cost);
	}

	private void multisolver(String src, String dest, HashSet<String> visited, String psf, int csf, int jlw, int k) {
		if (src.equals(dest)) {
			String path = psf + dest;
			if (csf > lc) {
				lc = csf;
				lcp = psf;
			}
			if (csf < sc) {
				sc = csf;
				scp = psf;
			}
			if (csf > jlw && csf < jlc) {
				jlc = csf;
				jlp = psf;
			}

			if (pq.size() < k) {
				pq.add(new Pair(csf, psf));
			} else if (pq.peek().cost < csf) {
				pq.remove();
				pq.add(new Pair(csf, path));
			}
		}

		visited.add(src);
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				multisolver(nbr, dest, visited, psf + src, csf + vces.get(src).get(nbr), jlw, k);
			}
		}
		visited.remove(src);
	}
}
