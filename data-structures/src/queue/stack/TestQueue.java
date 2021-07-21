package queue.stack;

import node.Node;

public class TestQueue {

    public static void main(String[] args) {
        Queue<String> programmingLanguageQueue = new Queue<>();

        programmingLanguageQueue.enqueue(new Node<>("Java"));
        programmingLanguageQueue.enqueue(new Node<>("C"));
        programmingLanguageQueue.enqueue(new Node<>("C++"));
        programmingLanguageQueue.enqueue(new Node<>("Ruby"));
        programmingLanguageQueue.enqueue(new Node<>("Python"));
        programmingLanguageQueue.enqueue(new Node<>("SQL"));

        System.out.println(programmingLanguageQueue);

        System.out.println(programmingLanguageQueue.dequeue());
        System.out.println(programmingLanguageQueue);

        programmingLanguageQueue.enqueue(new Node<>("Kotlin"));
        System.out.println(programmingLanguageQueue);

        System.out.println(programmingLanguageQueue.first());
        System.out.println(programmingLanguageQueue);
    }
}
