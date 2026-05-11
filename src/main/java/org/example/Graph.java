package org.example;
import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.putIfAbsent(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }
    public void addEdge(int from, int to) {
        if (vertices.containsKey(from) && vertices.containsKey(to)) {
            adjacencyList.get(from).add(new Edge(from, to));
            adjacencyList.get(to).add(new Edge(to, from));
        }
    }

    public void printGraph() {
        for (int vertexId : adjacencyList.keySet()) {
            System.out.print("Vertex" + vertexId + "is connected to:");
            for (Edge edge : adjacencyList.get(vertexId)) {
                System.out.print(edge.getDestination() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        if (!vertices.containsKey(start)) return;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean isSmallGraph = vertices.size() <= 10;

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (isSmallGraph) System.out.print(current + " ");

            for (Edge edge : adjacencyList.get(current)) {
                int neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        if (isSmallGraph) System.out.println();
    }

    public void dfs(int start) {
        if (!vertices.containsKey(start)) return;

        Set<Integer> visited = new HashSet<>();
        boolean isSmallGraph = vertices.size() <= 10;

        dfsRecursive(start, visited, isSmallGraph);
        if (isSmallGraph) System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited, boolean print) {
        visited.add(current);
        if (print) System.out.print(current + " ");

        for (Edge edge : adjacencyList.get(current)) {
            int neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, print);
            }
        }
    }

    public int getSize() {
        return vertices.size();
    }
}