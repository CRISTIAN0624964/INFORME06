//Implementación de una cola de prioridad utilizando varias colas basadas en listas enlazadas.
public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer> {
    // Arreglo de colas para manejar diferentes niveles de prioridad
    private QueueLink<E>[] queues;
    // Número de niveles de prioridad
    private int levels;

    // Constructor que inicializa la cola de prioridad con un número de niveles
    public PriorityQueueLinked(int levels) {
        this.levels = levels;
        this.queues = new QueueLink[levels];
        // Inicializar una cola vacía para cada nivel de prioridad
        for (int i = 0; i < levels; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    // Método para agregar un elemento a la cola con un nivel de prioridad
    public void enqueue(E x, Integer priority) {
        // Verificar si el nivel de prioridad es válido
        if (priority < 0 || priority >= levels)
            throw new IllegalArgumentException("Invalid priority level");
        // Agregar el elemento a la cola correspondiente según su prioridad
        queues[priority].enqueue(x);
    }

    // Método para eliminar y devolver el elemento con la mayor prioridad
    public E dequeue() throws ExceptionIsEmpty {
        // Recorrer las colas desde la mayor prioridad hasta la menor
        for (int i = levels - 1; i >= 0; i--) {
            // Si la cola del nivel actual no está vacía, eliminar y devolver el primer elemento
            if (!queues[i].isEmpty())
                return queues[i].dequeue();
        }
        // Si todas las colas están vacías, lanzar una excepción
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    // Método para obtener el primer elemento de la cola con la mayor prioridad sin eliminarlo
    public E front() throws ExceptionIsEmpty {
        // Recorrer las colas desde la mayor prioridad hasta la menor
        for (int i = levels - 1; i >= 0; i--) {
            // Si la cola del nivel actual no está vacía, devolver el primer elemento
            if (!queues[i].isEmpty())
                return queues[i].front();
        }
        // Si todas las colas están vacías, lanzar una excepción
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    // Método para obtener el último elemento de la cola con la menor prioridad sin eliminarlo
    public E back() throws ExceptionIsEmpty {
        // Recorrer las colas desde la menor prioridad hasta la mayor
        for (int i = 0; i < levels; i++) {
            // Si la cola del nivel actual no está vacía, devolver el último elemento
            if (!queues[i].isEmpty())
                return queues[i].back();
        }
        // Si todas las colas están vacías, lanzar una excepción
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    // Método para verificar si la cola de prioridad está vacía
    public boolean isEmpty() {
        // Recorrer todas las colas y verificar si alguna no está vacía
        for (QueueLink<E> q : queues) {
            if (!q.isEmpty()) return false;
        }
        // Si todas las colas están vacías, la cola de prioridad está vacía
        return true;
    }

    // Método para obtener una representación en cadena de la cola de prioridad
    public String toString() {
        // Usar StringBuilder para construir la cadena
        StringBuilder sb = new StringBuilder();
        // Recorrer las colas desde la mayor prioridad hasta la menor
        for (int i = levels - 1; i >= 0; i--) {
            // Añadir la representación de cada cola con su respectivo nivel de prioridad
            sb.append("Priority ").append(i).append(": ").append(queues[i]).append("\n");
        }
        // Devolver la cadena construida
        return sb.toString();
    }
}
