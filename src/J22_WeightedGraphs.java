import java.util.*;

class AdjWeightedDirectedGraph {
    AdjWeightedGraphNode[] nodes;

    public AdjWeightedDirectedGraph(int vertices) {
        this.nodes = new AdjWeightedGraphNode[vertices];
    }

    static class AdjWeightedGraphNode{
        int vertex;
        int weight;

        public AdjWeightedGraphNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        AdjWeightedGraphNode next;
    }

    void addEdge(int parent,int child, int w){
        //parent->child
        AdjWeightedGraphNode temp = new AdjWeightedGraphNode(child,w);
        temp.next = nodes[parent];
        nodes[parent] = temp;

        //Note: add child-->parent side for undirected
    }

    static int[] dijkstra(AdjWeightedDirectedGraph directedGraph, int sourceVertex){
        int[] shortpath = new int[directedGraph.nodes.length]; //Note: in next same algo I used priority queue for short path storage for getting always smallest distance & removing visited
        Arrays.fill(shortpath,Integer.MAX_VALUE);
        int unvisited_C = shortpath.length;

        boolean[] visited = new boolean[shortpath.length];
        shortpath[sourceVertex] = 0;

        while (unvisited_C!=0){
            AdjWeightedDirectedGraph.AdjWeightedGraphNode temp = directedGraph.nodes[sourceVertex];


            while (temp!=null){
                if (!visited[temp.vertex]){


                    //Below logic name: relaxation(Can I reach this neighbor cheaper through my current vertex)
                    int cur_path = temp.weight + shortpath[sourceVertex];
                    if (cur_path<shortpath[temp.vertex]){
                        shortpath[temp.vertex] = cur_path;
                    }



                }

                temp = temp.next;
            }
            visited[sourceVertex] = true;
            unvisited_C--;
            int short_temp = Integer.MAX_VALUE;

            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]){
                    if (short_temp > shortpath[i]){
                        sourceVertex = i;
                        short_temp  = shortpath[i];
                    }
                }
            }
            if (short_temp == Integer.MAX_VALUE) { //for disconnected as max of disconnected will always be Integer.MAX value, so if even one time that min distance is Interger.MAX then it means all connected are already visited
                break;
            }

        }




        return shortpath;
    }


    static int[] biilmanFord(AdjWeightedDirectedGraph directedGraph, int sourceVertex){
        int[] shortpath = new int[directedGraph.nodes.length];
        Arrays.fill(shortpath,Integer.MAX_VALUE);
        shortpath[sourceVertex] = 0;
        for (int j = 0; j < shortpath.length - 1; j++) { //Because a newly discovered distance may come too late in the current vertex order to propagate further, we repeat the whole edge scan V−1 times.
            for (int i = 0; i < shortpath.length; i++) {

                AdjWeightedDirectedGraph.AdjWeightedGraphNode temp =
                        directedGraph.nodes[i];

                while (temp != null) {

                    if (shortpath[i] != Integer.MAX_VALUE &&
                            shortpath[temp.vertex] >
                                    shortpath[i] + temp.weight) {

                        shortpath[temp.vertex] =
                                shortpath[i] + temp.weight;
                    }

                    temp = temp.next;
                }
            }
        }
        return  shortpath;
    }
    static int[] biilmanFordWithNegaticeCycleDetection(AdjWeightedDirectedGraph directedGraph, int sourceVertex){
        int[] shortpath = new int[directedGraph.nodes.length];
        Arrays.fill(shortpath,Integer.MAX_VALUE);
        shortpath[sourceVertex] = 0;
        for (int j = 0; j < shortpath.length ; j++) { //running +1 times to check if values still change, if yes it means negative cycle
            for (int i = 0; i < shortpath.length; i++) {

                AdjWeightedDirectedGraph.AdjWeightedGraphNode temp =
                        directedGraph.nodes[i];

                while (temp != null) {

                    if (shortpath[i] != Integer.MAX_VALUE &&
                            shortpath[temp.vertex] >
                                    shortpath[i] + temp.weight) {

                        shortpath[temp.vertex] =
                                shortpath[i] + temp.weight;

                        if (j==shortpath.length-1){
                            System.out.println("negative Cycle detected");
                            return new int[]{};

                        }
                    }

                    temp = temp.next;
                }
            }
        }
        return  shortpath;
    }

    static Deque<Integer> dijkstraAtoB(AdjWeightedDirectedGraph directedGraph, int sourceVertex, int destination){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //combination of distance , node and only distance decides priority,



        int[] shortpath = new int[directedGraph.nodes.length];
        int[] parent = new int[directedGraph.nodes.length];
        Arrays.fill(parent,-1);
        Arrays.fill(shortpath,Integer.MAX_VALUE);

        shortpath[sourceVertex] = 0;
        boolean[] visited = new boolean[shortpath.length];
        pq.add(new int[]{0,sourceVertex});

        while (!pq.isEmpty()){
            int val =  pq.poll()[1];;
            if (visited[val]) { //if old data ie repeated data  polled then skipped
                continue;
            }
            AdjWeightedDirectedGraph.AdjWeightedGraphNode temp =
                    directedGraph.nodes[val];


            while (temp!=null){
                if (!visited[temp.vertex]){


                    int cur_path = temp.weight + shortpath[val];
                    if (cur_path<shortpath[temp.vertex]){
                        shortpath[temp.vertex] = cur_path;
                        parent[temp.vertex]= val;
                        pq.add(new int[]{cur_path,temp.vertex}); // add new that is doesn't remove old data

                    }



                }

                temp = temp.next;
            }
            visited[val] = true;



            if (val== destination){
                break;
            }



        }


        Deque<Integer> stack = new ArrayDeque<>();
        int current = destination;
        if (shortpath[destination] == Integer.MAX_VALUE) { //if destination unreachable
            return new ArrayDeque<>();
        }
        while (current != -1) {
            stack.push(current);
            current = parent[current];
        }

        return  stack;

    }

}


public class J22_WeightedGraphs {
    static void main() {
        //Shortest Path
            //1. Dijkstra: Weighted Graph (+ve Edges Allowed)
                AdjWeightedDirectedGraph dijkstraGraph =
                        new AdjWeightedDirectedGraph(5);

                dijkstraGraph.addEdge(0, 1, 4);
                dijkstraGraph.addEdge(0, 2, 1);
                dijkstraGraph.addEdge(2, 1, 2);
                dijkstraGraph.addEdge(1, 3, 1);
                dijkstraGraph.addEdge(2, 3, 5);
                dijkstraGraph.addEdge(3, 4, 3);

        //2. Bellman-Ford: Weighted Graph (+ve, -ve Edges Allowed)
                //doesn't work with negative cycles
                AdjWeightedDirectedGraph bellmanGraph =
                        new AdjWeightedDirectedGraph(5);

                bellmanGraph.addEdge(0, 1, 6);
                bellmanGraph.addEdge(0, 2, 7);
                bellmanGraph.addEdge(1, 2, 8);
                bellmanGraph.addEdge(1, 3, 5);
                bellmanGraph.addEdge(1, 4, -4);
                bellmanGraph.addEdge(2, 3, -3);
                bellmanGraph.addEdge(2, 4, 9);
                bellmanGraph.addEdge(3, 1, -2);
                bellmanGraph.addEdge(4, 0, 2);
                bellmanGraph.addEdge(4, 3, 7);

    }



}
