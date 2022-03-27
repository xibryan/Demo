package sample.algorithm.leetcode;

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
