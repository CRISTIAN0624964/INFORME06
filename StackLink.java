public class StackLink<E> implements Stack<E> {
    // Nodo que representa la cima de la pila
    private Node3<E> top;

    // Constructor que inicializa la pila vacía
    public StackLink() {
        this.top = null;
    }

    // Método para agregar un elemento a la cima de la pila
    public void push(E x) {
        // Crear un nuevo nodo con el valor x
        Node3<E> newNode = new Node3<>(x);
        // El siguiente nodo del nuevo nodo es el que estaba en la cima de la pila
        newNode.setNext(top);
        // Ahora la cima de la pila es el nuevo nodo
        top = newNode;
    }

    // Método para quitar y devolver el elemento en la cima de la pila
    public E pop() throws ExceptionIsEmpty {
        // Si la pila está vacía, lanzar una excepción
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        // Guardar el dato en la cima de la pila
        E data = top.getData();
        // Mover la cima de la pila al siguiente nodo
        top = top.getNext();
        // Devolver el dato extraído
        return data;
    }

    // Método para obtener el elemento en la cima de la pila sin quitarlo
    public E top() throws ExceptionIsEmpty {
        // Si la pila está vacía, lanzar una excepción
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        // Devolver el dato en la cima de la pila
        return top.getData();
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        // La pila está vacía si la cima es null
        return top == null;
    }

    // Método para obtener una representación en cadena de la pila
    public String toString() {
        // Usar StringBuilder para construir la cadena
        StringBuilder sb = new StringBuilder();
        // Empezar desde el nodo en la cima de la pila
        Node3<E> current = top;
        // Recorrer la pila hasta que no haya más nodos
        while (current != null) {
            // Añadir el dato del nodo a la cadena
            sb.append(current.getData()).append(" ");
            // Avanzar al siguiente nodo
            current = current.getNext();
        }
        // Devolver la cadena sin el último espacio
        return sb.toString().trim();
    }
}
