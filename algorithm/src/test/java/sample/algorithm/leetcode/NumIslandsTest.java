package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumIslandsTest {

    @Test
    void numIslands() {
        char[][] test = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int numIslands = new NumIslands().numIslands(test);
        System.out.println(numIslands);
    }
}