public class QueueArray<E> implements Queue<E> {
    // Arreglo que representa los elementos de la cola
    private E[] array;
    // Índice del primer elemento en la cola
    private int first;
    // Índice del próximo lugar donde se insertará un elemento en la cola
    private int last;
    // Cantidad de elementos en la cola
    private int size;

    // Constructor que inicializa la cola con la capacidad especificada
    public QueueArray(int capacity) {
        // Crear el arreglo con la capacidad especificada
        this.array = (E[]) new Object[capacity];
        // Inicializar los índices y el tamaño
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    // Método para agregar un elemento al final de la cola
    public void enqueue(E x) {
        // Si la cola está llena, lanzar una excepción
        if (size == array.length) throw new RuntimeException("Queue is full");
        // Asignar el nuevo elemento en la posición 'last'
        array[last] = x;
        // Avanzar el índice 'last' de forma circular
        last = (last + 1) % array.length;
        // Incrementar el tamaño de la cola
        size++;
    }

    // Método para quitar y devolver el elemento al frente de la cola
    public E dequeue() throws ExceptionIsEmpty {
        // Si la cola está vacía, lanzar una excepción
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        // Obtener el dato del primer elemento
        E data = array[first];
        // Avanzar el índice 'first' de forma circular
        first = (first + 1) % array.length;
        // Decrementar el tamaño de la cola
        size--;
        // Devolver el dato extraído
        return data;
    }

    // Método para obtener el elemento al frente de la cola sin quitarlo
    public E front() throws ExceptionIsEmpty {
        // Si la cola está vacía, lanzar una excepción
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        // Devolver el dato del primer elemento
        return array[first];
    }

    // Método para obtener el último elemento de la cola sin quitarlo
    public E back() throws ExceptionIsEmpty {
        // Si la cola está vacía, lanzar una excepción
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        // Devolver el dato del último elemento de la cola (índice 'last - 1')
        return array[(last - 1 + array.length) % array.length];
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        // La cola está vacía si el tamaño es cero
        return size == 0;
    }

    // Método para obtener una representación en cadena de los elementos de la cola
    public String toString() {
        // Usar StringBuilder para construir la cadena de salida
        StringBuilder sb = new StringBuilder();
        // Recorrer la cola desde 'first' hasta el tamaño de la cola
        for (int i = 0; i < size; i++) {
            // Añadir el dato del elemento actual a la cadena
            sb.append(array[(first + i) % array.length]).append(" ");
        }
        // Devolver la cadena sin el último espacio
        return sb.toString().trim();
    }
}
