package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {
    private TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pastOrder(root, p, q);
        return ancestor;
    }

    public int pastOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }

        int left = pastOrder(root.left, p, q);
        if (ancestor != null) {
            return 2;
        }

        int right = pastOrder(root.right, p, q);
        if (ancestor != null) {
            return 2;
        }

        int cur = ((root == p) || (root == q)) ? 1 : 0;
        if (left + right + cur == 2) {
            ancestor = root;
        }

        return left + right + cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
