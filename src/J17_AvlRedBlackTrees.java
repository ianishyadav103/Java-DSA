class NodeAVL extends NodeBT{
    int height;
    public NodeAVL(int data) {
        super(data);
    }

}
class NodeRB extends NodeBT {
    boolean isRed;

    public NodeRB(int data) {
        super(data);
        isRed = true;
    }
}

// AVL TREE
// → Frequent searching / reading is required
// → You want a very strictly balanced BST
// → Fast lookup is more important than frequent insert/delete
// Examples:
// → In-memory databases / indexes
// → Applications with many search operations


// RED-BLACK TREE
// Use when:
// → Frequent insertion and deletion are required
// → You need a balanced BST but want fewer rotations
// → General-purpose ordered data structure
// Examples:
// → Java TreeMap
// → Java TreeSet


public class J17_AvlRedBlackTrees {

    // AVL
            // Self-balancing BST
            // Each node maintains extra info called Balance Factor: -1, 0, +1
            // Balance Factor = Height of Left Subtree - Height of Right Subtree
            // If Balance Factor becomes +2 or -2 → tree is unbalanced → rotation required
            // Four imbalance cases: LL, RR, LR, RL
            // LL → Right Rotation
            // RR → Left Rotation
            // LR → Left Rotation + Right Rotation
            // RL → Right Rotation + Left Rotation
            // Search, Insert, Delete → O(log n)


    // Red-Black Tree
            // Self-balancing BST
            // Each node has an extra property: RED or BLACK
            // Root is always BLACK
            // NULL/NIL leaves are considered BLACK
            // A RED node cannot have a RED child
            // Every path from a node to its NULL/NIL descendants has the same number of BLACK nodes
            // Balancing is done using Recoloring + Rotations
            // Less strictly balanced than AVL, but usually requires fewer rotations
            // Search, Insert, Delete → O(log n)


    static void main() {

    }
}
