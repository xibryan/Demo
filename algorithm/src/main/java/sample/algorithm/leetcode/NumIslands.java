package sample.algorithm.leetcode;

import java.util.Arrays;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int width = grid.length;
        int height = grid[0].length;

        char[][] visited = new char[width][height];
        for (int l = 0; l < visited.length; l++) {
            Arrays.fill(visited[l], (char) 0);
        }

        int result = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    result++;
                    bfs(grid, visited, i, j);
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, char[][] visited, int i, int j) {
        int width = grid.length;
        int height = grid[0].length;
        if (i < 0 || i >= width || j < 0 || j >= height) {
            return;
        }

        if (grid[i][j] == '0' || visited[i][j] == 1) {
            return;
        }

        visited[i][j] = 1;
        bfs(grid, visited, i + 1, j);
        bfs(grid, visited, i - 1, j);
        bfs(grid, visited, i, j + 1);
        bfs(grid, visited, i, j - 1);
    }
}
