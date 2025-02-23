package org.example.collections;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);
        list.addFirst("0");
        System.out.println(list);
        System.out.println(list.contains("c".toUpperCase()));
        System.out.println(list.containsAll(new ArrayList<String>(Arrays.asList("A", "B"))));

        list.removeAll(Arrays.asList("A", "D"));
        System.out.println(list);

        List<String> llist = new LinkedList<>();
        llist.add("Hello");
        llist.addFirst("My");
        llist.addLast("Dear");
        System.out.println();
        llist.retainAll(Arrays.asList("Hello", "My", "Dear"));
        System.out.println(llist.stream().count());

    }
}
