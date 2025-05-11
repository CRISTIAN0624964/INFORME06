// Interfaz genérica para una cola de prioridad
public interface PriorityQueue<E, N extends Comparable<N>> {
    
    // Método para insertar un elemento con su respectiva prioridad
    void enqueue(E x, N pr);

    // Método para eliminar y devolver el elemento con la mayor prioridad
    E dequeue() throws ExceptionIsEmpty;

    // Método para obtener el elemento con la mayor prioridad sin eliminarlo
    E front() throws ExceptionIsEmpty;

    // Método para obtener el elemento con la menor prioridad sin eliminarlo
    E back() throws ExceptionIsEmpty;

    // Método para verificar si la cola de prioridad está vacía
    boolean isEmpty();
}
