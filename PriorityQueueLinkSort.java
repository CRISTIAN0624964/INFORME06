// Clase que implementa una cola de prioridad usando una lista enlazada ordenada
public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    // Clase interna para representar una entrada en la cola (dato + prioridad)
    private class EntryNode {
        E data;        // Dato almacenado
        N priority;    // Prioridad asociada

        // Constructor de EntryNode
        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    // Nodo que apunta al primer elemento de la cola
    private Node2<EntryNode> first;
    // Nodo que apunta al último elemento de la cola
    private Node2<EntryNode> last;

    // Constructor: inicializa la cola vacía
    public PriorityQueueLinkSort() {
        first = null;
        last = null;
    }

    // Método para insertar un nuevo elemento con una prioridad
    public void enqueue(E x, N pr) {
        EntryNode newEntry = new EntryNode(x, pr);               // Crear una nueva entrada
        Node2<EntryNode> newNode = new Node2<>(newEntry);        // Crear un nuevo nodo con esa entrada

        // Si la cola está vacía o la nueva prioridad es mayor que la del primero (mayor prioridad al frente)
        if (isEmpty() || pr.compareTo(first.getData().priority) > 0) {
            newNode.setNext(first);
            first = newNode;
            if (last == null) last = newNode;                    // Si era el primer nodo, también es el último
        } else {
            // Buscar la posición correcta para insertar el nuevo nodo manteniendo el orden de prioridad
            Node2<EntryNode> current = first;
            while (current.getNext() != null &&
                   pr.compareTo(current.getNext().getData().priority) <= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) last = newNode;       // Si se insertó al final, actualizar 'last'
        }
    }

    // Método para eliminar y devolver el elemento con mayor prioridad
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        E data = first.getData().data;           // Obtener el dato del primer nodo
        first = first.getNext();                 // Avanzar al siguiente nodo
        if (first == null) last = null;          // Si la cola quedó vacía, actualizar 'last'
        return data;
    }

    // Método para ver el primer elemento (mayor prioridad) sin eliminarlo
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return first.getData().data;
    }

    // Método para ver el último elemento (menor prioridad) sin eliminarlo
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return last.getData().data;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return first == null;
    }

    // Representación en cadena de la cola, mostrando cada elemento con su prioridad
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node2<EntryNode> current = first;
        while (current != null) {
            sb.append("(").append(current.getData().data)
              .append(", ").append(current.getData().priority)
              .append(") ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
}
