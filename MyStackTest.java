import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MyStackTest {
    private static final int TEST_SIZE = 1000000;

    public static void main(String[] args) throws IOException {
        MyStack<Integer> myStack = new MyStack<>();
        java.util.Stack<Integer> javaStack = new java.util.Stack<>();
        Random random = new Random();

        // Measure execution time of MyStack and Java Stack
        long myStackTime = testStackPerformance(myStack, random);
        long javaStackTime = testStackPerformance(javaStack, random);

        // Print results to console
        System.out.println("MyStack execution time: " + myStackTime + " ns");
        System.out.println("Java Stack execution time: " + javaStackTime + " ns");

        // Export results to a CSV file for further analysis
        exportResultsToCSV(myStackTime, javaStackTime);
    }

    //Tests the performance of Java's built-in Stack implementation.
    private static long testStackPerformance(java.util.Stack<Integer> stack, Random random) {
        long startTime = System.nanoTime();

        for (int i = 0; i < TEST_SIZE; i++) {
            stack.push(i);
            if (!stack.isEmpty() && random.nextBoolean()) {
                stack.pop();
            }
        }
        return System.nanoTime() - startTime;
    }

    //Tests the performance of the custom MyStack implementation.
    private static long testStackPerformance(MyStack<Integer> stack, Random random) {
        long startTime = System.nanoTime();

        for (int i = 0; i < TEST_SIZE; i++) {
            stack.push(i);
            if (!stack.isEmpty() && random.nextBoolean()) {
                stack.pop();
            }
        }
        return System.nanoTime() - startTime;
    }

    //Exports the performance test results to a CSV file for further analysis.
    private static void exportResultsToCSV(long myStackTime, long javaStackTime) throws IOException {
        String filePath = "StackPerformance.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            // write CSV head
            writer.append("Stack Type,Execution Time (ns)\n");

            // MyStack result
            writer.append("MyStack,").append(String.valueOf(myStackTime)).append("\n");

            // Java Stack result
            writer.append("Java Stack,").append(String.valueOf(javaStackTime)).append("\n");

            System.out.println("Results exported to " + filePath);
        }
    }
}
