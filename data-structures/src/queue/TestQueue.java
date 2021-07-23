package queue;

import node.Node;

public class TestQueue {

    public static void main(String[] args) {
        Queue<String> programmingLanguageQueue = new Queue<>();

        programmingLanguageQueue.enqueueContent("Java");
        programmingLanguageQueue.enqueueNode(new Node<>("C"));
        programmingLanguageQueue.enqueueContent("C++");
        programmingLanguageQueue.enqueueNode(new Node<>("Ruby"));
        programmingLanguageQueue.enqueueContent("Python");
        programmingLanguageQueue.enqueueNode(new Node<>("SQL"));

        System.out.println(programmingLanguageQueue);

        System.out.println(programmingLanguageQueue.dequeueNode());
        System.out.println(programmingLanguageQueue);

        System.out.println(programmingLanguageQueue.dequeueContent());
        System.out.println(programmingLanguageQueue);

        programmingLanguageQueue.enqueueNode(new Node<>("Kotlin"));
        System.out.println(programmingLanguageQueue);

        System.out.println(programmingLanguageQueue.first());
        System.out.println(programmingLanguageQueue);

        System.out.println(programmingLanguageQueue.firstContent());
        System.out.println(programmingLanguageQueue);
    }
}
