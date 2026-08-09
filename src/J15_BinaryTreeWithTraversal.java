 class NodeBT{
    int data;
    NodeBT left;
    NodeBT right;
    NodeBT(int data) {
        this.data = data;
    }

    //root-->left-->right
    static void preorderTraversal(NodeBT root){
        if (root==null){
            return;
        }
        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);


    }

     //left-->root->right
     static void inorderTraversal(NodeBT root){
         if (root==null){
             return;
         }
         inorderTraversal(root.left);
         System.out.println(root.data);
         inorderTraversal(root.right);

     }


     //left-->right-->root
     static void postTraversal(NodeBT root){
         if (root==null){
             return;
         }
         postTraversal(root.left);
         postTraversal(root.right);
         System.out.println(root.data);

     }
}

public class J15_BinaryTreeWithTraversal {
    static void main() {
        NodeBT root = new NodeBT(10);

        root.left = new NodeBT(5);
        root.right = new NodeBT(20);
        root.left.left = new NodeBT(3);
        root.left.right = new NodeBT(8);
        root.right.right = new NodeBT(25);

        System.out.println("Preorder");
        NodeBT.preorderTraversal(root);
        System.out.println("Inorder");
        NodeBT.inorderTraversal(root);
        System.out.println("Postorder");
        NodeBT.postTraversal(root);



    }

}
