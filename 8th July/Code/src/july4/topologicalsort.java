package july4;

import java.util.HashSet;
import java.util.LinkedList;

public class topologicalsort {

	public static void main(String[] args) {
Integer[][] graph = new Integer[7][7];
		
		graph[0][1] = 10;
		graph[1][2] = 10;
		graph[2][3] = 10;
		graph[0][3] = 40;
		graph[4][3] = 2;
		graph[4][5] = 3;
		graph[5][6] = 3;
		graph[4][6] = 8;

		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Integer> stack = new LinkedList<>();
		for(int src = 0; src < graph.length; src++){
			if(visited.contains(src) == false){
				ts(graph, stack, visited, src);
			}
		}

		System.out.println(stack);
	}

	private static void ts(Integer[][] graph, LinkedList<Integer> stack, HashSet<Integer> visited, int src) {
		visited.add(src);
		for(int nbr = 0; nbr < graph.length; nbr++){
			if(graph[src][nbr] != null){
				if(!visited.contains(nbr)){
					ts(graph, stack, visited, nbr);
				}
			}
		}
		
		stack.addFirst(src);
	}

}
