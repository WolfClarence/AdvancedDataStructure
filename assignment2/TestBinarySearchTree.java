public class TestBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert("file1.txt", 100);
        bst.insert("file2.txt", 200);
        bst.insert("file3.txt", 50);

        BinarySearchTree.FileNode result = bst.search("file2.txt");
        if (result != null) {
            System.out.println("File found: " + result.name + " with size " + result.size);
        } else {
            System.out.println("File not found.");
        }
    }
}
