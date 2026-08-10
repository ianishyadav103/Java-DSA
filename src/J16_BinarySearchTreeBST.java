class BST{
    static void insertIterative(int val,NodeBT root) {
        if (root==null){
            System.out.println("Create root node first");
            return;
        }
        NodeBT temp = root;
        NodeBT tempPrev = root;
        while (temp!=null){
            tempPrev = temp;
        if (val<= temp.data) { //considering duplicate
            temp = temp.left;
        }
        else {
            temp = temp.right;
        }}
        temp = new NodeBT(val);
        if (val<= tempPrev.data){
            tempPrev.left = temp;
        }
        else {
            tempPrev.right = temp;
        }
    }

    static NodeBT insertUsingRecursion(NodeBT root,int value){
        //I don't like this recursion unwinding after assigning which is unnecessary.
        if (root == null){
            return new NodeBT(value);
        } else if (value<= root.data) {
         root.left = insertUsingRecursion(root.left,value);

        }
        else {
         root.right = insertUsingRecursion(root.right,value);
        }
    return root;
    }

    //Search
    static NodeBT bstSearch(int val,NodeBT root){
        if (root ==null){
            System.out.println("Not found, returning null");
            return null;
        }
         if ( val==root.data ){
            System.out.println("Found");
            return root;
        }
        else if (val<root.data) {
            return bstSearch(val,root.left);

        }
        else {
            return bstSearch(val,root.right);
        }


    }



    //DELETE: Two ways: what replaces deleted node:-
    // -->Predecessor   → maximum of left subtree
    //OR
    // -->Successor     → minimum of right subtree
    NodeBT delete(NodeBT root,int val) {
        if (root == null){
            System.out.println("No data in BST, cant delete");
            return null;
        }

        //finding node to be deleted and its parent
        NodeBT delete_par = null;
        NodeBT delete_node = root;
        while (delete_node!=null && delete_node.data!=val){
            delete_par = delete_node;
            if (val<delete_node.data){
                delete_node = delete_node.left;
            }
            else {
                delete_node = delete_node.right;
            }

        }
    if (delete_node ==null){
        System.out.println("Delete failed, no data found");
        return root;

    }
    if (delete_node.left!=null && delete_node.right!=null){
        NodeBT leftmostPar = delete_node;
        NodeBT leftmostNode = delete_node.right;
        while (leftmostNode.left!=null){
            leftmostPar = leftmostNode;
            leftmostNode = leftmostPar.left;
        }
        root.data = leftmostNode.data;
        if (leftmostPar==delete_node){
            leftmostPar.right = leftmostNode.right;
        }
        else {
            leftmostPar.left = leftmostNode.right;

        }

        return  root;
    }

    //this tells whether 0 or 1 children: 0 if child null
    NodeBT child; //either left or right or null is assigned to child
    if (delete_node.left != null){
        child = delete_node.left;
        
    }else {
        child = delete_node.right;

    }



    //for root deletion for children < 2
    if (delete_par == null){
        return child;
    }

    //for non-root deletion for children < 2
    if (delete_par.left == delete_node){
        delete_par.left =child;
    }
    else {
        delete_par.right = child;
    }


   return root;

    }

    static NodeBT max(NodeBT node) {
        if (node.right==null){
            return node;
        }
        return max(node.right);
    }



    static NodeBT min(NodeBT node) {
        if (node.left==null){
            return node;
        }
        return min(node.left);
    }
}
    public class J16_BinarySearchTreeBST{
        static void main() {
            //All nodes in the Left Subtree must be strictly less than parent node.
            //All nodes in the Right Subtree must be strictly greater than the parent node.
            //Operations: O(log n):searching, deleting, insertion

            NodeBT obj = new NodeBT(13);
            BST.insertIterative(12,obj);
            BST.insertUsingRecursion(obj,14);

            NodeBT.preorderTraversal(obj);

            System.out.println(BST.max(obj).data);
            System.out.println(BST.min(obj).data);


        }


    }

