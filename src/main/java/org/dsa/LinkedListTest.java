package org.dsa;

import javax.print.attribute.standard.SheetCollate;

class SinglyLinkedList {
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
}

class DoublyLinkedList {
    static class Node {
        int data;
        Node pre, next;

        Node(int data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }

    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }

    public void displayNodes() {
        System.out.println("-------Displaying Nodes-------");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void delete(int data) {
        System.out.println("---Deleting item---"+data);
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.pre = null;
            }
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.pre != null) {
            temp.pre.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
        System.out.println("No matching item on: "+data);
    }
}

class CircularLinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node last;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    public void displayNodes() {
        if (last == null) return;
        Node temp = last.next;
        do {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("(back to head)");
    }
}

public class LinkedListTest {

    public static void main(String[] args) {
        System.out.println("--------------Singly Linked List--------------");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(10);
        singlyLinkedList.insert(20);
        singlyLinkedList.insert(30);
        singlyLinkedList.displayNodes();
        System.out.println("Found at ::" + singlyLinkedList.search(20));
        System.out.println("Found at ::" + singlyLinkedList.search(30));
        System.out.println("Found at ::" + singlyLinkedList.search(10));
        System.out.println("Found at ::" + singlyLinkedList.search(0));
        singlyLinkedList.insertAtBegging(5);
        singlyLinkedList.displayNodes();
        singlyLinkedList.delete(30);
        singlyLinkedList.displayNodes();
        singlyLinkedList.delete(5);
        singlyLinkedList.displayNodes();

        System.out.println("--------------Doubly Linked List--------------");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.isEmpty();
        doublyLinkedList.insert(10);
        doublyLinkedList.insert(20);
        doublyLinkedList.insert(30);
        doublyLinkedList.displayNodes();
        doublyLinkedList.delete(20);
        doublyLinkedList.displayNodes();
        doublyLinkedList.delete(10);
        doublyLinkedList.displayNodes();
        doublyLinkedList.delete(30);
        doublyLinkedList.displayNodes();
        doublyLinkedList.delete(30);
        doublyLinkedList.displayNodes();

        System.out.println("--------Circular Linked List--------");
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insert(10);
        circularLinkedList.insert(20);
        circularLinkedList.insert(30);
        circularLinkedList.insert(40);
        circularLinkedList.insert(50);
        circularLinkedList.insert(60);
        circularLinkedList.displayNodes();



    }
}
