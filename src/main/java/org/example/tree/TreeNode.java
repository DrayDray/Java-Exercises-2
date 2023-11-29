package main.java.org.example.tree;

public class TreeNode {
    //I am assuming this is a binary tree node only (max 2 nodes per node)

    private Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public static void preOrderTraverse(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
