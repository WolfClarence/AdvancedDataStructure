import java.util.Random;

public class SplayTreeTest {
    public static void main(String[] args) {
        SplayTree splayTree = new SplayTree();
        insert(splayTree);
        search(splayTree);
    }

    //100000 times of insert
    public static void insert(SplayTree splayTree) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int num=random.nextInt(100000);
            splayTree.insert(num+".txt",10);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Insert execution time: " + (endTime - startTime) + "ms");
    }

    //100000 times of search
    public static void search(SplayTree splayTree) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int num=random.nextInt(100000);
            splayTree.search(num+".txt");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Search execution time: " + (endTime - startTime) + "ms");
    }
}
