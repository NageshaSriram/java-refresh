package org.dsa;

public class LinkedListTest {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insert(int data) {
        System.out.println("---Inserting---"+ data);
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtBegging(int data) {
        System.out.println("---Insert at beginning---"+data);
//        Node newNode = new Node(data);
//        if (head != null) {
//            newNode.next = head;
//        }
//        head = newNode;
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void delete(int data) {
        System.out.println("---Deleting Node---"+data);
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public int search(int data) {
        System.out.println("---Searching for index---");
        int index = -1;
        Node temp = head;
        while (temp != null) {
            ++index;
            if (temp.data == data) return index;
            temp = temp.next;
        }
        return -1;
    }

    public void displayNodes() {
        System.out.println("--------Displaying Node--------");
        if (head == null) {
            System.out.println("Linked list is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.insert(10);
        linkedListTest.insert(20);
        linkedListTest.insert(30);
        linkedListTest.displayNodes();
        System.out.println("Found at ::" + linkedListTest.search(20));
        System.out.println("Found at ::" + linkedListTest.search(30));
        System.out.println("Found at ::" + linkedListTest.search(10));
        System.out.println("Found at ::" + linkedListTest.search(0));
        linkedListTest.insertAtBegging(5);
        linkedListTest.displayNodes();
        linkedListTest.delete(30);
        linkedListTest.displayNodes();
        linkedListTest.delete(5);
        linkedListTest.displayNodes();

    }
}
