// 1. Node Class
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// 2. Binary Search Tree Class
class BinarySearchTree {
    // Root of the BST
    Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Public method to insert a new key.
     * Starts the recursive insertion from the root.
     */
    void insert(int key) {
        root = insertRec(root, key);
    }

    /**
     * A recursive function to insert a new key in BST.
     * @param root The current node in the tree (initially the root of the whole tree).
     * @param key The value to insert.
     * @return The updated root of the subtree.
     */
    Node insertRec(Node root, int key) {
        // If the tree is empty or we've found the correct spot, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // If key is equal, it's typically ignored (no duplicates)

        // Return the (unchanged) node pointer
        return root;
    }

    /**
     * Public method to search for a key.
     * Starts the recursive search from the root.
     */
    boolean search(int key) {
        return searchRec(root, key);
    }

    /**
     * A recursive function to search for a key in BST.
     * @param root The current node in the tree.
     * @param key The value to search for.
     * @return true if the key is found, false otherwise.
     */
    boolean searchRec(Node root, int key) {
        // Base Cases: Root is null (not found) or key is present at root
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }

        // Value is smaller than root's key, search in left subtree
        if (key < root.key) {
            return searchRec(root.left, key);
        } 
        // Value is larger than root's key, search in right subtree
        else {
            return searchRec(root.right, key);
        }
    }

    /**
     * Public method to perform Inorder Traversal (prints keys in sorted order).
     * Starts the recursive traversal from the root.
     */
    void inorder() {
        inorderRec(root);
        System.out.println(); // For a clean newline after printing
    }

    /**
     * A recursive function to perform inorder traversal.
     * Inorder traversal visits: Left Subtree -> Root -> Right Subtree
     * @param root The current node in the tree.
     */
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

// 3. Main Class for Testing
public class BST_Implementation {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder Traversal (Sorted order): ");
        tree.inorder(); // Expected: 20 30 40 50 60 70 80

        // Search for elements
        int key1 = 40;
        System.out.println("Searching for " + key1 + ": " + tree.search(key1)); // Expected: true

        int key2 = 90;
        System.out.println("Searching for " + key2 + ": " + tree.search(key2)); // Expected: false
    }
}
