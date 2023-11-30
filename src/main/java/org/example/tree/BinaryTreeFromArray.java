package main.java.org.example.tree;

import java.util.ArrayList;
import java.util.List;

/*
Construct a complete binary tree from given array in level order fashion
Input  :  arr[] = {1, 2, 3, 4, 5, 6}
        Output : Root of the following tree
        1
        / \
        2   3
        / \ /
        4  5 6
*/
public class BinaryTreeFromArray {

    public static void main(String[] args) {
        List<Integer> list = createList();
        System.out.println("List:");
        System.out.print(list);

        TreeNode root = insertNode(list, 0);
        //print contents
        System.out.println("\nTree:");
        TreeNode.preOrderTraverse(root);
    }

    private static List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        return list;
    }

    /*
    Insert nodes in level order, recursively
     */
    public static TreeNode insertNode(List<Integer> list, int i) {
        //root node
        TreeNode node = null;

        //keep going until end of list
        if (i < list.size()) {
            node = new TreeNode(list.get(i));

            //set left child
            node.setLeft(insertNode(list, 2 * i + 1));

            //set right child
            node.setRight(insertNode(list, 2 * i + 2));

        }
        return node;
    }
}



