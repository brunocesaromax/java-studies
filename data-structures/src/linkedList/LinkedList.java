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

    public T getContent(int index) {
        return getNode(index).getContent();
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

    private Integer getIndexByNode(Node<T> node) {
        for (int i = 0; i < size() - 1; i++) {
            if (node.equals(getNode(i))) return i;
        }

        throw new RuntimeException("Não existe indice correspondente na lista para o nó atual");
    }

    private void checkIfIndexIsValid(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice: " + index + " na lista. Indice máximo: " + (size() - 1));
        }
    }

    public T remove(Node<T> node) {
        Integer nodeToRemoveIndex = getIndexByNode(node);
        return remove(nodeToRemoveIndex);
    }

    public T remove(int index) {
        Node<T> nodeToRemove = this.getNode(index);

        if (index == 0) { // Removendo primeiro nó da lista
            firstNode = nodeToRemove.getNext();
        } else {
            Node<T> nodeBefore = this.getNode(index - 1);
            nodeBefore.setNext(nodeToRemove.getNext());
        }

        return nodeToRemove.getContent();
    }
}



















