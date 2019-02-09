package GraphClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {
	private HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (!containsVertex(vname)) {
			vces.put(vname, new HashMap<>());
		}
	}

	public void removeVertex(String vname) {
		if (containsVertex(vname)) {
			for (String nbrname : vces.get(vname).keySet()) {
				vces.get(nbrname).remove(vname);
			}
			vces.remove(vname);
		}
	}

	public int countEdges() {
		int sum = 0;

		for (String vname : vces.keySet()) {
			sum += vces.get(vname).size();
		}

		return sum / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			return vces.get(v1name).containsKey(v2name) && vces.get(v2name).containsKey(v1name);
		} else {
			return false;
		}
	}

	public void addEdge(String v1name, String v2name, int weight) {
		if (containsVertex(v1name) && containsVertex(v2name)) {
			vces.get(v1name).put(v2name, weight);
			vces.get(v2name).put(v1name, weight);
		}
	}

	public void removeEdge(String v1name, String v2name) {
		if (containsEdge(v1name, v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}

	public void display() {
		System.out.println("-----------------------------------");
		for (String vname : vces.keySet()) {
			System.out.println(vname + " -> " + vces.get(vname));
		}
		System.out.println("-----------------------------------");
	}

	public boolean hasPath(String v1name, String v2name) {
		return hasPathHelper(v1name, v2name, new HashSet<>());
	}

	private boolean hasPathHelper(String src, String dest, HashSet<String> visited) {
		if (src.equals(dest)) {
			return true;
		}

		visited.add(src);
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				boolean fin = hasPathHelper(nbr, dest, visited);
				if (fin == true) {
					return true;
				}
			}
		}

		return false;
	}

	public void printAllPaths(String v1name, String v2name) {
		printAllPaths(v1name, v2name, new HashSet<>(), "", 0);
	}

	private void printAllPaths(String src, String dest, HashSet<String> visited, String psf, int csf) {
		if (src.equals(dest)) {
			System.out.println(psf + dest + "@" + csf);
			return;
		}

		visited.add(src);
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				printAllPaths(nbr, dest, visited, psf + src, csf + vces.get(src).get(nbr));
			}
		}
		visited.remove(src);
	}

	private class Pair implements Comparable<Pair> {
		int cost;
		String path;

		Pair(int cost, String path) {
			this.cost = cost;
			this.path = path;
		}

		@Override
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}

	int sc;
	String scp;
	int lc;
	String lcp;
	int jlc;
	String jlp;
	PriorityQueue<Pair> pq;

	public void multisolver(String src, String dest, int k, int jlw) {
		sc = Integer.MAX_VALUE;
		scp = "";
		lc = Integer.MIN_VALUE;
		lcp = "";
		jlc = Integer.MAX_VALUE;
		jlp = "";
		pq = new PriorityQueue<>();
		multisolver(src, dest, new HashSet<>(), "", 0, jlw, k);
		System.out.println(scp + "@" + sc);
		System.out.println(lcp + "@" + lc);
		System.out.println(jlp + "@" + jlc);
		System.out.println(pq.peek().path + "@" + pq.peek().cost);
	}

	private void multisolver(String src, String dest, HashSet<String> visited, String psf, int csf, int jlw, int k) {
		if (src.equals(dest)) {
			if (csf < sc) {
				sc = csf;
				scp = psf + dest;
			}

			if (csf > lc) {
				lc = csf;
				lcp = psf + dest;
			}

			if (csf > jlw) {
				if (csf < jlc) {
					jlc = csf;
					jlp = psf + dest;
				}
			}

			if (pq.size() < k) {
				pq.add(new Pair(csf, psf + dest));
			} else if (csf > pq.peek().cost) {
				pq.remove();
				pq.add(new Pair(csf, psf + dest));
			}

			return;
		}

		visited.add(src);
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				multisolver(nbr, dest, visited, psf + src, csf + vces.get(src).get(nbr), jlw, k);
			}
		}
		visited.remove(src);
	}

	private class TPair {
		String vname;
		String psf;

		TPair(String vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}
	}

	public boolean bfs(String src, String dest) {
		LinkedList<TPair> queue = new LinkedList<>();
		queue.add(new TPair(src, src));
		HashSet<String> visited = new HashSet<>();

		while (queue.size() > 0) {
			TPair rp = queue.removeFirst();
			visited.add(rp.vname);

			System.out.println(rp.vname + "@" + rp.psf);
			if (rp.vname.equals(dest)) {
				return true;
			}

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbr)) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}

		return false;
	}

	public boolean dfs(String src, String dest) {
		LinkedList<TPair> stack = new LinkedList<>();
		stack.add(new TPair(src, src));
		HashSet<String> visited = new HashSet<>();

		while (stack.size() > 0) {
			TPair rp = stack.removeFirst();
			visited.add(rp.vname);

			System.out.println(rp.vname + "@" + rp.psf);
			if (rp.vname.equals(dest)) {
				return true;
			}

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbr)) {
					stack.addFirst(new TPair(nbr, rp.psf + nbr));
				}
			}
		}

		return false;
	}

	public void bft() {
		HashSet<String> visited = new HashSet<>();
		for (String vname : vces.keySet()) {
			if (!visited.contains(vname)) {
				bftcomponent(vname, visited);
			}
		}
	}

	public void bftcomponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		queue.add(new TPair(src, src));

		while (queue.size() > 0) {
			TPair rp = queue.removeFirst();
			visited.add(rp.vname);
			System.out.println(rp.vname + "@" + rp.psf);

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbr)) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}
	}

	public void dft() {
		HashSet<String> visited = new HashSet<>();
		for (String vname : vces.keySet()) {
			if (!visited.contains(vname)) {
//				dftcomponent(vname, visited);
				dftcomponentR(vname, vname, visited);
			}
		}
	}

	public void dftcomponent(String src, HashSet<String> visited) {
		LinkedList<TPair> stack = new LinkedList<>();
		stack.add(new TPair(src, src));

		while (stack.size() > 0) {
			TPair rp = stack.removeFirst();
			visited.add(rp.vname);
			System.out.println(rp.vname + "@" + rp.psf);

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbr)) {
					stack.addFirst(new TPair(nbr, rp.psf + nbr));
				}
			}
		}
	}

	private void dftcomponentR(String src, String psf, HashSet<String> visited) {
		System.out.println(src + "@" + psf);

		visited.add(src);
		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				dftcomponentR(nbr, psf + nbr, visited);
			}
		}

		visited.remove(src);
	}

	public boolean isConnected() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> allvces = new ArrayList<>(vces.keySet());
		bftcomponent(allvces.get(0), visited);
		return visited.size() == vces.size();
	}

	public boolean isCyclic() {
		HashSet<String> visited = new HashSet<>();
		for (String vname : vces.keySet()) {
			if (!visited.contains(vname)) {
				boolean cycle = isCyclicComponent(vname, visited);
				if (cycle == true) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean isCyclicComponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		queue.add(new TPair(src, src));
		while (queue.size() > 0) {
			TPair rp = queue.removeFirst();
			if (visited.contains(rp.vname)) {
				return true;
			}
			visited.add(rp.vname);

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbr)) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}

		return false;
	}

	public ArrayList<String> gcc() {

		HashSet<String> visited = new HashSet<>();
		ArrayList<String> al = new ArrayList<String>();
		for (String vName : vces.keySet()) {
			if (!visited.contains(vName)) {
				String str = gccComponent(vName, visited);
				System.out.println(str);
			}
		}

		return al;
	}

	public String gccComponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		queue.add(new TPair(src, src));

		String str = "";
		while (queue.size() > 0) {
			// remove
			// mark
			// work
			// add unvisited nbr
			TPair rp = queue.removeFirst();
			if (visited.contains(rp.vname)) {
				continue;
			}
			visited.add(rp.vname);
			str += rp.vname;

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbr)) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}
		return str;
	}

	private class DPair implements Comparable<DPair> {
		String vname;
		String psf;
		int csf;

		public DPair(String vname, String psf, int csf) {
			this.vname = vname;
			this.psf = psf;
			this.csf = csf;
		}

		@Override
		public int compareTo(DPair o) {
			// TODO Auto-generated method stub
			return this.csf - o.csf;
		}
	}

	public void djikstra(String src) {
		PriorityQueue<DPair> queue = new PriorityQueue();
		HashSet<String> visited = new HashSet();

		queue.add(new DPair(src, src, 0));

		while (queue.size() > 0) {
			DPair rp = queue.remove();

			if (visited.contains(rp.vname)) {
				continue;
			}
			visited.add(rp.vname);

			System.out.println(rp.vname + " via " + rp.psf + " @ " + rp.csf);

			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbr)) {
					queue.add(new DPair(nbr, rp.psf + nbr, rp.csf + vces.get(rp.vname).get(nbr)));
				}
			}
		}
	}
}
