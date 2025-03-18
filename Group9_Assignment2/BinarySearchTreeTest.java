import java.util.Random;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        insert(binarySearchTree);
        search(binarySearchTree);
    }

    //100000 times of insert
    public static void insert(BinarySearchTree binarySearchTree) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int num=random.nextInt(100000);
            binarySearchTree.insert(num+".txt",10);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Insert execution time: " + (endTime - startTime) + "ms");
    }

    //100000 times of search
    public static void search(BinarySearchTree binarySearchTree) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int num=random.nextInt(100000);
            binarySearchTree.search(num+".txt");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Search execution time: " + (endTime - startTime) + "ms");
    }
}
