package dijkster.algorithm;

import java.util.*;

class Edge {
    int destination, weight;

    public Edge(int dest, int weight) {
        this.destination = dest;
        this.weight = weight;
    }
}

public class Graph {
    private int vertices;
    private List<List<Edge>> adjList;

    public Graph(int v) {
        this.vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add a directed edge (u -> v)
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(v, weight));
        // For undirected graph, also add:
        // adjList.get(v).add(new Edge(u, weight));
    }

    public void dijkstra(int start) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.destination;

            for (Edge edge : adjList.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Edge(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + i + " --> " + dist[i]);
        }
    }
}
