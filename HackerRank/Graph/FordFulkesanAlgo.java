package Graph;

import java.util.HashSet;
import java.util.LinkedList;

public class FordFulkesanAlgo {
	public static void main(String args[]) {

		int[][] graph = { 
				{ 0, 10, 0, 8, 0, 0 }, 
				{ 0, 0, 5, 2, 0, 0 } ,
				{ 0, 5, 0, 0, 2, 7 } ,
				{ 8, 2, 0, 0, 10, 0 },
				{ 0, 0, 2, 10, 0, 10 },
				{ 0, 0, 7, 0, 10, 0 } 
				
		};
		
	}
	
	private static class Pair {
		public int vName;
		public int pName;
		
		Pair(int vName, int pName) {
			vName = vName;
			pName = pName;
		}
	}
	
//	public static boolean hasPath(int[][] graph, int src, int dest, int[] path) {
//		
//		boolean retVal = false;
//		
//		LinkedList<Pair> queue = new LinkedList<>();
//		HashSet<Integer> processed = new HashSet<>();
//		
//		queue.add(new Pair(src, -1));
//		
//		while(!queue.isEmpty()) {
//			Pair rp = queue.removeFirst();
//			
//			if(processed.contains(rp.vName)) {
//				continue;
//			}
//			
//			processed.add(rp.vName);
//		}
//	}
}
