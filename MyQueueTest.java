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

        // Measure execution time
        long myQueueTime = testQueue(myQueue, random);
        long javaQueueTime = testQueue(javaQueue, random);

        // Print results
        System.out.println("MyQueue time: " + myQueueTime + " ns");
        System.out.println("Java Queue time: " + javaQueueTime + " ns");

        // Save results to CSV
        saveResults(myQueueTime, javaQueueTime);
    }

    private static long testQueue(MyQueue<Integer> queue, Random random) {
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            queue.enqueue(i);
            if (!queue.isEmpty() && random.nextBoolean()) {
                queue.dequeue();
            }
        }
        return System.nanoTime() - start;
    }

    private static long testQueue(Queue<Integer> queue, Random random) {
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            queue.offer(i);
            if (!queue.isEmpty() && random.nextBoolean()) {
                queue.poll();
            }
        }
        return System.nanoTime() - start;
    }

    private static void saveResults(long myQueueTime, long javaQueueTime) throws IOException {
        String file = "QueuePerformance.csv";
        try (FileWriter writer = new FileWriter(file)) {
            writer.append("Queue Type,Time (ns)\n");
            writer.append("MyQueue," + myQueueTime + "\n");
            writer.append("Java Queue," + javaQueueTime + "\n");
            System.out.println("Results saved to " + file);
        }
    }
}