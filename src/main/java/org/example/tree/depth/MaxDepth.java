package org.example.tree.depth;


import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


public class MaxDepth {

    public static void main(String[] args) {
        BinaryTreeNode tree1 = createBinaryTree();
        System.out.println("Levels:" + traverse(tree1));

        BinaryTreeNode tree2 = createBinaryTree();
        System.out.println("Levels:" + traverse2(tree1));

        BinaryTreeNode tree3 = createBinaryTree();
        System.out.println("Levels:" + traverse3(tree1));
    }

    /*
    Iterative DFS (Depth First Search) using Stack
     */
    private static int traverse3(BinaryTreeNode node) {
        int level = 0;
        Stack<NodeInfo> stack = new Stack();
        stack.push(new NodeInfo(node, 1));

        while (CollectionUtils.isNotEmpty(stack)) {
            //pop nodeInfo to process
            NodeInfo nodeInfo = stack.pop();

            //if it's not null - process it
            if (nodeInfo.node != null) {
                level = Math.max(level, nodeInfo.depth);
                //add children to stack
                stack.push(new NodeInfo(nodeInfo.node.left, nodeInfo.depth + 1));
                stack.push(new NodeInfo(nodeInfo.node.right, nodeInfo.depth + 1));
            }

        }
        return level;
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

    /*
    Breadth-First Search using linked list
     */
    public static int traverse2(BinaryTreeNode root) {
        int level = 0;
        LinkedList<BinaryTreeNode> linkedList = new LinkedList<>(Arrays.asList(root));

        while (CollectionUtils.isNotEmpty(linkedList)) {
            level++;
            for (int i = 0; i < linkedList.size(); i++) {
                BinaryTreeNode node = linkedList.removeFirst();
                if (node != null) {
                    if (node.left != null) {
                        linkedList.push(node.left);
                    }
                    if (node.right != null) {
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

    protected static class NodeInfo {
        BinaryTreeNode node;
        Integer depth;

        public NodeInfo(BinaryTreeNode node, Integer depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
