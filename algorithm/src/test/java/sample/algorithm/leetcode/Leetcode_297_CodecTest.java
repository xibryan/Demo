package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leetcode_297_CodecTest {
    @Test
    public void test() {
        Leetcode_297_Codec.TreeNode root = new Leetcode_297_Codec.TreeNode(1);
        root.left = new Leetcode_297_Codec.TreeNode(2);
        root.right = new Leetcode_297_Codec.TreeNode(3);
        root.right.left = new Leetcode_297_Codec.TreeNode(4);
        root.right.right = new Leetcode_297_Codec.TreeNode(5);

        Leetcode_297_Codec leetcode_297_codec = new Leetcode_297_Codec();
        String serialize = leetcode_297_codec.serialize(root);
        leetcode_297_codec.deserialize(serialize);
    }
}