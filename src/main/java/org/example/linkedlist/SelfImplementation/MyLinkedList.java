package main.java.org.example.linkedlist.SelfImplementation;

public class MyLinkedList {

    private Node head;
    private Node tail;

    public MyLinkedList(){
    }

    public void addNode(Node node){
            if(head == null){
                this.head = node;
            }
            else{
                head.next = node;
                this.head = node;
            }
            if(tail == null){
                this.tail = node;
            }
    }

    public boolean removeNode(Node node){
        Node check = tail;
        //first check tail
        if(tail == null){
            return false;
        }
        if(tail.equals(node)){
            //single node
            if(this.head == this.tail){
                head = null;
                tail = null;
            }
            else{
                tail = check.next;
                return true;
            }
        }

        //then move from forward from tail one by one
        while(check.next != null){
            if(check.next.equals(node)){
                if(check.next.equals(head)){
                    //check becomes head
                    head = check;
                    check.next = null;
                }
                else{
                    check.next = check.next.next;
                }
                return true;
            }
            check = check.next;
        }
        //no node was removed;
        return false;
    }

    public void printLinkedList(){
        Node node = this.tail;
        if(tail == null || head == null){
            System.out.print("Empty LinkedList");
            return;
        }
        else {
            while (node != null) {
                System.out.print(node.data + "--> ");
                node = node.next;
            }
        }
        System.out.println("\n Tail: " + this.tail.data + " ================= Head: " + this.head.data);
        System.out.println("===============================================================");

    }




}
