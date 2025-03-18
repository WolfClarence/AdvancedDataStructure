// FileSystem.java
// Manages file storage using multiple tree structures.
public class FileSystem {
    private BinarySearchTree bst;
    private AVLTree avl;
    private SplayTree splay;

    public FileSystem() {
        this.bst = new BinarySearchTree();
        this.avl = new AVLTree();
        this.splay = new SplayTree();
    }

    // Adds a file to all three data structures
    public void addFile(String name, int size) {
        bst.insert(name, size);
        avl.insert(name, size);
        splay.insert(name, size);
    }
}
