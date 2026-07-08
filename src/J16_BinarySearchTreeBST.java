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

    static NodeBT insert(NodeBT root,int value){
        if (root == null){
            return new NodeBT(value);
        } else if (value<= root.data) {
         root.left = insert(root.left,value);
        }
        else {
         root.right = insert(root.right,value);
        }
    return root;
    }

    void delete(int val) { }

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
            BST.insert(obj,14);

            NodeBT.preorderTraversal(obj);

            System.out.println(BST.max(obj).data);
            System.out.println(BST.min(obj).data);


        }


    }

