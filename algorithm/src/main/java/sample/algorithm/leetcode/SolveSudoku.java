/*
https://leetcode.cn/problems/sudoku-solver/
37. 解数独
编写一个程序，通过填充空格来解决数独问题。

数独的解法需 遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。
 */

public class SolveSudoku {
    private boolean[][] lines = new boolean[9][9];
    private boolean[][] columns = new boolean[9][9];
    private boolean[][][] boxs = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        int rowCnt = board.length;
        int colCnt = board[0].length;

        for (int i = 0; i < rowCnt; i++) {
            for (int j = 0; j < colCnt; j++) {
                if (board[i][j] != '.') {
                    char value = (char) (board[i][j] - '0' - 1);
                    lines[i][value] = true;
                    columns[j][value] = true;
                    boxs[i / 3][j / 3][value] = true;
                }
            }
        }

        fillSudoku(board, 0);
    }

    private boolean fillSudoku(char[][] board, int pos) {
        if (pos >= 9 * 9) {
            return true;
        }

        int i = pos/9;
        int j = pos%9;

        if (board[i][j] != '.') {
            return fillSudoku(board, pos + 1);
        }

        for (int k = 0; k < 9; k++) {
            if (lines[i][k] || columns[j][k] || boxs[i/3][j/3][k]) {
                continue;
            }

            board[i][j] = (char) (k + '0' + 1);
            lines[i][k] = columns[j][k] = boxs[i/3][j/3][k] = true;
            boolean result = fillSudoku(board, pos + 1);
            if (result) {
                return true;
            }

            board[i][j] = '.';
            lines[i][k] = columns[j][k] = boxs[i/3][j/3][k] = false;
        }

        return false;
    }

    private void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] test =
                new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(test);
        solveSudoku.print(test);
    }
}
