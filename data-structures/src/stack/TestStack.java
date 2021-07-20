package stack;

import node.Node;

public class TestStack {

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(new Node<>(1));
        integerStack.push(new Node<>(2));
        integerStack.push(new Node<>(3));
        integerStack.push(new Node<>(4));
        integerStack.push(new Node<>(5));
        integerStack.push(new Node<>(6));

        System.out.println(integerStack);

        integerStack.pop();

        System.out.println(integerStack);
        System.out.println(integerStack.top());
    }
}
