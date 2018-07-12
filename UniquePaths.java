/**
 * @author WallfacerRZD
 * @date 2018/7/12 22:54
 *
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    /**
     * 公式法
     * 如果直接使用组合公式, 阶乘会溢出.
     * 所以只能不断将结果累积.
     * 注意浮点计算存在精度问题, 最后要作四舍五入
     */
    class Solution1 {
        public int uniquePaths(int m, int n) {
            int steps = m + n - 2;
            int k = n - 1;
            double result = 1;
            for (int i = 1; i <= k; i++) {
                result = result * (steps - i + 1) / i;
            }
            return (int) (result + 0.5);
        }
    }

    /**
     * DP
     * 设到达(i, j)点的路径有p[i][j]条
     * 有p[i][j] = p[i-1][j] + p[i][j-1]成立
     * O(m * n) -> O(2 * m) -> O(n)
     */
    class Solution2 {
        public int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            for (int i = 0; i < n; i++) {
                cur[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    cur[j] = cur[j - 1] + cur[j];
                }
            }
            return cur[n - 1];
        }
    }
}
