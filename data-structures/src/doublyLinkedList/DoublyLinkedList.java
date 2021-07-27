package doublyLinkedList;

import node.Node;

public class DoublyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
        this.firstNode = this.lastNode = null;
    }

    public int getSize() {
        return size;
    }

    public T get(int index) {
        return this.getNode(index).getContent();
    }

    /*Adicionando no final da lista*/
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        add(newNode);
    }

    /*Adicionando em determinada posição da lista*/
    public void add(int index, T element) {
        Node<T> temp = getNode(index);
        Node<T> newNode = new Node<>(element);
        newNode.setNext(temp);

        if (newNode.getNext() != null) {
            newNode.setPrev(temp.getPrev());
            newNode.getNext().setPrev(newNode);
        } else {
            newNode.setPrev(lastNode);
            lastNode = newNode;
        }

        if (index == 0) {
            firstNode = newNode;
        } else{
            newNode.getPrev().setNext(newNode);
        }

        size++;
    }

    public void add(Node<T> newNode) {
        newNode.setNext(null);
        newNode.setPrev(lastNode);

        if (firstNode == null) {
            firstNode = newNode;
        }

        if (lastNode != null) {
            lastNode.setNext(newNode);
        }

        lastNode = newNode;
        size++;
    }

    private Node<T> getNode(int index) {
        Node<T> temp = firstNode;

        for (int i = 0; (i < index) && (temp != null); i++) {
            temp = temp.getNext();
        }

        return temp;
    }
}
