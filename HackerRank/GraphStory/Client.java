package GraphStory;

public class Client {
	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 10);
		graph.addEdge("C", "D", 10);
		graph.addEdge("A", "D", 40);
		graph.addEdge("D", "E", 2);
		graph.addEdge("C", "F", 8);
		graph.addEdge("E", "F", 3);
		graph.addEdge("F", "G", 3);
		graph.addEdge("E", "G", 8);

		//graph.display();
		//graph.removeVertex("D");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		// graph.display();
		//System.out.println(graph.hasPath("A", "G"));
		graph.printAllPaths("A", "G");
		System.out.println("-----------");
		graph.multisolver("A", "G" , 3, 47);
	}
}
