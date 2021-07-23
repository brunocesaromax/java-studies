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

        while (temp != null){
            listSize++;
            temp = temp.getNext();
        }

        return listSize;
    }
}
