package doublyLinkedList;

import node.Node;

public class TestDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList<String> strDoublyLinkedList = new DoublyLinkedList<>();

        strDoublyLinkedList.add("c1");
        strDoublyLinkedList.add(new Node<>("c2"));
        strDoublyLinkedList.add("c3");
        strDoublyLinkedList.add(new Node<>("c4"));
        strDoublyLinkedList.add("c5");
        strDoublyLinkedList.add(new Node<>("c6"));
        System.out.println(strDoublyLinkedList);

        strDoublyLinkedList.remove(3);
        strDoublyLinkedList.add(3, "99");
        strDoublyLinkedList.add(3, new Node<>("85"));
        System.out.println(strDoublyLinkedList);

        strDoublyLinkedList.remove(6);
        System.out.println(strDoublyLinkedList);

        strDoublyLinkedList.remove(new Node<>("c1"));
        System.out.println(strDoublyLinkedList);

        strDoublyLinkedList.remove(8);
        System.out.println(strDoublyLinkedList);
    }
}
