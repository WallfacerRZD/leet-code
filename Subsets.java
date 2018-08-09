import java.util.ArrayList;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/8/9 9:31
 */
public class Subsets {
    /**
     * backtracking
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for (int i = 1; i <= n; i++) {
                helper(result, new ArrayList<>(), 0, n, i, nums);
            }
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> temp, int start, int n, int k, int[] nums) {
            if (k == 0) {
                result.add(new ArrayList<>(temp));
            } else {
                for (int i = start; i < n; i++) {
                    temp.add(nums[i]);
                    helper(result, temp, i + 1, n, k - 1, nums);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    /**
     * 位操作
     * elementNum个元素的集合有subsetNum个子集
     * 从0到subsetNum的每个整数的二进制表示的每一位
     * 可看作是该位对应的元素是否在子集中
     */
    class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            int elementNum = nums.length;
            int subsetNum = (int) Math.pow(2.0, (double) elementNum);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < subsetNum; i++) {
                result.add(new ArrayList<>());
            }
            for (int i = 0; i < subsetNum; i++) {
                for (int j = 0; j < elementNum; j++) {
                    if (((i >> j) & 1) == 1) {
                        result.get(i).add(nums[j]);
                    }
                }
            }
            return result;
        }
    }
}
