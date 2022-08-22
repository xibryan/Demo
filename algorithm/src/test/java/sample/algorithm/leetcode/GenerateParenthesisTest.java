package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesisTest {

    @Test
    void generateParenthesis() {
        List<String> results = new GenerateParenthesis().generateParenthesis(3);
        results.stream().forEach(System.out::println);
    }
}