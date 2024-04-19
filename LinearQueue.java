package LinearQueue;

public class LinearQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public LinearQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element: " + element);
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;

        System.out.println("Enqueued element: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        int element = queue[front];
        front = (front + 1) % capacity;
        size--;

        System.out.println("Dequeued element: " + element);
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }

        return queue[front];
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display(); // Output: Queue: 10 20 30

        System.out.println("Front element: " + queue.peek()); // Output: Front element: 10

        queue.dequeue(); // Output: Dequeued element: 10

        queue.display(); // Output: Queue: 20 30

        System.out.println("Is queue full? " + queue.isFull()); // Output: Is queue full? false
        System.out.println("Queue size: " + queue.size()); // Output: Queue size: 2

        queue.enqueue(40);
        queue.enqueue(50);

        queue.display(); // Output: Queue: 20 30 40 50

        queue.enqueue(60); // Output: Queue is full. Cannot enqueue element: 60
    }
}
