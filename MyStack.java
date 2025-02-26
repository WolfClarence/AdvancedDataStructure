import java.util.Stack;

public class MyStack<T> {
    private Stack<T> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    //Push an element onto the stack
    public void push(T data) {
        stack.push(data);
    }

    //Pop an element from the stack
    public T pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    //Peek the top element without removing it
    public T peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    //Get the size of the stack
    public int size() {
        return stack.size();
    }

    //Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    //Print the stack
    public void printStack() {
        System.out.println(stack);
    }
}
