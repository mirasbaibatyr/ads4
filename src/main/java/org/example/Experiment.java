package org.example;

import java.util.Random;

public class Experiment {
    public void runMultipleTests() {
        int[] graphSizes = {10, 30, 100};

        for (int size : graphSizes) {
            Graph g = generateRandomGraph(size);
            runTraversals(g);
        }
    }
    private Graph generateRandomGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
        }
        for (int i = 0; i < size * 2; i++) {
            int u = rand.nextInt(size);
            int v = rand.nextInt(size);
            if (u != v) g.addEdge(u, v);
        }
        return g;
    }

    public void runTraversals(Graph g) {
        int size = g.getSize();
        System.out.println("=====================================");
        System.out.println("graph size: " + size + " vertices");

        if (size <= 10) {
            System.out.println("graph structure:");
            g.printGraph();
            System.out.print("BFS traversal order: ");
        }

        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();

        if (size <= 10) {
            System.out.print("DFS traversal order: ");
        }
        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();

        printResults("BFS", size, (endBfs - startBfs));
        printResults("DFS", size, (endDfs - startDfs));
        System.out.println();
    }
    public void printResults(String algorithm, int size, long timeNano) {
        System.out.println("time" + algorithm + " (size " + size + "): " + timeNano + " ns");
    }
}