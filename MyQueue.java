import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    //Enqueue an element to the queue (add to the end)
    public void enqueue(T data) {
        queue.addLast(data);
    }

    //Dequeue an element from the queue (remove from the front)
    public T dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }

    //Peek the front element without removing it
    public T peek() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

    //Get the size of the queue
    public int size() {
        return queue.size();
    }

    //Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    //Clear the queue
    public void clear() {
        queue.clear();
    }

    //Print the queue
    public void printQueue() {
        System.out.println(queue);
    }
}

