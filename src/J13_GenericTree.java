import java.util.LinkedList;
import java.util.Queue;

class NodeGT{
    int data;
    NodeGT[] children;//if any number of children then use vector OR create new array manually

    public NodeGT(int data, int no_of_children) {
        this.children = new NodeGT[no_of_children];
        this.data = data;
    }

    void insert(int data,int max_children){


        for (int i=0; i < this.children.length; i++) {
            if (children[i]==null) {
                children[i] = new NodeGT(data, max_children);
                System.out.println("Insertion Complete");
                return;
            }}
            System.out.println("No place for child");


    }

    //Traversal: no inorder as no unique "middle" position for the root

    //like BFS preorder
    void dfsTraverseGT(){
        System.out.println(this.data);
        for (NodeGT child : children) {
            if (child!=null){
                child.dfsTraverseGT();

            }
        }}

    void dfsTraverseGTPostOrder(){

        for (NodeGT child : children) {
            if (child!=null){
                child.dfsTraverseGTPostOrder();


            }
        }
        System.out.println(this.data);}

    void bfsTraverseGT(){
        System.out.println("BFS");
        Queue<NodeGT> q = new LinkedList<>();
        q.add(this);
        while(!q.isEmpty()){
            NodeGT curr = q.poll();
            System.out.println(curr.data);

            for (int i = 0; i < curr.children.length; i++) {

                if (curr.children[i]!=null){
                    q.add(curr.children[i]);

                }
            }
        }
    }
}





public class J13_GenericTree {

    static void main() {
        NodeGT root  = new NodeGT(100,4);
        root.children[0] = new NodeGT(99,0);
        root.children[1] = new NodeGT(88,2);
        root.children[1].children[1] = new NodeGT(85,0);
        root.children[2] = new NodeGT(77,1);
        root.insert(11,0);
        root.children[1].insert(12,0);


        root.dfsTraverseGT();
        root.dfsTraverseGTPostOrder();
        root.bfsTraverseGT();

    }
}
