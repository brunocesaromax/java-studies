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
