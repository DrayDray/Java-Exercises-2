package main.java.org.example.tree.depth;

public class MaxDepth {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        System.out.println(traverse(node1));
    }

    /**
     * Recursive solution
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
