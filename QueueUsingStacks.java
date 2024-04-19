package LinearQueue;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue operation
    private Stack<Integer> stack2; // For dequeue operation

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int element) {
        stack1.push(element);
        System.out.println("Enqueued element: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int element = stack2.pop();
        System.out.println("Dequeued element: " + element);
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display(); // Output: Queue: 10 20 30

        System.out.println("Front element: " + queue.peek()); // Output: Front element: 10

        queue.dequeue(); // Output: Dequeued element: 10

        queue.display(); // Output: Queue: 20 30

        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false
        System.out.println("Queue size: " + queue.size()); // Output: Queue size: 2

        queue.enqueue(40);
        queue.enqueue(50);

        queue.display(); // Output: Queue: 20 30 40 50

        queue.dequeue(); // Output: Dequeued element: 20
        queue.dequeue(); // Output: Dequeued element: 30

        queue.display(); // Output: Queue: 40 50

        queue.dequeue(); // Output: Dequeued element: 40
        queue.dequeue(); // Output: Dequeued element: 50

        queue.display(); // Output: Queue is empty.

        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true
    }
}
