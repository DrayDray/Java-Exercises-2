package main.java.org.example.tree.depth;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;


public class MaxDepth {

    public static void main(String[] args) {
        BinaryTreeNode tree1 = createBinaryTree();
        System.out.println("Levels:" + traverse(tree1));

        BinaryTreeNode tree2 = createBinaryTree();
        System.out.println("Levels:" + traverse2(tree1));
    }

    private static BinaryTreeNode createBinaryTree() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        return node1;
    }

    public static int traverse2(BinaryTreeNode root) {
        int level = 0;
        LinkedList<BinaryTreeNode> linkedList = new LinkedList<>(Arrays.asList(root));

        while(CollectionUtils.isNotEmpty(linkedList)){
            level++;
            for(int i = 0; i < linkedList.size(); i++){
                BinaryTreeNode node = linkedList.removeFirst();
                if(node != null){
                    if(node.left != null){
                        linkedList.push(node.left);
                    }
                    if(node.right != null){
                        linkedList.push(node.right);
                    }
                }
            }
        }

        return level;
    }

    /**
     * Recursive DFS - Depth First Search
     */
    public static int traverse(BinaryTreeNode node) {
        if (node != null) {
            return 1 + Math.max(traverse(node.left), traverse(node.right));
        } else {
            return 0;
        }
    }


    protected static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;

        BinaryTreeNode right;

        BinaryTreeNode() {
        }

        protected BinaryTreeNode(int val) {
            this.val = val;
        }

        BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
