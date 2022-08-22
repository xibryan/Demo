package sample.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
297. 二叉树的序列化与反序列化
 */
public class Leetcode_297_Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new LinkedList<>();
        preOrder(root, result);
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        List<String> list = Arrays.stream(values).collect(Collectors.toList());
        String value = list.remove(0);
        if ("-".equals(value)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));
        preOrderDes(root, list);

        return root;
    }

    private void preOrderDes(TreeNode root, List<String> values) {
        String value = values.remove(0);
        if (!"-".equals(value)) {
            TreeNode node = new TreeNode(Integer.parseInt(value));
            root.left = node;
            preOrderDes(root.left, values);
        }

        value = values.remove(0);
        if (!"-".equals(value)) {
            TreeNode node = new TreeNode(Integer.parseInt(value));
            root.right = node;
            preOrderDes(root.right, values);
        }
    }

    private void preOrder(TreeNode root, List<String> result) {
        if (root == null) {
            result.add("-");
            return;
        }
        result.add(String.valueOf(root.val));
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
