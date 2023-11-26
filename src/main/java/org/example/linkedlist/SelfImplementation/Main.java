package main.java.org.example.linkedlist.SelfImplementation;

public class Main {

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addNode(new Node(2));
        ll.addNode(new Node(4));
        Node badNode = new Node(99);
        ll.addNode(badNode);
        ll.addNode(new Node(8));
        ll.addNode(new Node(10));

        ll.printLinkedList();

        ll.removeNode(badNode);
        System.out.println("After bad node removal:");
        ll.printLinkedList();

        ll.removeNode(new Node(10));
        System.out.println("After bad node removal:");
        ll.printLinkedList();

        ll.removeNode(new Node(10));
        ll.printLinkedList();

        ll.removeNode(new Node(2));
        ll.printLinkedList();

        ll.removeNode(new Node(8));
        ll.printLinkedList();

        ll.removeNode(new Node(4));
        ll.printLinkedList();
    }

}
