/**
 * @author WallfacerRZD
 * @date 2019/1/13 17:45
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 */
public class SurroundedRegions {
    class Solution {
        public void solve(char[][] board) {
            int row = board.length;
            if (row == 0) {
                return;
            }
            int col = board[0].length;
            for (int i = 0; i < row; i++) {
                dfs(board, i, 0, row, col);
                if (col > 1) {
                    dfs(board, i, col - 1, row, col);
                }
            }
            for (int j = 0; j < col; j++) {
                dfs(board, 0, j, row, col);
                if (row > 1) {
                    dfs(board, row - 1, j, row, col);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == '*') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j, int row, int col) {
            boolean canMoveLeft = j >= 2;
            boolean canMoveRight = j <= col - 3;
            boolean canMoveUp = i >= 2;
            boolean canMoveDown = i <= row - 3;
            if (board[i][j] == 'O') {
                board[i][j] = '*';
                if (canMoveLeft) {
                    dfs(board, i, j - 1, row, col);
                }
                if (canMoveRight) {
                    dfs(board, i, j + 1, row, col);
                }
                if (canMoveUp) {
                    dfs(board, i - 1, j, row, col);
                }
                if (canMoveDown) {
                    dfs(board, i + 1, j, row, col);
                }
            }
        }
    }

    /**
     * 并查集
     */
    static class Solution1 {
        private static class UF {
            private int[] id;
            private int[] size;

            public UF(int n) {
                id = new int[n];
                size = new int[n];
                for (int i = 0; i < id.length; i++) {
                    id[i] = i;
                    size[i] = 1;
                }
            }
            public int find(int x) {
                return x == id[x] ? x : find(id[x]);
            }

            public boolean connect(int x, int y) {
                return find(x) == find(y);
            }

            public void union(int x, int y) {
                int xId = find(x);
                int yId = find(y);
                if (xId == yId) {
                    return;
                }
                if (size[xId] < size[yId]) {
                    id[xId] = yId;
                    size[yId] += size[xId];
                } else {
                    id[yId] = xId;
                    size[xId] += size[yId];
                }
            }
        }

        public void solve(char[][] board) {
            int row = board.length;
            if (row == 0) {
                return;
            }
            int col = board[0].length;
            UF uf = new UF(row * col + 1);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O') {
                        uf.union(i * col + j, col * row);
                    } else if (board[i][j] == 'O') {
                        if (board[i - 1][j] == 'O') {
                            uf.union(i * col + j, (i - 1) * col + j);
                        }
                        if (board[i + 1][j] == 'O') {
                            uf.union(i * col + j, (i + 1) * col + j);
                        }
                        if (board[i][j - 1] == 'O') {
                            uf.union(i * col + j, i * col + j - 1);
                        }
                        if (board[i][j + 1] == 'O') {
                            uf.union(i * col + j, i * col + j + 1);
                        }
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!uf.connect(i * col + j, col * row)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
