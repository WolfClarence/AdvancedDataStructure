import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Random;

public class MyDequeTest {
    // Use 1 million operations to do the stress test
    private static final int TEST_SIZE = 1000000;

    public static void main(String[] args) throws IOException {
        // Create instances of custom and built-in Deques
        MyDeque<Integer> myDeque = new MyDeque<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        Random random = new Random();

        // Measure execution time of MyDeque and ArrayDeque
        long myDequeTime = testDequePerformance(myDeque, random);
        long arrayDequeTime = testDequePerformance(arrayDeque, random);

        // Print results to console
        System.out.println("MyDeque execution time: " + myDequeTime + " ns");
        System.out.println("ArrayDeque execution time: " + arrayDequeTime + " ns");

        // Export results to an Excel file for further analysis
        exportResultsToCSV(myDequeTime, arrayDequeTime);
    }

    /**
     * Tests the performance of Java's built-in Deque implementation.
     * @param deque A Deque instance (e.g., ArrayDeque).
     * @param random A Random instance for random operation selection.
     * @return Execution time in nanoseconds.
     */
    private static long testDequePerformance(java.util.Deque<Integer> deque, Random random) {
        long startTime = System.nanoTime();

        for (int i = 0; i < TEST_SIZE; i++) {
            if (random.nextBoolean()) {
                deque.addFirst(i); // Insert at the front
            } else {
                deque.addLast(i); // Insert at the back
            }
            if (!deque.isEmpty() && random.nextBoolean()) {
                deque.pollFirst(); // Remove from the front
            }
        }

        return System.nanoTime() - startTime; // Return total execution time
    }

    /**
     * Tests the performance of the custom MyDeque implementation.
     * @param deque A MyDeque instance.
     * @param random A Random instance for random operation selection.
     * @return Execution time in nanoseconds.
     */
    private static long testDequePerformance(MyDeque<Integer> deque, Random random) {
        long startTime = System.nanoTime();

        for (int i = 0; i < TEST_SIZE; i++) {
            if (random.nextBoolean()) {
                deque.addFirst(i); // Insert at the front
            } else {
                deque.addLast(i); // Insert at the back
            }
            if (!deque.isEmpty() && random.nextBoolean()) {
                deque.pollFirst(); // Remove from the front
            }
        }

        return System.nanoTime() - startTime; // Return total execution time
    }

    /**
     * Exports the performance test results to an Excel file for further analysis.
     * This Excel is simply the execution time of MyDeque and the official Deque
     * @param myDequeTime Execution time of MyDeque.
     * @param arrayDequeTime Execution time of ArrayDeque.
     */
    private static void exportResultsToCSV(long myDequeTime, long arrayDequeTime) throws IOException {
        String filePath = "DequePerformance.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            // write CSV head
            writer.append("Deque Type,Execution Time (ns)\n");

            // MyDeque result
            writer.append("MyDeque,").append(String.valueOf(myDequeTime)).append("\n");

            // ArrayDeque result
            writer.append("ArrayDeque,").append(String.valueOf(arrayDequeTime)).append("\n");

            System.out.println("Results exported to " + filePath);
        }
    }

}
