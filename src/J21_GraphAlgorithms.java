import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

class GraphAlgorithms{
    /*
    Topological Sort
    -->A  is an ordering of vertices in a directed graph such that:
    -->For every edge A → B, A comes before B.
    --> works on Only Directed Acyclic Graphs(DAGs)
     */
    static void toposortDFSMethod(Stack<Integer> stack,int vertex,AdjListLLDirectedGraph graph,boolean[] visited){
        //logic: when all neighbors of current vertex are visited then push to stack/.


        visited[vertex] = true;
        AdjListLLDirectedGraph.AdjListLLNode temp = graph.edgenodes[vertex];
        while (temp!=null){
            if (!visited[temp.vertex]){
                toposortDFSMethod(stack,temp.vertex,graph,visited);

            }
            temp = temp.next;
        }
        stack.push(vertex);

    }

    //outer function for disconnected
    static void connectedtoposortDFS(AdjListLLDirectedGraph graph){
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < graph.edgenodes.length; i++) {
            if (!visited[i]){
                toposortDFSMethod(st,i,graph,visited);

            }
        }
        while (!st.empty()){
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    static void topoSortBFSKahnAlgo(AdjListLLDirectedGraph graph){
        int[] result = new int[graph.vertices];
        Queue<Integer> que = new ArrayDeque<>();
        int[] indegree = new int[graph.vertices];
        for (int i= 0;i<indegree.length;i++){
            AdjListLLDirectedGraph.AdjListLLNode temp = graph.edgenodes[i];
            while (temp!=null){
                indegree[temp.vertex]++;
                temp = temp.next;
            }

        }
        for (int i= 0;i<indegree.length;i++){
            if (indegree[i]==0){
                que.add(i);
            }
        }
        int j=0;
        while (!que.isEmpty()){


                int cur = que.poll();
                result[j++]=cur;

                AdjListLLDirectedGraph.AdjListLLNode temp = graph.edgenodes[cur];
                while (temp!=null){
                    indegree[temp.vertex]--;
                    if (indegree[temp.vertex]==0){
                        que.add(temp.vertex);
                    }
                    temp = temp.next;
                }



        }

        if (j != graph.vertices) {
            System.out.println("Cycle detected");
            return;
        }

        System.out.println(Arrays.toString(result));
    }
    //All vertex distance rom source
    static void shortestDistanceForALLBFS(AdjListLLDirectedGraph graph,int start){
        Queue<Integer> to_visit = new ArrayDeque<>();
        int[] distance = new int[graph.vertices];;
        Arrays.fill(distance, -1);  //if discnnedted then use this so -1 for unreachable

        boolean[] visited = new boolean[graph.vertices];

        int vertex = start;
        to_visit.add(vertex);
        visited[vertex] = true;
        distance[start] = 0;
        while (!to_visit.isEmpty()){
            vertex = to_visit.poll();
            AdjListLLDirectedGraph.AdjListLLNode temp = graph.edgenodes[vertex];
            while (temp!=null){
                if (!visited[temp.vertex]){
                    to_visit.add(temp.vertex);
                    visited[temp.vertex] = true;
                    distance[temp.vertex] =
                            distance[vertex] + 1;
                }
                temp = temp.next;
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    //Shorted path from A to B
        static void shortestPathBFS(AdjListLLDirectedGraph graph,int start,int dest){
        boolean found = false;
            Queue<Integer> to_visit = new ArrayDeque<>();
            int[] distance = new int[graph.vertices];
            Arrays.fill(distance, -1);
            boolean[] visited = new boolean[graph.vertices];
            int[] parent = new int[graph.vertices];
            Arrays.fill(parent, -1);

            int vertex = start;
            to_visit.add(vertex);
            visited[vertex] = true;
            distance[start] = 0;
            while (!to_visit.isEmpty() && !found){
                vertex = to_visit.poll();
                AdjListLLDirectedGraph.AdjListLLNode temp = graph.edgenodes[vertex];
                while (temp!=null){
                    if (!visited[temp.vertex]){
                        parent[temp.vertex] = vertex; //who discovered me (automatically who discovered me first)

                        distance[temp.vertex] = distance[vertex] + 1;
                        to_visit.add(temp.vertex);
                        visited[temp.vertex] = true;
                        if (dest == temp.vertex){ //if we dont break then using path we can get shortest path of all
                            found = true;
                            break;
                        }



                    }
                    temp = temp.next;
                }
            }
            if (distance[dest] == -1) {
                System.out.println("No path exists");
                return;
            }

            // Print shortest distance
            System.out.println("Distance: " + distance[dest]);

            int current = dest;
            while (current != -1) { //-1 to stop at start(no one discovered it) //can use start also with additional start print
                System.out.print(current + " ");
                current = parent[current];
            }

            System.out.println();

        }

}

public class J21_GraphAlgorithms {
    static void main() {
        //Topological Sort
            //1. DFS Method
            AdjListLLDirectedGraph g = new AdjListLLDirectedGraph(7);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 3);

            g.addEdge(4, 5);
            g.addEdge(4, 6);


            GraphAlgorithms.connectedtoposortDFS(g);
            //2. Kan'h Method
            GraphAlgorithms.topoSortBFSKahnAlgo(g);

       //Shortest Parth
        //1. BFS
        GraphAlgorithms.shortestDistanceForALLBFS(g,0);
        GraphAlgorithms.shortestPathBFS(g,0,3);


    }
}
