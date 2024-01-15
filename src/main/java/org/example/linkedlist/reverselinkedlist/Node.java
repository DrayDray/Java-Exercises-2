package org.example.linkedlist.reverselinkedlist;

import java.util.ArrayList;
import java.util.List;

public class Node {

    Integer value;
    Node next;

    public Node(){}
    public Node(Integer value){
        this.value = value;
    }

    public void setNext(Node node){
        this.next = node;
    }


    public static void main(String[] args) {
        //iterativeReverse();

        //with extra data structure
        recursiveReverseWithExtraDataStructure();

        recursiveReverseInPlace();
    }

    private static void recursiveReverseInPlace() {
        Node node = getHead();

        Node head = node;
        recursiveReverseInPlace(node, head);

    }

    private static void recursiveReverseInPlace(Node curr, Node head){
        if(curr == null){
            return;
        }
        if(curr.next == null){
            //new head!
            head = curr;
            return;
        }
        recursiveReverseInPlace(curr.next, head);
        curr.next.next = curr;
        curr.next = null;
    }

    private static void recursiveReverseWithExtraDataStructure() {
        Node node = getHead();

        ArrayList<Node> reverseArrayList = new ArrayList<>();
        reverseLinkedList(node, reverseArrayList);

        Node headOfReverseLinkedList = null;
        Node reversedLinkedList = null;
        for(int i = 0; i < reverseArrayList.size(); i++){
            Node currentNode = reverseArrayList.get(i);

            if(i == 0){
                reversedLinkedList = currentNode;
                headOfReverseLinkedList = reversedLinkedList;
            }
            else{
                reversedLinkedList.next = currentNode;
                reversedLinkedList = reversedLinkedList.next;
            }
        }

        System.out.println("BREAKPOINT B/C I'M LAZY");

    }


    private static void reverseLinkedList(Node node, ArrayList reversedList) {
        //end case
        if(node.next != null){
            reverseLinkedList(node.next, reversedList);
        }
        reversedList.add(new Node(node.value));
    }

    private static void iterativeReverse() {
        Node node = getHead();
        List<Node> nodesList = new ArrayList<>();

        while(node != null){
            nodesList.add(node);
            node = node.next;
        }

        int size = nodesList.size(); // 2:

        Node reverseHeadNode = new Node(nodesList.get(size-1).value);
        Node pointerNode = reverseHeadNode;
        for(int i = size - 2; i >= 0; i--){ //0
            Node next = new Node(nodesList.get(i).value);
            pointerNode.next = next;
            pointerNode = next;
        }

    }

    public static Node getHead(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
}
