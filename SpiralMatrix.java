import java.util.ArrayList;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/6/27 9:50
 *
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length <= 0) {
                return new ArrayList<>();
            }
            int bottom = matrix.length - 1;
            int right = matrix[0].length - 1;
            int left = 0;
            int top = 0;
            List<Integer> result = new ArrayList<>();
            while (bottom >= top && right >= left) {
                int i = top;
                int j = left;
                if (bottom == top) {
                    for (; j <= right; j++) {
                        result.add(matrix[i][j]);
                    }
                } else if (left == right) {
                    for (; i <= bottom; i++) {
                        result.add(matrix[i][j]);
                    }
                } else {
                    for (; j < right; j++) {
                        result.add(matrix[i][j]);
                    }
                    for (; i < bottom; i++) {
                        result.add(matrix[i][j]);
                    }
                    for (; j > left; j--) {
                        result.add(matrix[i][j]);
                    }
                    for (; i > top; i--) {
                        result.add(matrix[i][j]);
                    }
                }
                right--;
                bottom--;
                left++;
                top++;
            }
            return result;
        }
    }

    class Solution1 {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> res = new ArrayList<Integer>();

            if (matrix.length == 0) {
                return res;
            }

            int rowBegin = 0;
            int rowEnd = matrix.length - 1;
            int colBegin = 0;
            int colEnd = matrix[0].length - 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                // Traverse Right
                for (int j = colBegin; j <= colEnd; j++) {
                    res.add(matrix[rowBegin][j]);
                }
                rowBegin++;

                // Traverse Down
                for (int j = rowBegin; j <= rowEnd; j++) {
                    res.add(matrix[j][colEnd]);
                }
                colEnd--;

                if (rowBegin <= rowEnd) {
                    // Traverse Left
                    for (int j = colEnd; j >= colBegin; j--) {
                        res.add(matrix[rowEnd][j]);
                    }
                }
                rowEnd--;

                if (colBegin <= colEnd) {
                    // Traver Up
                    for (int j = rowEnd; j >= rowBegin; j--) {
                        res.add(matrix[j][colBegin]);
                    }
                }
                colBegin++;
            }

            return res;
        }
    }
}
