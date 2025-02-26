import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MyQueueTest {
    private static final int TEST_SIZE = 1000000;

    public static void main(String[] args) throws IOException {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> javaQueue = new LinkedList<>();
        Random random = new Random();

        // Measure execution time of MyQueue and Java Queue
        long myQueueTime = testQueuePerformance(myQueue, random);
        long javaQueueTime = testQueuePerformance(javaQueue, random);

        // Print results to console
        System.out.println("MyQueue execution time: " + myQueueTime + " ns");
        System.out.println("Java Queue execution time: " + javaQueueTime + " ns");

        // Export results to a CSV file for further analysis
        exportResultsToCSV(myQueueTime, javaQueueTime);
    }

    // Tests the performance of Java's built-in Queue implementation.

    private static long testQueuePerformance(Queue<Integer> queue, Random random) {
        long startTime = System.nanoTime();

        for (int i = 0; i < TEST_SIZE; i++) {
            queue.offer(i); // Enqueue operation
            if (!queue.isEmpty() && random.nextBoolean()) {
                queue.poll(); // Dequeue operation
            }
        }
        return System.nanoTime() - startTime;
    }

    // Tests the performance of the custom MyQueue implementation.
    private static long testQueuePerformance(MyQueue<Integer> queue, Random random) {
        long startTime = System.nanoTime();

        for (int i = 0; i < TEST_SIZE; i++) {
            queue.enqueue(i); // Enqueue operation
            if (!queue.isEmpty() && random.nextBoolean()) {
                queue.dequeue(); // Dequeue operation
            }
        }
        return System.nanoTime() - startTime;
    }

    // Exports the performance test results to a CSV file for further analysis.
    private static void exportResultsToCSV(long myQueueTime, long javaQueueTime) throws IOException {
        String filePath = "QueuePerformance.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            // Write CSV head
            writer.append("Queue Type,Execution Time (ns)\n");

            // MyQueue result
            writer.append("MyQueue,").append(String.valueOf(myQueueTime)).append("\n");

            // Java Queue result
            writer.append("Java Queue,").append(String.valueOf(javaQueueTime)).append("\n");

            System.out.println("Results exported to " + filePath);
        }
    }
}
