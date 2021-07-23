package node;

public class Node<T> {

    private T content;
    private Node<T> next;

    public Node() {
        this.next = null;
    }

    public Node(T content) {
        this.content = content;
        this.next = null;
    }

    public Node(T content, Node<T> next) {
        this.content = content;
        this.next = next;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "node.Node{" +
               "content='" + content + '\'' +
               '}';
    }
}
