package queue.stack;

import node.Node;

public class Queue<T> {

    private Node<T> firstNode;

    public Queue() {
        this.firstNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public Node<T> first() {
        return findFirstNode();
    }

    public T firstContent() {
        Node<T> firstNode = findFirstNode();
        return firstNode != null ? firstNode.getContent() : null;
    }

    private Node<T> findFirstNode() {
        if (!isEmpty()) {
            Node<T> firstNode = this.firstNode;

            while (firstNode.getNext() != null) {
                firstNode = firstNode.getNext();
            }

            return firstNode;
        }
        return null;
    }

    public void enqueueNode(Node<T> newNode) {
        newNode.setNext(firstNode);
        firstNode = newNode;
    }

    public void enqueueContent(T obj) {
        Node<T> newNode = new Node<>(obj);
        newNode.setNext(firstNode);
        firstNode = newNode;
    }

    public Node<T> dequeueNode() {
        return findNodeToRemove();
    }

    public T dequeueContent() {
        Node<T> nodeToRemove = findNodeToRemove();
        return nodeToRemove != null ? nodeToRemove.getContent() : null;
    }

    private Node<T> findNodeToRemove() {
        if (!isEmpty()) {
            Node<T> firstNode = this.firstNode;
            Node<T> tempNode = this.firstNode;

            while (firstNode.getNext() != null) {
                tempNode = firstNode;
                firstNode = firstNode.getNext();
            }

            tempNode.setNext(null);
            return firstNode;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("----------------\n");
        result.append("     Queue\n");
        result.append("----------------\n");

        Node<T> temp = firstNode;

        while (temp != null) {
            result.append(temp.toString()).append("\n");
            temp = temp.getNext();
        }

        result.append("=================\n");
        return result.toString();
    }
}
