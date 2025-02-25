import java.util.Stack;
/**
 * StockSpanCalculator
 * This class calculates the stock span for a given array of stock prices.
 * The stock span represents the number of consecutive days the stock price has been higher than previous days.
 * Time Complexity: O(n) (Each element is pushed and popped from the stack at most once)
 */
public class StockSpanCalculator {
    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];// Array to store span values
        Stack<Integer> stack = new Stack<>();// Stack to store indices of stock prices
        // Iterate through all stock prices
        for (int i = 0; i < n; i++) {
            // Remove all elements from the stack that are smaller than or equal to the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            // Compute the span if the stack is empty, it means no previous higher price, so span is i + 1
            // Otherwise, span = current index - index of the last higher price
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            // Push the current index onto the stack
            stack.push(i);
        }
        return span;
    }
    //Method to print the span array.
    public void printSpan(int[] spans) {
        for (int span : spans) {
            System.out.print(span + " ");
        }
        System.out.println();
    }
    //Main method to test the calculateSpan method.
    public static void main(String[] args) {
        // Create an instance of StockSpanCalculator
        StockSpanCalculator calculator = new StockSpanCalculator();
        int[] prices = {100, 65, 32, 70, 84, 75, 85};
        int[] spans = calculator.calculateSpan(prices);
        calculator.printSpan(spans);
    }
}