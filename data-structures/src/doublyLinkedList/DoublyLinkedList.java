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
        } else {
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

    public void remove(Node<T> node) {
        int index = getIndexByNode(node);
        remove(index);
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirstNode();
        } else {
            Node<T> temp = getNode(index);
            temp.getPrev().setNext(temp.getNext());

            if (temp != lastNode) {
                temp.getNext().setPrev(temp.getPrev());
            } else {
                lastNode = temp;
            }
        }

        this.size--;
    }

    @Override
    public String toString() {
        StringBuilder strReturn = new StringBuilder();

        Node<T> temp = firstNode;
        for (int i = 0; i < size; i++) {
            strReturn.append(temp.toString()).append("-->");
            temp = temp.getNext();
        }

        strReturn.append("null");
        return strReturn.toString();
    }

    private void removeFirstNode() {
        firstNode = firstNode.getNext();

        if (firstNode != null) {
            firstNode.setPrev(null);
        }
    }

    private Node<T> getNode(int index) {
        Node<T> temp = firstNode;

        for (int i = 0; (i < index) && (temp != null); i++) {
            temp = temp.getNext();
        }

        return temp;
    }

    private Integer getIndexByNode(Node<T> node) {
        for (int i = 0; i < size - 1; i++) {
            if (node.equals(getNode(i))) return i;
        }

        throw new RuntimeException("Não existe indice correspondente na lista para o nó atual");
    }
}
