import java.util.Random;

// TestAVL.java
// A test class to verify the AVL Tree operations
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        insert(avlTree);
        search(avlTree);
    }

    //100000 times of insert
    public static void insert(AVLTree avlTree) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int num=random.nextInt(100000);
            avlTree.insert(num+".txt",10);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Insert execution time: " + (endTime - startTime) + "ms");
    }

    //100000 times of search
    public static void search(AVLTree avlTree) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int num=random.nextInt(100000);
            avlTree.search(num+".txt");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Search execution time: " + (endTime - startTime) + "ms");
    }
}
