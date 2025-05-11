public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        System.out.println("=== StackArray ===");
        Stack<Integer> stack = new StackArray<>(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("Top: " + stack.top());
        stack.pop();
        System.out.println("After pop: " + stack);

        System.out.println("\n=== QueueLink ===");
        Queue<String> queue = new QueueLink<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue: " + queue);
        queue.dequeue();
        System.out.println("After dequeue: " + queue);
        System.out.println("Front: " + queue.front());
        System.out.println("Back: " + queue.back());

        System.out.println("\n=== PriorityQueueLinkSort ===");
        PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();
        pq.enqueue("Low", 1);
        pq.enqueue("High", 5);
        pq.enqueue("Medium", 3);
        System.out.println("Priority Queue: " + pq);
        System.out.println("Front: " + pq.front());
        pq.dequeue();
        System.out.println("After dequeue: " + pq);
    }
}
