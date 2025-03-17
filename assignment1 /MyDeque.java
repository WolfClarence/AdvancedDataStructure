public class MyDeque<T> {

    /**
     * Node class for the doubly linked list
     */
    private static class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail; // Head and tail pointers
    private int size; // Number of elements in deque

    /**
     * Adds an element at the front of the deque
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the end of the deque
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element
     */
    public T pollFirst() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }

    /**
     * Removes and returns the last element
     */
    public T pollLast() {
        if (tail == null) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return data;
    }

    /**
     * Returns the first element without removing it
     */
    public T peekFirst() {
        return (head != null) ? head.data : null;
    }

    /**
     * Returns the last element without removing it
     */
    public T peekLast() {
        return (tail != null) ? tail.data : null;
    }

    /**
     * Returns the number of elements in the deque
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the deque is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the deque from    public boolean isEmpty() {
     return size == 0;
     }
     head to tail
     */
    public void printDeque() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

}
