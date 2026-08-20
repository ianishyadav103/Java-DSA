
// ================= GRAPH =================
//
// Graph = collection of Nodes (Vertices) + Edges (connections).


// ================= TYPES =================
//
// 1. Undirected Graph
// Edge has no direction.
// A --- B  → A connected to B and B connected to A.
//
// 2. Directed Graph
// Edge has direction.
// A ---> B  → A to B only.
//
// 3. Weighted Graph
// Edges have a value/weight.
// A --10-- B
//
// 4. Unweighted Graph
// Edges have no weight.
//
// 5. Connected Graph
// Every node is reachable from every other node.
//
// 6. Disconnected Graph
// It has separate parts/components.
//
// 7. Cyclic Graph
// Contains a cycle.
//
// 8. Acyclic Graph
// Contains no cycle.
//
// 9. Complete Graph
// Every node is directly connected to every other node.
//
//
// ================= BASIC TERMS =================
//
// Vertex / Node → Element of graph.
// Edge          → Connection between two nodes.
//
// Degree → Number of edges connected to a node.
//
// In-degree → Number of edges coming INTO a node.
// Out-degree → Number of edges going OUT of a node.
//
// Neighbor → Directly connected node.
//
// Path → Sequence of connected nodes.
//
// Cycle → Path that starts and ends at the same node.
//
//
// ================= REPRESENTATION =================
//
// 1. Adjacency Matrix → 2D array.
//
// 2. Adjacency List → Each node stores its neighbors.
//
//
// IMPORTANT:
// Tree = special type of Graph
// Tree is connected + acyclic.


//ADJACENCY MATRIX Implementation
class UndirectedGraphAdjacencyMatrix{ //can be directed if notes applied
    //1 if edge exist else 0

     int[][] adjMatrix;
     int vertices;

    public UndirectedGraphAdjacencyMatrix(int vertices) {
        this.adjMatrix = new int[vertices][vertices];
        this.vertices = vertices;
    }

    public void addEdge(int u,int v){
        if (u >= vertices || v>=vertices){
            System.out.println("Invalid edge, Add Failed");
            return;
        }
        adjMatrix[u][v] = 1; //undirected graph, the matrix is symmetric: i.e. matrix[u][v] = matrix[v][u]
        adjMatrix[v][u] = 1;

        //Note: if directed then only specified is set 1
    }

    void removeEdge(int u, int v) {
        adjMatrix[u][v] = 0;
        adjMatrix[v][u] = 0;
        //Note: if directed then only specified is set 0
    }
    boolean hasEdge(int u, int v) {
        return adjMatrix[u][v] == 1;
    }
    void display() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("     v"+i);
        }
        System.out.println();
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (j==0){
                    System.out.print(" v"+i+"  ");
                }
                System.out.print(adjMatrix[i][j] + "      ");
            }
            System.out.println();
        }}

}

//ADJACENCY LIST Implementation using ll (commonly arraylist used)

class AdjListLLUndirectedGraph{
     int vertices;
    class AdjListLLNode{
        int vertex;
        AdjListLLNode next;
        AdjListLLNode(int vertex) {
            this.vertex = vertex;
        }
    }
     AdjListLLNode[] edgenodes;

    public AdjListLLUndirectedGraph(int vertices ) {
        this.vertices = vertices;
        edgenodes = new AdjListLLNode[vertices];
    }
    public void addEdge(int u,int v){
       //u-->v   //Node: if undirected then set only specified not twice like in this for v-->u
        AdjListLLNode newnode = new AdjListLLNode(v);
        newnode.next  =  edgenodes[u];
        edgenodes[u] = newnode;

        // v → u
        newnode = new AdjListLLNode(u);
        newnode.next = edgenodes[v];
        edgenodes[v] = newnode;



    }
    public void deleteEdge(int u, int v){

        // Remove v from u's list
    AdjListLLNode curr  = edgenodes[u];
    AdjListLLNode prev  = null;

    while (curr!=null){
        if (curr.vertex==v){
         if (prev==null){
             //v is first node
             edgenodes[u] = curr.next;
             break;
         }
         else {
             prev.next = curr.next;
             break;
         }

        }
        prev = curr;
        curr = curr.next;

    }


        // Remove u from v's list
        curr  = edgenodes[v];
       prev  = null;

        while (curr!=null){
            if (curr.vertex==u){
                if (prev==null){
                    //u is first node
                    edgenodes[v] = curr.next;
                    break;
                }
                else {
                    prev.next = curr.next;
                    break;
                }

            }
            prev = curr;
            curr = curr.next;

        }
    }

    public void display(){
        for(int i =0;i<vertices;i++){
            AdjListLLNode temp = edgenodes[i];
            System.out.print("V"+ i);
            while (temp!=null){
                System.out.print("-->" + temp.vertex );
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
class AdjListLLDirectedGraph{
    int vertices;
    class AdjListLLNode{
        int vertex;
        AdjListLLNode next;
        AdjListLLNode(int vertex) {
            this.vertex = vertex;
        }
    }
    AdjListLLNode[] edgenodes;

    public AdjListLLDirectedGraph(int vertices ) {
        this.vertices = vertices;
        edgenodes = new AdjListLLNode[vertices];
    }
    public void addEdge(int u,int v){
        AdjListLLNode newnode = new AdjListLLNode(v);
        newnode.next  =  edgenodes[u];
        edgenodes[u] = newnode;




    }}

public class J19_Graphs {
    static void main() {
        UndirectedGraphAdjacencyMatrix ugam1 = new UndirectedGraphAdjacencyMatrix(3);
        ugam1.addEdge(0,1);
        ugam1.addEdge(0,2);
        ugam1.display();



        AdjListLLUndirectedGraph g = new AdjListLLUndirectedGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.display();
        g.deleteEdge(0, 1);
        g.display();

    }
}