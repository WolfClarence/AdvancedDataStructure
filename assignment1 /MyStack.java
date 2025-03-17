public class MyStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    //Push an element onto the stack
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    //Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    //Peek the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    //Get the size of the stack
    public int size() {
        return size;
    }

    //Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    //Clear the stack
    public void clear() {
        top = null;
        size = 0;
    }

    //Print the stack
    public void printStack() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
