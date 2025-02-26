import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
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
        exportResultsToExcel(myDequeTime, arrayDequeTime);
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
    private static void exportResultsToExcel(long myDequeTime, long arrayDequeTime) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Performance Results");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Deque Type");
        headerRow.createCell(1).setCellValue("Execution Time (ns)");

        // Insert MyDeque results
        Row myDequeRow = sheet.createRow(1);
        myDequeRow.createCell(0).setCellValue("MyDeque");
        myDequeRow.createCell(1).setCellValue(myDequeTime);

        // Insert ArrayDeque results
        Row arrayDequeRow = sheet.createRow(2);
        arrayDequeRow.createCell(0).setCellValue("ArrayDeque");
        arrayDequeRow.createCell(1).setCellValue(arrayDequeTime);

        // Save the Excel file
        try (FileOutputStream fileOut = new FileOutputStream("DequePerformance.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
    }
}