package sample.algorithm.leetcode;

/*
https://leetcode.cn/problems/delete-node-in-a-bst/
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            return deleteCurrentNode(root);
        }

        TreeNode current = root;
        while (current != null) {
            if (current.val > key) {
                if (current.left != null && current.left.val == key) {
                    current.left = deleteCurrentNode(current.left);
                    return root;
                }
                current = current.left;
            } else {
                if (current.right != null && current.right.val == key) {
                    current.right = deleteCurrentNode(current.right);
                    return root;
                }
                current = current.right;
            }
        }

        return root;
    }

    private TreeNode deleteCurrentNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        TreeNode parent = null;
        TreeNode current = root.right;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        root.val = current.val;
        if (parent == null) {
            root.right = current.right;
        } else {
            parent.left = current.right;
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
