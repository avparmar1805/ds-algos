package july4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import feb11.sortings;
import july2.GenericHeap;
import june12.oops.P;

public class Graph {
	protected HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (containsVertex(vname)) {
			return;
		}
		vces.put(vname, new HashMap<>());
	}

	// directed diff
	public void removeVertex(String vname) {
		if (containsVertex(vname) == false) {
			return;
		}

		HashMap<String, Integer> nmap = vces.get(vname);
		ArrayList<String> nbrnames = new ArrayList<>(nmap.keySet());

		for (String nbrname : nbrnames) {
			removeEdge(vname, nbrname);
		}

		vces.remove(vname);
	}

	// directed diff
	public int countEdges() {
		int edges = 0;

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			HashMap<String, Integer> nbrmap = vces.get(vname);
			edges += nbrmap.size();
		}

		return edges / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		if (containsVertex(v1name) == false || containsVertex(v2name) == false) {
			return false;
		}

		return vces.get(v1name).containsKey(v2name);
	}

	// directed diff
	public void addEdge(String v1name, String v2name, int weight) {
		if (containsEdge(v1name, v2name) == true) {
			return;
		}

		vces.get(v1name).put(v2name, weight);
		vces.get(v2name).put(v1name, weight);
	}

	// directed diff
	public void removeEdge(String v1name, String v2name) {
		if (containsEdge(v1name, v2name) == false) {
			return;
		}

		vces.get(v1name).remove(v2name);
		vces.get(v2name).remove(v1name);
	}

	public void display() {
		System.out.println("-----------------------------");

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			HashMap<String, Integer> vmap = vces.get(vname);
			System.out.println(vname + " -> " + vmap);
		}

		System.out.println("-----------------------------");
	}

	public boolean hasPath(String src, String dest) {
		if (containsVertex(src) == false || containsVertex(dest) == false) {
			return false;
		}
		return hasPath(src, dest, new HashSet<>());
	}

	private boolean hasPath(String src, String dest, HashSet<String> visited) {
		if (containsEdge(src, dest)) {
			return true;
		}

		visited.add(src);

		HashMap<String, Integer> nbrsmap = vces.get(src);
		ArrayList<String> nbrnames = new ArrayList<>(nbrsmap.keySet());
		for (String nbrname : nbrnames) {
			if (visited.contains(nbrname) == false) {
				boolean hpfntd = hasPath(nbrname, dest, visited);
				if (hpfntd) {
					return true;
				}
			}
		}

		return false;
	}

	public void printAllPaths(String src, String dest) {
		printAllPath(src, dest, new HashSet<>(), src);
	}

	private void printAllPath(String src, String dest, HashSet<String> visited, String psf) {
		if (src.equals(dest)) {
			System.out.println(psf);
			return;
		}

		visited.add(src);
		for (String nbrname : vces.get(src).keySet()) {
			if (visited.contains(nbrname) == false) {
				printAllPath(nbrname, dest, visited, psf + nbrname);
			}
		}
		visited.remove(src);
	}

	private class Pair implements Comparable<Pair> {
		int dist;
		String path;

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}

		Pair(int dist, String path) {
			this.dist = dist;
			this.path = path;
		}
	}

	private class HeapMover {
		int spdist = Integer.MAX_VALUE;
		String spath = "";
		int lpdist = Integer.MIN_VALUE;
		String lpath = "";
		int jldist = Integer.MAX_VALUE;
		String jlPath = "";
		PriorityQueue<Pair> pq = new PriorityQueue<>();
	}

	public void multisolver(String src, String dest, int jlcriteria, int k) {
		HeapMover mover = new HeapMover();
		multisolver(src, dest, new HashSet<>(), src, 0, jlcriteria, k, mover);
		System.out.println("--------------------------------");
		System.out.println(mover.spath + "@" + mover.spdist);
		System.out.println(mover.lpath + "@" + mover.lpdist);
		System.out.println(mover.jlPath + "@" + mover.jldist);
		System.out.println(mover.pq.peek().path + "@" + mover.pq.peek().dist);
	}

	private void multisolver(String src, String dest, HashSet<String> visited, String psf, int dsf, int jlcriteria,
			int k, HeapMover mover) {
		if (src.equals(dest)) {
			System.out.println(psf + "@" + dsf);
			if (dsf > mover.lpdist) {
				mover.lpdist = dsf;
				mover.lpath = psf;
			}

			if (dsf < mover.spdist) {
				mover.spdist = dsf;
				mover.spath = psf;
			}

			if (dsf > jlcriteria) {
				if (dsf < mover.jldist) {
					mover.jldist = dsf;
					mover.jlPath = psf;
				}
			}

			if (mover.pq.size() < k) {
				mover.pq.add(new Pair(dsf, psf));
			} else if (dsf > mover.pq.peek().dist) {
				mover.pq.remove();
				mover.pq.add(new Pair(dsf, psf));
			}

			return;
		}

		visited.add(src);
		for (String nbrname : vces.get(src).keySet()) {
			if (visited.contains(nbrname) == false) {
				multisolver(nbrname, dest, visited, psf + nbrname, dsf + vces.get(src).get(nbrname), jlcriteria, k,
						mover);
			}
		}
		visited.remove(src);
	}

	private class TPair {
		String psf;
		String vname;
		String color;

		TPair(String psf, String vname) {
			this.psf = psf;
			this.vname = vname;
		}

		TPair(String psf, String vname, String color) {
			this(psf, vname);
			this.color = color;
		}
	}

	public boolean bfs(String src, String dest) {
		LinkedList<TPair> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();

		TPair rootpair = new TPair(src, src);
		queue.addLast(rootpair);

		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. work -> check path
			if (rp.vname.equals(dest)) {
				System.out.println(rp.psf);
				return true;
			}

			// 3. mark & print
			visited.add(rp.vname);
			System.out.println(rp.vname + "@" + rp.psf);

			// 4. add the unvisited nbrs
			for (String rpnbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(rpnbr) == false) {
					queue.addLast(new TPair(rp.psf + rpnbr, rpnbr));
				}
			}
		}

		return false;
	}

	public boolean dfs(String src, String dest) {
		LinkedList<TPair> stack = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();

		TPair rootpair = new TPair(src, src);
		stack.addFirst(rootpair);

		while (stack.size() > 0) {
			// 1. remove
			TPair rp = stack.removeFirst();

			// 2. work -> check path
			if (rp.vname.equals(dest)) {
				System.out.println(rp.psf);
				return true;
			}

			// 3. mark & print
			visited.add(rp.vname);
			System.out.println(rp.vname + "@" + rp.psf);

			// 4. add the unvisited nbrs
			for (String rpnbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(rpnbr) == false) {
					stack.addFirst(new TPair(rp.psf + rpnbr, rpnbr));
				}
			}
		}

		return false;
	}

	public void bft() {
		HashSet<String> visited = new HashSet<>();

		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				bftcomponent(vname, visited);
			}
		}
	}

	private void bftcomponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		TPair rootpair = new TPair(src, src);
		queue.addLast(rootpair);

		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. work -> none

			// 3. mark & print
			visited.add(rp.vname);
			System.out.println(rp.vname + "@" + rp.psf);

			// 4. add the unvisited nbrs
			for (String rpnbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(rpnbr) == false) {
					queue.addLast(new TPair(rp.psf + rpnbr, rpnbr));
				}
			}
		}
	}

	public void dft() {
		HashSet<String> visited = new HashSet<>();

		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				dftcomponent(vname, visited);
			}
		}
	}

	private void dftcomponent(String src, HashSet<String> visited) {
		LinkedList<TPair> stack = new LinkedList<>();
		TPair rootpair = new TPair(src, src);
		stack.addFirst(rootpair);

		while (stack.size() > 0) {
			// 1. remove
			TPair rp = stack.removeFirst();

			// 2. work -> none

			// 3. mark & print
			visited.add(rp.vname);
			System.out.println(rp.vname + "@" + rp.psf);

			// 4. add the unvisited nbrs
			for (String rpnbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(rpnbr) == false) {
					stack.addFirst(new TPair(rp.psf + rpnbr, rpnbr));
				}
			}
		}
	}

	public boolean IsConnected() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();

		bftcomponent(vnames.get(0), visited);

		return visited.size() == vces.size();
	}

	public ArrayList<String> gcc() {
		ArrayList<String> comps = new ArrayList<>();

		HashSet<String> visited = new HashSet<>();
		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				String comp = gccComponent(vname, visited);
				comps.add(comp);
			}
		}

		return comps;
	}

	private String gccComponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		TPair rootpair = new TPair(src, src);
		queue.addLast(rootpair);

		String comp = "";
		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. work -> none
			if (visited.contains(rp.vname) == false) {
				comp += rp.vname;
			}

			// 3. mark & print
			visited.add(rp.vname);

			// 4. add the unvisited nbrs
			for (String rpnbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(rpnbr) == false) {
					queue.addLast(new TPair(rp.psf + rpnbr, rpnbr));
				}
			}
		}

		return comp;
	}

	public boolean IsCyclic() {
		HashSet<String> visited = new HashSet<>();

		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				boolean cyclic = isCyclicComponent(vname, visited);
				if (cyclic == true) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isCyclicComponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		TPair rootpair = new TPair(src, src);
		queue.addLast(rootpair);

		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. work -> none
			if (visited.contains(rp.vname) == true) {
				return true;
			}

			// 3. mark & print
			visited.add(rp.vname);

			// 4. add the unvisited nbrs
			for (String rpnbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(rpnbr) == false) {
					queue.addLast(new TPair(rp.psf + rpnbr, rpnbr));
				}
			}
		}

		return false;
	}

	public boolean IsBipartite() {
		HashMap<String, String> visited = new HashMap<>();

		for (String vname : vces.keySet()) {
			if (visited.containsKey(vname) == false) {
				boolean isbip = IsBipartiteComponent(vname, visited);
				if (isbip == false) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean IsBipartiteComponent(String src, HashMap<String, String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();
		TPair rootpair = new TPair(src, src, "red");
		queue.addLast(rootpair);

		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. work -> none
			if (visited.containsKey(rp.vname) == true) {
				String oldcolor = visited.get(rp.vname);
				if (!rp.color.equals(oldcolor)) {
					return false;
				}
			}

			// 3. mark & print
			visited.put(rp.vname, rp.color);

			// 4. add the unvisited nbrs
			for (String rpnbr : vces.get(rp.vname).keySet()) {
				if (visited.containsKey(rpnbr) == false) {
					queue.addLast(new TPair(rp.psf + rpnbr, rpnbr, rp.color.equals("red") ? "green" : "red"));
				}
			}
		}

		return true;
	}

	private class DPair implements Comparable<DPair> {
		String vname;
		String psf;
		int csf;

		DPair(String vname, String psf, int csf) {
			this.vname = vname;
			this.psf = psf;
			this.csf = csf;
		}

		@Override
		public int compareTo(DPair o) {
			return this.csf - o.csf;
		}

		public String toString() {
			return "[" + this.psf + "@" + this.csf + "]";
		}
	}

	public void djikstra(String src) {
		PriorityQueue<DPair> pq = new PriorityQueue<>();
		HashMap<String, DPair> result = new HashMap<>();
		HashSet<String> visited = new HashSet<>();

		for (String vname : vces.keySet()) {
			DPair pair = new DPair(vname, null, Integer.MAX_VALUE);

			if (vname.equals(src)) {
				pair.psf = vname;
				pair.csf = 0;
			}

			pq.add(pair);
			result.put(vname, pair);
		}

		while (pq.size() > 0) {
			// 1. remove
			DPair rp = pq.remove();

			if (visited.contains(rp.vname) == true) {
				continue;
			}
			visited.add(rp.vname);

			// 2. loop nbrs
			for (String nbrname : vces.get(rp.vname).keySet()) {
				DPair np = result.get(nbrname);

				String newpath = rp.psf + nbrname;
				int newcost = rp.csf + vces.get(rp.vname).get(nbrname);

				if (newcost < np.csf) {
					DPair nnp = new DPair(nbrname, newpath, newcost);
					pq.add(nnp);
					result.put(nbrname, nnp);

				}
			}
		}

		System.out.println(result);
	}

	private class PPair implements Comparable<PPair> {
		String vname;
		String pname;
		int csf;

		PPair(String vname, String pname, int csf) {
			this.vname = vname;
			this.pname = pname;
			this.csf = csf;
		}

		@Override
		public int compareTo(PPair o) {
			return this.csf - o.csf;
		}

		public String toString() {
			return "[" + this.pname + "@" + this.csf + "]";
		}
	}

	public Graph prims() {
		Graph mst = new Graph();

		GenericHeap<PPair> pq = new GenericHeap<>();
		HashMap<String, PPair> map = new HashMap<>();

		for (String vname : vces.keySet()) {
			PPair pair = new PPair(vname, null, Integer.MAX_VALUE);
			pq.add(pair);
			map.put(vname, pair);
		}

		while (pq.size() > 0) {
			PPair rp = pq.remove();

			// add in mst
			mst.addVertex(rp.vname);
			if (rp.pname != null) {
				mst.addEdge(rp.vname, rp.pname, rp.csf);
			}

			// loop in nbrs
			for (String nbrname : vces.get(rp.vname).keySet()) {
				if (mst.containsVertex(nbrname)) {
					continue;
				}

				PPair np = map.get(nbrname);

				int newcost = vces.get(rp.vname).get(nbrname);
				String pname = rp.vname;

				if (newcost < np.csf) {
					np.csf = newcost;
					np.pname = pname;
					pq.updatePriority(np);
				}
			}
		}

		return mst;
	}

}
