import java.util.Random;

// A test class to evaluate the performance of the Splay Tree implementation
public class SplayTreeTest {
    public static void main(String[] args) {
        // Create an instance of SplayTree to test
        SplayTree splayTree = new SplayTree();

        // Perform 100,000 insertions into the Splay Tree
        insert(splayTree);

        // Perform 100,000 searches in the Splay Tree
        search(splayTree);
    }

    // Method to perform 100,000 insertions into the Splay Tree
    public static void insert(SplayTree splayTree) {
        // Record the start time of the insertion process
        long startTime = System.currentTimeMillis();

        // Loop to perform 100,000 insertions
        for (int i = 0; i < 100000; i++) {
            // Generate a random number between 0 and 99,999
            Random random = new Random();
            int num = random.nextInt(100000);

            // Insert a file with a random filename (e.g., "12345.txt") and a fixed size of 10
            splayTree.insert(num + ".txt", 10);
        }

        // Record the end time of the insertion process
        long endTime = System.currentTimeMillis();

        // Print the total execution time for the insertions
        System.out.println("Insert execution time: " + (endTime - startTime) + "ms");
    }

    // Method to perform 100,000 searches in the Splay Tree
    public static void search(SplayTree splayTree) {
        // Record the start time of the search process
        long startTime = System.currentTimeMillis();

        // Loop to perform 100,000 searches
        for (int i = 0; i < 100000; i++) {
            // Generate a random number between 0 and 99,999
            Random random = new Random();
            int num = random.nextInt(100000);

            // Search for a file with a random filename (e.g., "67890.txt")
            splayTree.search(num + ".txt");
        }

        // Record the end time of the search process
        long endTime = System.currentTimeMillis();

        // Print the total execution time for the searches
        System.out.println("Search execution time: " + (endTime - startTime) + "ms");
    }
}