BAIBATYR MIRAS IT-2502
Project Overview
This project implements a Graph data structure and fundamental traversal algorithms using Java. The graph consists of Vertices, representing data points, and Edges, which act as connections between them. The main objective is to study graph representation through an Adjacency List and analyze the performance of BFS and DFS algorithms.
The project is built on Object-Oriented Programming principles and includes the following classes:
Vertex: Represents an individual graph node with a unique numerical ID.
Edge: Represents a connection between two nodes, storing source and destination information.
Graph: The core class that stores the structure using an Adjacency List (Map). This ensures memory efficiency.
Experiment: Handles testing on graphs of different sizes (10, 30, and 100 vertices) and measures execution time in nanoseconds.
Main: The entry point of the program that initiates all experimental runs.

Breadth-First Search (BFS)
Logic: The algorithm explores the graph layer by layer. It starts from a selected vertex, visits all its immediate neighbors, and then moves to the next level. A Queue (FIFO) data structure is used to track the visiting order.
Complexity: O(V + E), where V is the number of vertices and E is the number of edges.

Depth-First Search (DFS)
Logic: The algorithm attempts to go as deep as possible down one branch of the graph before backtracking. It is implemented using recursion.
Complexity: O(V + E).

<img width="495" height="453" alt="image" src="https://github.com/user-attachments/assets/7d693e97-a017-4a7f-bd35-2a58deb5f4f5" />


<img width="377" height="117" alt="image" src="https://github.com/user-attachments/assets/011c1da1-3766-4c77-af10-5819a129de45" />


<img width="350" height="128" alt="image" src="https://github.com/user-attachments/assets/1a39c786-a002-46a6-8631-8fc1000b056d" />
