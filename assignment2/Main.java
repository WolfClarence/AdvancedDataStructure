public class Main {
    public static void main(String[] args) {
        FileNode node = new FileNode("RootFile", 100); // Using the constructor
        System.out.println("FileNode Created: " + node.name + ", Size: " + node.size);
    }
}

class FileNode {
    String name;
    int size;
    FileNode left, right, parent;
    int height; // Used for AVL Tree balancing

    public FileNode(String name, int size) {
        this.name = name;
        this.size = size;
        this.left = this.right = this.parent = null;
        this.height = 1;
    }
}
