// Implements an AVL Tree, a self-balancing Binary Search Tree (BST).
public class AVLTree extends BinarySearchTree {

    // Helper method to get the height of a node
    private int getHeight(FileNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Perform a right rotation
    private FileNode rotateRight(FileNode y) {
        FileNode x = y.left;
        FileNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x; // Return new root
    }

    // Perform a left rotation
    private FileNode rotateLeft(FileNode x) {
        FileNode y = x.right;
        FileNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y; // Return new root
    }

    // Get the balance factor of a node
    private int getBalance(FileNode node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Overriding the insert method to maintain AVL Tree properties
    @Override
    public void insert(String name, int size) {
        root = insertRec(root, name, size);
    }

    // Recursive insert method with AVL balancing
    private FileNode insertRec(FileNode node, String name, int size) {
        if (node == null) return new FileNode(name, size);

        if (name.compareTo(node.name) < 0) {
            node.left = insertRec(node.left, name, size);
        } else if (name.compareTo(node.name) > 0) {
            node.right = insertRec(node.right, name, size);
        } else {
            return node; // Duplicate names are not allowed
        }

        // Update height of the current node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Get the balance factor to check if the node became unbalanced
        int balance = getBalance(node);

        // Perform rotations if needed to maintain AVL balance
        if (balance > 1 && name.compareTo(node.left.name) < 0) {
            return rotateRight(node); // Left Left Case
        }

        if (balance < -1 && name.compareTo(node.right.name) > 0) {
            return rotateLeft(node); // Right Right Case
        }

        if (balance > 1 && name.compareTo(node.left.name) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node); // Left Right Case
        }

        if (balance < -1 && name.compareTo(node.right.name) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node); // Right Left Case
        }

        return node; // Return the (possibly) updated node
    }
}
