package july4;

public class Client {

	public static void main(String[] args) {
		 Graph g = new Graph();
		 g.addVertex("A");
		 g.addVertex("B");
		 g.addVertex("C");
		 g.addVertex("D");
		 g.addVertex("E");
		 g.addVertex("F");
		 g.addVertex("G");
		
		 g.addEdge("A", "B", 10);
//		 g.addEdge("A", "C", 15);
		 g.addEdge("A", "D", 40);
		 g.addEdge("C", "B", 10);
		 g.addEdge("C", "D", 10);
//		 g.addEdge("C", "F", 5);
		 g.addEdge("D", "E", 2);
		 g.addEdge("E", "F", 3);
		 g.addEdge("E", "G", 8);
		 g.addEdge("F", "G", 3);
//		 g.djikstra("A");
		 
		 Graph mst = g.prims();
		 System.out.println("----------------------------------");
		 mst.display();
		 
//		 System.out.println(g.dfs("A", "G"));
//		 g.dft();
//		 System.out.println(g.gcc() + " " + g.IsConnected() + " " + g.IsCyclic() + " " + g.IsBipartite());
		
//		 System.out.println(g.hasPath("A", "G"));
//		 g.removeEdge("D", "E");
//		 System.out.println(g.hasPath("A", "G"));
//		 g.printAllPaths("A", "G");
//		 g.multisolver("A", "G", 45, 3);
	}

	
	
	public static void floodfill(int[][] arr, int[][] visited, int sr, int sc, String psf) {
		if (sr == arr.length - 1 && sc == arr[0].length - 1) {
			System.out.println(psf);
			return;
		}

		if (IsInvalid(arr, visited, sr, sc)) {
			return;
		}

		visited[sr][sc] = 1;
		floodfill(arr, visited, sr - 1, sc, psf + "T");
		floodfill(arr, visited, sr, sc + 1, psf + "R");
		floodfill(arr, visited, sr + 1, sc, psf + "D");
		floodfill(arr, visited, sr, sc - 1, psf + "L");
		visited[sr][sc] = 0;
	}

	private static boolean IsInvalid(int[][] arr, int[][] visited, int sr, int sc) {
		if (sr >= arr.length) {
			return true;
		} else if (sr < 0) {
			return true;
		} else if (sc >= arr[0].length) {
			return true;
		} else if (sc < 0) {
			return true;
		} else if (visited[sr][sc] == 1) {
			return true;
		} else if (arr[sr][sc] == 1) {
			return true;
		} else {
			return false;
		}
	}

}
