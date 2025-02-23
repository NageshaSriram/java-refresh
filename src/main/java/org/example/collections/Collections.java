package org.example.collections;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        for (String l: list) {
            System.out.println(l);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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


        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(3);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.stream().sorted().count());
        System.out.println(set.isEmpty());
        set.clear();
        if (set.isEmpty()) {
            System.out.println("Hello");
        }

        Set<Integer> tset = new TreeSet<>();
        tset.add(10);
        tset.add(1);
        tset.add(23);
        tset.add(25);
        tset.add(5);
        System.out.println(tset.size());

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));
        System.out.println();

        Map<Integer, String> smap = new TreeMap<>();
        smap.put(10, "ten");
        smap.put(2, "Two");
        smap.put(15, "Fifteen");
        System.out.println(smap);

        Queue<Integer> pqueue = new PriorityQueue<>();
        pqueue.add(10);
        pqueue.add(20);
        pqueue.add(2);
        pqueue.add(3);
        System.out.println(pqueue);
        System.out.println(pqueue.peek());
        System.out.println(pqueue.poll());
        System.out.println(pqueue);

        List<Integer> mlist = new ArrayList<>();
        mlist.add(1);
        mlist.add(2);
        mlist.add(3);
        mlist.add(4);
        mlist.add(5);
        mlist.add(6);
        mlist.add(7);
        mlist.add(8);
        mlist.add(9);
        mlist.add(10);
        int result = 0;
        for (Integer i: mlist) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        Optional<Integer> sum = mlist.stream().filter(n -> n % 2 == 0).reduce(Integer::sum);
        System.out.println("Even Numbers total is ::"+sum.isPresent());
        System.out.println("Even Numbers total is ::"+sum.orElse(0));


    }
}
