package linkedList;

import node.Node;

public class LinkedList<T> {

    private Node<T> firstNode;

    public LinkedList() {
        this.firstNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public long size() {
        long listSize = 0;
        Node<T> temp = firstNode;

        while (temp != null) {
            listSize++;
            temp = temp.getNext();
        }

        return listSize;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);
        add(newNode);
    }

    public void add(Node<T> newNode) {
        if (this.isEmpty()) {
            firstNode = newNode;
        } else {
            Node<T> temp = firstNode;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(newNode);
        }
    }

    private Node<T> getNode(int index) {
        checkIfIndexIsValid(index);

        Node<T> temp = firstNode;
        Node<T> nodeReturn = null;

        for (int i = 0; i < size() - 1; i++) {
            nodeReturn = temp;
            temp = temp.getNext();
        }

        return nodeReturn;
    }

    private void checkIfIndexIsValid(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice: " + index + " na lista. Indice máximo: " + (size() - 1));
        }
    }
}



















