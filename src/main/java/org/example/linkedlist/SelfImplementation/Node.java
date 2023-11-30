package main.java.org.example.linkedlist.SelfImplementation;

public class Node {

    Integer data;
    Node next;

    public Node(Integer data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Node objNode;
            if (obj instanceof Node) {
                objNode = (Node) obj;
                return this.data == objNode.data;
            }
        }
        return false;
    }
}
