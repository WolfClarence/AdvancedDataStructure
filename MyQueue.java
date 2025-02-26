public class MyQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    //Enqueue an element to the queue (add to the end)
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    //Dequeue an element from the queue (remove from the front)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    //Peek the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    //Get the size of the queue
    public int size() {
        return size;
    }

    //Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Clear the queue
    public void clear() {
        front = rear = null;
        size = 0;
    }

    // Print the queue
    public void printQueue() {
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
