public class Test1 {
    public static void main(String[] args) {
        try {
            System.out.println(" StackLink Test ");
            Stack<Integer> pila = new StackLink<>();
            pila.push(10);
            pila.push(20);
            System.out.println(pila); // 20 10
            System.out.println(pila.pop()); // 20

            System.out.println("\n QueueArray Test ");
            Queue<String> cola = new QueueArray<>(5);
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            System.out.println(cola); // A B C
            cola.dequeue();
            System.out.println(cola.front()); // B

            System.out.println("\n PriorityQueueLinked Test ");
            PriorityQueue<String, Integer> cp = new PriorityQueueLinked<>(3);
            cp.enqueue("bajo", 0);
            cp.enqueue("alto", 2);
            cp.enqueue("medio", 1);
            System.out.println(cp);
            cp.dequeue();
            System.out.println(cp.front());

            System.out.println("\n Application: Symbol Balancing ");
            System.out.println(Aplication.symbolBalancing("()()[()]()")); // true
            System.out.println(Aplication.symbolBalancing("((()))[]")); // true
            System.out.println(Aplication.symbolBalancing("([])[](")); // false
            System.out.println(Aplication.symbolBalancing("([{)]}")); // false
            System.out.println(Aplication.symbolBalancing("[")); // false
            System.out.println(Aplication.symbolBalancing("[][][]{{{}}}")); // true

        } catch (ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
    }
}
