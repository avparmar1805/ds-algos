package july4;

import java.util.HashSet;

public class hamiltonianCycle {

	public static void main(String[] args) {
		Integer[][] graph = new Integer[7][7];
		
		graph[0][1] = 10;
		graph[1][0] = 10;
		
		graph[1][2] = 10;
		graph[2][1] = 10;
		
		graph[2][3] = 10;
		graph[3][2] = 10;
		
		graph[0][3] = 40;
		graph[3][0] = 40;
		
		graph[3][4] = 2;
		graph[4][3] = 2;
		
		graph[4][5] = 3;
		graph[5][4] = 3;
		
		graph[5][6] = 3;
		graph[6][5] = 3;
		
		graph[4][6] = 8;
		graph[6][4] = 8;
		
		graph[2][5] = 8;
		graph[5][2] = 8;
		
		hamiltonian(graph, 1, "1", 1, new HashSet<>());
	}
	
	private static void hamiltonian(Integer[][] graph, int src, String psf, int osrc, HashSet<Integer> visited){
		if(visited.size() == graph.length - 1){
			System.out.print(psf + " is a HP");
			if(graph[src][osrc] != null){
				System.out.println(" and a HC");
			} else {
				System.out.println();
			}
			return;
		}
		
		visited.add(src);
		for(int nbr = 0; nbr < graph.length; nbr++){
			if(graph[src][nbr] != null){
				if(!visited.contains(nbr)){
					hamiltonian(graph, nbr, psf + nbr, osrc, visited);
				}
			}
		}
		visited.remove(src);
	}

}
