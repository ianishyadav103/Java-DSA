import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class MSTAlgo{

    static int prim(WeightedAdjListLLUndirectedGraph graph, int sourceVertex) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[] visited =
                new boolean[graph.edgenodes.length];

        int totalWeight = 0;
        int vertexCount = 0;

        // {edge weight, vertex}
        pq.add(new int[]{0, sourceVertex});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int weight = current[0];
            int vertex = current[1];

            // Already part of MST
            if (visited[vertex]) {
                continue;
            }

            // Add vertex to MST
            visited[vertex] = true;
            vertexCount++;

            // Edge used to reach this vertex
            totalWeight += weight;

            // Add all edges leaving this vertex
            WeightedAdjListLLUndirectedGraph.WeightedAdjListLLNode temp =
                    (WeightedAdjListLLUndirectedGraph.WeightedAdjListLLNode)
                            graph.edgenodes[vertex];

            while (temp != null) {

                if (!visited[temp.vertex]) {
                    pq.add(new int[]{
                            temp.weight,
                            temp.vertex
                    });
                }

                temp = (WeightedAdjListLLUndirectedGraph.WeightedAdjListLLNode)
                        temp.next;
            }
        }

        // Graph was disconnected
        if (vertexCount != graph.edgenodes.length) {
            return -1;
        }

        return totalWeight;
    }
    static int kruskal(WeightedAdjListLLUndirectedGraph graph){
        ArrayList<J23_MST.Edge> edges = J23_MST.getEdges(graph);

        // sorting of edges by weight
        edges.sort(Comparator.comparingInt(a -> a.weight));
        DSU dsu = new DSU(graph.edgenodes.length);

        int totalWeight = 0;
        int edgeCount = 0;

        for (J23_MST.Edge edge : edges) {

            // Are u and v already connected?
            if (dsu.find(edge.u) != dsu.find(edge.v)) {

                // No cycle → take edge
                dsu.union(edge.u, edge.v);

                totalWeight += edge.weight;
                edgeCount++;

                // MST has V - 1 edges
                if (edgeCount == graph.edgenodes.length - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }
    }





//Kruskal helper ds
class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }


        return find(parent[x]);
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
public class J23_MST {
    static void main() {

/*
->Spanning Tree:
    -->Contains all vertices
    -->Has exactly V − 1 edges
    -->Has no cycle
    -->Connects the entire graph

->Minimum ST: A spanning tree with the minimum total edge weight.


*/



    }

// 1. Prim's Algorithm:
    // Add all edges from the current MST to unvisited neighbors into a PriorityQueue.
    // Select the smallest edge from all available edges in the PQ(including edges added from previously visited vertices)
    // then add that new vertex to the MST.

// 2. Kruskal's Algorithm:
    // Sort all edges by weight and keep taking the cheapest edge,
    // but never allow a cycle.
    // Uses Disjoint Set Union (DSU) to track connected components.

    //krushkal helper function

    static class Edge {

        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }}
    static ArrayList<Edge> getEdges(
            WeightedAdjListLLUndirectedGraph graph) {

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < graph.edgenodes.length; i++) {

            WeightedAdjListLLUndirectedGraph.WeightedAdjListLLNode temp =
                    (WeightedAdjListLLUndirectedGraph.WeightedAdjListLLNode)
                            graph.edgenodes[i];

            while (temp != null) {

                // Take edge only once(as stored twice)
                if (i < temp.vertex) {
                    edges.add(
                            new Edge(i, temp.vertex, temp.weight)
                    );
                }

                temp = (WeightedAdjListLLUndirectedGraph.WeightedAdjListLLNode)
                        temp.next;
            }
        }

        return edges;
    }
}
