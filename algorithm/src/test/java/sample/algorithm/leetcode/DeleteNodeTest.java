package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeTest {

    @Test
    void deleteNode() {
        DeleteNode.TreeNode left = new DeleteNode.TreeNode(3);
        left.left = new DeleteNode.TreeNode(2);
        left.right = new DeleteNode.TreeNode(4);
        DeleteNode.TreeNode right = new DeleteNode.TreeNode(6);
        right.right = new DeleteNode.TreeNode(7);
        DeleteNode.TreeNode root =  new DeleteNode.TreeNode(5, left, right);

        DeleteNode.TreeNode result = new DeleteNode().deleteNode(root, 3);
    }
}