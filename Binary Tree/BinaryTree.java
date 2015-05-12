
/**
 * Binary Tree Traversals
 * 
 * Depth-first Traversals all have complexity of O(n)
 *   Pre-order can make a complete duplicate of the binary tree. 
 *   In-order (Symmetric) commonly used on BST's because items are returned in order.
 *   Post-order while deleting/freeing nodes can delete or free an entire binary tree.
 */


public class BinaryTree {
    private Node root;

    private class Node {
        int key, value;
        Node left, right;

        public Node(Int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    public void preOrder(Node x) {
        // Display data of each call (current element)
        // Traverse left subtree recursively
        // Traverse right subtree recursively
        if (x == null) {
            return;
        }
        System.out.println(x.value);
        preOrder(x.left);
        preOrder(x.right);
    }

    public void inOrder(Node x) {
        // Traverse left subtree recursively
        // Display data of each call (current element)
        // Traverse right subtree recursively
        if (x == null) {
            return;
        }
        inOrder(x.left);
        System.out.println(x.value);
        inOrder(x.right);
    }

    public void postOrder(Node x) {
        // Traverse left subtree recursively
        // Traverse right subtree recursively
        // Display data of each call (current element)
        if (x == null) {
            return;
        }
        postOrder(x.left);
        postOrder(x.right);
        System.out.println(x.value);
    }
}