package Graph;

public class CutVertex {
	public static void main(String args[]) {
		graph[0][1] = graph[0][1] = 1;
				
	}
	
	static int[][] graph = new int[6][6];
	static boolean[] visited;
	static boolean[] aps;
	static int[] parent;
	static int[] disc;
	static int[] low;
	static int time = 0;
	
	public static void depthFirst(int src) {
		visited[src] = true;
		disc[src] = low[src] = ++time;
		
		int counter = 0;
		
		for(int nbr = 0; nbr < graph.length; nbr++) {
			
		}
	}
}
