public class TesteNode {

    public static void main(String[] args) {
        Node node1 = new Node("C");
        Node node2 = new Node("C++");
        Node node3 = new Node("JAVA");

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
