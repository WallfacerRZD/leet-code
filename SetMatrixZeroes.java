/**
 * @author WallfacerRZD
 * @date 2018/8/5 10:11
 *
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 将每一行(列)的状态存储在该行(列)的第一个位置
 * 注意第一列的状态要单独存
 * 因为第一列的状态存储在第一列的第一个位置会影响第一行的状态
 */
public class SetMatrixZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int col0 = 1;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    col0 = 0;
                }
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = rows-1; i >=0; i--) {
                for (int j = cols-1; j >=1; j--) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
                if (col0 == 0) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
