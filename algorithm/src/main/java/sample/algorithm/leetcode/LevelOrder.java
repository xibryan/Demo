package sample.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            List<TreeNode> tmp = new LinkedList<>();
            List<Integer> curLevel = new LinkedList<>();
            for (TreeNode treeNode : nodeList) {
                if (treeNode != null) {
                    curLevel.add(treeNode.val);
                    tmp.add(treeNode.left);
                    tmp.add(treeNode.right);
                }
            }
            if (!curLevel.isEmpty()) {
                result.add(curLevel);
            }
            nodeList = tmp;
        }
        return result;
    }

    public class TreeNode {
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
