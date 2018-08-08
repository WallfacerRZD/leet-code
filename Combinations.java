import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/8/8 10:59
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    /**
     * backtracking
     */
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            helper(result, new ArrayList<>(), 1, n, k);
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
            if (k == 0) {
                result.add(new ArrayList<>(temp));
            } else {
                for (int i = start; i <= n; i++) {
                    temp.add(i);
                    helper(result, temp, i + 1, n, k - 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    /**
     * iteration
     */
    class Solution1 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            Integer[] temp = new Integer[k];
            for (int i = 0; i < k; i++) {
                temp[i] = 0;
            }
            int i = 0;
            while (i >= 0) {
                temp[i]++;
                if (temp[i] > n) {
                    i--;
                } else if (i == k - 1) {
                    result.add(new ArrayList<>(Arrays.asList(temp)));
                } else {
                    i++;
                    // Integer自增会返回新对象
                    temp[i] = temp[i - 1];
                }
            }
            return result;
        }
    }
}
