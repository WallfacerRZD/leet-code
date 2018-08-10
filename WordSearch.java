/**
 * @author WallfacerRZD
 * @date 2018/8/10 8:49
 *
 *
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring.
    The same letter cell may not be used more than once.

    Example:

    board =
    [
    ['A','B','C','E'],
    ['S','F','C','S'],
    ['A','D','E','E']
    ]

    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
 */
public class WordSearch {
    /**
     * dfs
     */
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int k) {
            if (i < 0 ||
                    i >= board.length ||
                    j < 0 ||
                    j >= board[0].length ||
                    word.charAt(k) == ' ') {
                return false;
            }
            if (board[i][j] == word.charAt(k)) {
                if (k == word.length() - 1) {
                    return true;
                }
                char temp = board[i][j];
                board[i][j] = ' ';
                boolean exist = dfs(board, i - 1, j, word, k + 1) ||
                        dfs(board, i + 1, j, word, k + 1) ||
                        dfs(board, i, j - 1, word, k + 1) ||
                        dfs(board, i, j + 1, word, k + 1);
                board[i][j] = temp;
                return exist;
            }
            return false;
        }
    }
}
