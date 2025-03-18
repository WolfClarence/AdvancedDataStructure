// BinarySearchTree.java
// Implements a basic Binary Search Tree (BST) for file storage.
public class BinarySearchTree {

    protected FileNode root;  // Root node of the tree

    // Inner class FileNode for representing file nodes
    protected class FileNode {
        String name;
        int size;
        FileNode left, right;
        protected int height;  // Height used for balancing in AVL Tree

        public FileNode(String name, int size) {
            this.name = name;
            this.size = size;
            this.left = this.right = null;
            this.height = 1; // Initial height is 1 for a new node
        }
    }

    // Insert a file into the BST
    public void insert(String name, int size) {
        root = insertRec(root, name, size);
    }

    // Recursively insert a new node into the BST
    private FileNode insertRec(FileNode node, String name, int size) {
        if (node == null) return new FileNode(name, size);

        if (name.compareTo(node.name) < 0) {
            node.left = insertRec(node.left, name, size);
        } else if (name.compareTo(node.name) > 0) {
            node.right = insertRec(node.right, name, size);
        }

        return node;
    }

    // Search for a file in the BST
    public FileNode search(String name) {
        return searchRec(root, name);
    }

    // Recursively search for a node
    private FileNode searchRec(FileNode node, String name) {
        if (node == null || node.name.equals(name)) return node;
        return name.compareTo(node.name) < 0 ? searchRec(node.left, name) : searchRec(node.right, name);
    }
}
