
/** 
 * Binary Search Tree implementation
 *
 * Search: Start at root note. If key is less, go left; if greater, go right; if equal, search hit.
 * Insert: Same as search, find location which fits value of key.
 * Delete: Hibbard deletion (not symmetric over many insertions/deletions due to choosing successor) or minimum deletion
 * Min/max: Start at root and go left/right depending on comparison of key to current key, stop when next node would be null.
 *
 * If N is inserted in random order, expected max height of tree is only 4 lg(n).
 * Average search: 1.4 lg(n), guaranteed n
 * Average insert: 1.4 lg(n), guaranteed n
 * Average delete: sqrt(n)
 */


public class BinarySearchTree {
    private Node root;

    private class Node {
        private int key;
        private int val;
        private Node left, right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public int get(int key) {
        Node x = root;
        while (x != null) {
            int comparison = compare(key, x.key);
            if (comparison < 0) {
                x = x.left;
            } else if (comparison > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    public void put(int key, int val) {
        // Recursive
        root = put(root, key, val);
    }

    private Node put(Node x, int key, int val) {
        // Create new node at root if tree is empty (root == null)
        // Create new node at proper position whenever current node is empty
        if (x == null) {
            return new Node(key, val);
        }

        int comparison = compare(key, x.key);
        if (comparison < 0) {
            x.left = put(x.left, key, val);
        } else if (comparison > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        // Return current node
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        // Stop once null link found
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        return x;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node x, int key) {
        if (x == null) {
            return null;
        }

        // Search for key
        int comparison = compare(key, x.key);
        if (comparison < 0) {
            delete(x.left, key);
        } else if (comparison > 0) {
            delete(x.right, key);
        } else {
            // No right child
            if (x.right == null) {
                return x.left;
            }
            // No left child
            if (x.left == null) {
                return x.right;
            }

            // Replace with successor
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private int compare(int v, int w) {
        if (v < w) {
            return -1;
        } else if (v > w) {
            return 1;
        } else {
            return 0;
        }
    }
}
