import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

public class MyStackTest {
    private static final int TEST_SIZE = 1000000;

    public static void main(String[] args) throws IOException {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> javaStack = new Stack<>();
        Random random = new Random();

        // Measure time for MyStack and Java Stack
        long myStackTime = testStack(myStack, random);
        long javaStackTime = testStack(javaStack, random);

        // Print results
        System.out.println("MyStack time: " + myStackTime + " ns");
        System.out.println("Java Stack time: " + javaStackTime + " ns");

        // Save results to CSV
        saveResults(myStackTime, javaStackTime);
    }

    private static long testStack(MyStack<Integer> stack, Random random) {
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            stack.push(i);
            if (!stack.isEmpty() && random.nextBoolean()) {
                stack.pop();
            }
        }
        return System.nanoTime() - start;
    }

    private static long testStack(Stack<Integer> stack, Random random) {
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            stack.push(i);
            if (!stack.isEmpty() && random.nextBoolean()) {
                stack.pop();
            }
        }
        return System.nanoTime() - start;
    }

    private static void saveResults(long myStackTime, long javaStackTime) throws IOException {
        String file = "StackPerformance.csv";
        try (FileWriter writer = new FileWriter(file)) {
            writer.append("Stack Type,Time (ns)\n");
            writer.append("MyStack," + myStackTime + "\n");
            writer.append("Java Stack," + javaStackTime + "\n");
            System.out.println("Results saved to " + file);
        }
    }
}