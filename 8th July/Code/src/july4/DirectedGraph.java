package july4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import feb11.sortings;
import july2.GenericHeap;
import june12.oops.P;

public class DirectedGraph extends Graph {
	// directed diff
	public void removeVertex(String vname) {
		if (containsVertex(vname) == false) {
			return;
		}

		for (String nbrname : vces.keySet()) {
			removeEdge(nbrname, vname);
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

		return edges;
	}

	// directed diff
	public void addEdge(String v1name, String v2name, int weight) {
		if (containsEdge(v1name, v2name) == true) {
			return;
		}

		vces.get(v1name).put(v2name, weight);
	}

	// directed diff
	public void removeEdge(String v1name, String v2name) {
		if (containsEdge(v1name, v2name) == false) {
			return;
		}

		vces.get(v1name).remove(v2name);
	}

}
