/**
 * @author WallfacerRZD
 * @date 2018/7/1 22:42
 *
 * Given a positive integer n, generate a square matrix filled with
 * elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrix2 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
            int count = 1;
            int[][] matrix = new int[n][n];

            while (colStart <= colEnd && rowStart <= rowEnd) {
                for (int i = colStart; i <= colEnd; i++) {
                    matrix[rowStart][i] = count++;
                }
                rowStart++;
                for (int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colEnd] = count++;
                }
                colEnd--;
                if (colEnd >= colStart) {
                    for (int i = colEnd; i >= colStart; i--) {
                        matrix[rowEnd][i] = count++;
                    }
                }
                rowEnd--;
                if (rowEnd >= rowStart) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        matrix[i][colStart] = count++;
                    }
                }
                colStart++;
            }
            return matrix;
        }
    }
}
