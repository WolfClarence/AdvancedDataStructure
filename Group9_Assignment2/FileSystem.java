import java.util.*;
import java.io.*;
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

    public void readFile(String filename) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while ((line=br.readLine())!=null) {
            String[] cols = line.split(",");
            String name = cols[0];
            int size = Integer.parseInt(cols[1]);
            addFile(name, size);
        }
        br.close();
    }

    public void getFileSize(String filename) {
        System.out.println("BST-File found: " + bst.search(filename).size);
        System.out.println("AVL-File found: " + avl.search(filename).size);
        System.out.println("Splay-File found: " + splay.search(filename).size);
    }

    // Adds a file to all three data structures
    private void addFile(String name, int size) {
        bst.insert(name, size);
        avl.insert(name, size);
        splay.insert(name, size);
    }

}
