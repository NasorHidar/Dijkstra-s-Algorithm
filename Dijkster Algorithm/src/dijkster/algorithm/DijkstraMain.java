package dijkster.algorithm;

public class DijkstraMain {

	public static void main(String[] args) {
		Graph graph = new Graph(6);

        // Add edges: graph.addEdge(from, to, weight)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 2);

        // Perform Dijkstra from node 0
        graph.dijkstra(0);
	}

}
