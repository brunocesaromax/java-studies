package node;

public class TestNode {

    public static void main(String[] args) {
        Node<String> node1 = new Node<>("C");
        Node<String> node2 = new Node<>("C++");
        Node<String> node3 = new Node<>("JAVA");

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(node1);
        System.out.println(node1.getNext());

        System.out.println(node2);
        System.out.println(node2.getNext());

        System.out.println(node3);
        System.out.println(node3.getNext());
    }
}
