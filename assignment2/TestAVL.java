// TestAVL.java
// A test class to verify the AVL Tree operations
public class TestAVL {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Inserting files into the AVL Tree
        avlTree.insert("file1.txt", 100);
        avlTree.insert("file2.txt", 200);
        avlTree.insert("file3.txt", 50);
        avlTree.insert("file4.txt", 300);
        avlTree.insert("file5.txt", 250);

        // Searching for a file
        BinarySearchTree.FileNode result = avlTree.search("file3.txt");
        if (result != null) {
            System.out.println("File found: " + result.name + " with size " + result.size);
        } else {
            System.out.println("File not found.");
        }
    }
}
