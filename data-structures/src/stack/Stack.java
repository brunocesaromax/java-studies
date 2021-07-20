package stack;

import node.Node;

public class Stack<T> {

    private Node<T> firstNode;

    public Stack() {
        this.firstNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public Node<T> top() {
        return firstNode;
    }

    public void push(Node<T> newNode) {
        Node<T> temp = firstNode;
        firstNode = newNode;
        firstNode.setNext(temp);
    }

    public Node<T> pop() {
        if (!isEmpty()) {
            Node<T> nodeRemoved = firstNode;
            firstNode = firstNode.getNext();
            return nodeRemoved;
        }
        return null;
    }
}
