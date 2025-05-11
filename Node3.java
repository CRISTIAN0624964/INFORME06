public class Node3<E> {
    private E data;
    private Node3<E> next;

    public Node3(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public Node3<E> getNext() {
        return next;
    }

    public void setNext(Node3<E> next) {
        this.next = next;
    }
}
