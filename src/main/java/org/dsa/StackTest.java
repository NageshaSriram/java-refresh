package org.dsa;

import java.util.Stack;

class StackArray {
    private final int[] stack;
    private int top;
    private final int capacity;

    public StackArray(int size) {
        top = -1;
        capacity = size;
        stack = new int[size];
    }

    public void push(int value) {
        if (top == (capacity - 1)) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }
}

class StackLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public StackLinkedList() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Overflow");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

public class StackTest {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(5);
        stackArray.push(10);
        stackArray.push(20);
        stackArray.push(30);
        stackArray.printStack();
        System.out.println("Peek:: " + stackArray.peek());
        System.out.println("Pop:: " + stackArray.pop());
        System.out.println("Pop:: " + stackArray.pop());
        System.out.println("isEmpty:: " + stackArray.isEmpty());
        System.out.println("Pop:: " + stackArray.pop());
        System.out.println("Pop:: " + stackArray.pop());
        System.out.println("isEmpty:: " + stackArray.isEmpty());

        System.out.println("-----------Stack Using LinkedList-----------");

        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(10);
        stackLinkedList.push(20);
        stackLinkedList.push(30);
        stackLinkedList.printStack();
        System.out.println("Peek:: " + stackLinkedList.peek());
        System.out.println("Pop:: " + stackLinkedList.pop());
        System.out.println("Pop:: " + stackLinkedList.pop());
        System.out.println("isEmpty:: " + stackLinkedList.isEmpty());
        System.out.println("Pop:: " + stackLinkedList.pop());
        System.out.println("Pop:: " + stackLinkedList.pop());
        System.out.println("isEmpty:: " + stackLinkedList.isEmpty());

        System.out.println("------Stack using Collection------");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Pop:: " + stack.pop());
        System.out.println("Pop:: " + stack.pop());
        System.out.println("Pop:: " + stack.pop());
        boolean res = stack.empty();
        System.out.println("Res::" + res);
        System.out.println("Pop:: " + stack.pop());

//        System.out.println("Pop:: " + stack.pop());

    }
}
