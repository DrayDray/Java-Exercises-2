package main.java.org.example.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDups {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = createLinkedList();
        System.out.println(removeDups(linkedList));
    }

    private static LinkedList<Integer> createLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(10);
        linkedList.add(30);
        linkedList.add(10);
        linkedList.add(40);
        linkedList.add(40);
        return linkedList;
    }

    //O(n) (allowing usage of buffers (extra space holders).
    public static LinkedList<Integer> removeDups(LinkedList<Integer> linkedList) {
        //for tracking
        HashSet<Integer> uniqueValues = new HashSet();
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < linkedList.size(); i++) {
            Integer value = linkedList.get(i);
            if (uniqueValues.contains(value)) {
                toRemove.add(i);
            }
            //unique value; leave it in
            else {
                uniqueValues.add(value);
            }
        }

        //remove from the right so the index doesn't get messed up
        for (int i = toRemove.size() - 1; i >= 0; i--) {
            int valueAtIndex = toRemove.get(i);
            linkedList.remove(valueAtIndex);
        }
        return linkedList;
    }

}
