package linkedList;

import node.Node;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<String> strLinkedList = new LinkedList<>();

        strLinkedList.add("teste1");
        strLinkedList.add("teste2");
        strLinkedList.add("teste3");
        strLinkedList.add("teste4");

        System.out.println(strLinkedList.getContent(0));
        System.out.println(strLinkedList.getContent(1));
        System.out.println(strLinkedList.getContent(2));
        System.out.println(strLinkedList.getContent(3));

        System.out.println("\n");
        System.out.println(strLinkedList);

        System.out.println(strLinkedList.remove(3));
        System.out.println("\n");
        System.out.println(strLinkedList);

        strLinkedList.add(new Node<>("testeAdicionado"));
        System.out.println(strLinkedList);

        System.out.println(strLinkedList.remove(new Node<>("teste2")));
        System.out.println(strLinkedList);
    }
}
