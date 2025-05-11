public class QueueLink<E> implements Queue<E> {
    private Node2<E> first;
    private Node2<E> last;

    public QueueLink() {
        first = null;
        last = null;
    }

    public void enqueue(E x) {
        Node2<E> aux = new Node2<>(x);
        if (isEmpty()) {
            first = aux;
        } else {
            last.setNext(aux);
        }
        last = aux;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        E data = first.getData();
        first = first.getNext();
        if (first == null) last = null;
        return data;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return first.getData();
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Queue is empty");
        return last.getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node2<E> current = first;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
}
