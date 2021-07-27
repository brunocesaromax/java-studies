package node;

import java.util.Objects;

public class Node<T> {

    private T content;
    private Node<T> next;
    private Node<T> prev;

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

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "node.Node{" +
               "content='" + content + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node<?> node = (Node<?>) object;
        return Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
