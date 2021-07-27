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
    public void add(T element){
        Node<T> newNode = new Node<>(element);
        add(newNode);
    }

    public void add(Node<T> newNode){
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
        checkIfIndexIsValid(index);
        Node<T> temp = firstNode;

        for (int i = 0; (i < index) && (temp != null); i++) {
            temp = temp.getNext();
        }

        return temp;
    }

    private void checkIfIndexIsValid(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice: " + index + " na lista. Indice máximo: " + (size - 1));
        }
    }
}
