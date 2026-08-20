import java.util.LinkedList;
import java.util.Queue;

class GraphTraversalConnected{
    static void graphBFS(AdjListLLUndirectedGraph alg){
        boolean[] visited = new boolean[alg.vertices];
        Queue<Integer> to_visit = new LinkedList<>();
        int vertex = 0;
        to_visit.add(vertex); //give any node
        visited[vertex] = true;
        while (!to_visit.isEmpty()){
            vertex = to_visit.poll();
            System.out.print(vertex + " ");
            AdjListLLUndirectedGraph.AdjListLLNode temp = alg.edgenodes[vertex];
            while (temp!=null){
                int neighbour = temp.vertex;
                if (!visited[neighbour]){
                    to_visit.add(neighbour);
                    visited[neighbour] = true;
                }
                temp = temp.next;
            }
        }
    }

    static void graphmatrixBFS(int[][] graph) {

        boolean[] visited = new boolean[graph.length];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int vertex = queue.poll();

            System.out.println("V: " + vertex);

            // Find neighbors using matrix
            for (int i = 0; i < graph.length; i++) {

                if (graph[vertex][i] == 1 && !visited[i]) {

                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    static void graphDFS(AdjListLLUndirectedGraph alg,int vertex,boolean[] visited){
        visited[vertex] = true;
        System.out.println("V: "+vertex);
        AdjListLLUndirectedGraph.AdjListLLNode temp = alg.edgenodes[vertex];
        while (temp!=null){
            if (!visited[temp.vertex]){


                graphDFS(alg,temp.vertex,visited);
            }

            temp = temp.next;
        }
    }


    static void graphmatrixDFS(UndirectedGraphAdjacencyMatrix graph, int vertex, boolean[] visited){

        visited[vertex] = true;
        System.out.println("V: " + vertex);

        for (int i = 0; i < graph.adjMatrix.length; i++) {

            if (graph.adjMatrix[vertex][i] == 1 && !visited[i]) {

                graphmatrixDFS(graph, i, visited);
            }
        }
       
        
    }
}


class MoreGraphOperations{

      static void visitALlDFSConnectedComponents( AdjListLLUndirectedGraph alg){
          //A connected component is a group of vertices where every vertex can be reached from every other vertex in that group.
          //Logic:repeatedly perform BFS/DFS for every unvisited vertex from main vertex array

          boolean[] visitedArray = new boolean[alg.edgenodes.length];
        int j = 1;
          for (int i = 0; i < visitedArray.length; i++) {
              if (!visitedArray[i]){
                  System.out.println("Component "+j);

                  GraphTraversalConnected.graphDFS(alg,i,visitedArray);
                    j++;
              }
          }

    }

    static boolean cycleDetectionUndirectedGraphDFS( AdjListLLUndirectedGraph alg,int vertex,boolean[] visited,int parent){

            visited[vertex] = true;

            AdjListLLUndirectedGraph.AdjListLLNode temp = alg.edgenodes[vertex];
            while (temp!=null){
                if (visited[temp.vertex]){
                    if (!(parent==temp.vertex)){
                        System.out.println(
                                "Cycle detected: parent=" + parent +
                                        " current=" + vertex +
                                        " neighbor=" + temp.vertex
                        );
                        return true;

                    }


                }
                else {
                    if (cycleDetectionUndirectedGraphDFS(
                            alg,
                            temp.vertex,
                            visited,
                            vertex)) {

                        return true;
                    }
                }

                temp = temp.next;
            }
            return false;
        }

        static boolean cycleDetectionDirectedGraphDFS(AdjListLLDirectedGraph alg,int vertex,boolean[] visited,boolean[] path){
                visited[vertex] = true;
                path[vertex] = true;
                System.out.println("V: "+vertex);
                AdjListLLDirectedGraph.AdjListLLNode temp = alg.edgenodes[vertex];
                while (temp!=null){
                    if (!visited[temp.vertex]){
                        if (cycleDetectionDirectedGraphDFS(alg,temp.vertex,visited,path)){
                            return true;
                        }


                    } else if (path[temp.vertex]) {
                        System.out.println("Cycle Detected");
                        return true;
                    }
                    {

                    }

                    temp = temp.next;
                }
                path[vertex] = false;

                return false;
            }
    }

public class J20_GraphOperations {
    static void main() {
        AdjListLLUndirectedGraph gx = new AdjListLLUndirectedGraph(4);

        gx.addEdge(0, 1);
        gx.addEdge(0, 2);
        gx.addEdge(1, 3);
        gx.addEdge(2, 3);

        UndirectedGraphAdjacencyMatrix ugam1 = new UndirectedGraphAdjacencyMatrix(3);
        ugam1.addEdge(0,1);
        ugam1.addEdge(0,2);



        //BFS
        GraphTraversalConnected.graphBFS(gx);
        System.out.println();
        System.out.println();
        GraphTraversalConnected.graphmatrixBFS(ugam1.adjMatrix);
        System.out.println();


        //DFS
        boolean[] visited = new boolean[gx.vertices];
        GraphTraversalConnected.graphDFS(gx,0,visited);
        System.out.println();

        boolean[] visited2 = new boolean[ugam1.vertices];
        GraphTraversalConnected.graphmatrixDFS(ugam1,0,visited2);


        //Connected componenets demo usign dgs
        AdjListLLUndirectedGraph g = new AdjListLLUndirectedGraph(7);
                // Component 1
                        g.addEdge(0, 1);
                        g.addEdge(0, 2);
                        g.addEdge(1, 2);

                // Component 2
                g.addEdge(3, 4);
                g.addEdge(4, 5);

                // Component 3
                  // vertex 6 is isolated: size 7 in vertices

        MoreGraphOperations.visitALlDFSConnectedComponents(g);
        MoreGraphOperations.visitALlDFSConnectedComponents(g);

        //Graph Undirected Cycle test
        AdjListLLUndirectedGraph g1 =
                new AdjListLLUndirectedGraph(5);

        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);  // creates cycle
        g1.addEdge(3, 4);

        AdjListLLUndirectedGraph g2 =
                new AdjListLLUndirectedGraph(5);

        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);

        System.out.println( MoreGraphOperations.cycleDetectionUndirectedGraphDFS(g1,0,new boolean[g1.vertices],-1));
        System.out.println( MoreGraphOperations.cycleDetectionUndirectedGraphDFS(g2,0,new boolean[g2.vertices],-1));

        //Cycle Detection: Directed Group
        AdjListLLDirectedGraph g3 =
                new AdjListLLDirectedGraph(5);

        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 3);
        g3.addEdge(3, 1);   // creates cycle: 1 → 2 → 3 → 1

        AdjListLLDirectedGraph g4 =
                new AdjListLLDirectedGraph(5);

        g4.addEdge(0, 1);
        g4.addEdge(0, 2);
        g4.addEdge(1, 3);
        g4.addEdge(1, 4);


        System.out.println(MoreGraphOperations.cycleDetectionDirectedGraphDFS(g3,0,new boolean[g3.vertices],new boolean[g3.vertices]));
        System.out.println(MoreGraphOperations.cycleDetectionDirectedGraphDFS(g4,0,new boolean[g4.vertices],new boolean[g3.vertices]));


    }
}
