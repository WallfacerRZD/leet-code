import java.util.Arrays;

/**
 * @author WallfacerRZD
 * @date 2018/12/26 11:11
 *
 * 面对一个商店, 只有两个选择 抢或者不抢
 * 抢: 当前最大利益为前面的前面的商店金额加上当前商店的金额
 * 不抢: 当前最大利益为前面的商店金额
 */
public class HouseRoubber {
    /**
     * 递归
     */
    static class Solution {
        public int rob(int[] nums) {
            int[] result = new int[nums.length];
            Arrays.fill(result, -1);
            return rob(result, nums, nums.length - 1);
        }

        private int rob(int[] result, int[] nums, int i) {
            if (i < 0) {
                return 0;
            }
            if (result[i] > -1) {
                return result[i];
            }
            result[i] = Integer.max(rob(result, nums, i - 2) + nums[i], rob(result, nums, i - 1));
            return result[i];
        }
    }

    /**
     * 迭代
     */
    static class Solution1 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] cache = new int[nums.length + 2];
            cache[0] = 0;
            cache[1] = 0;
            for (int i = 0; i < nums.length; i++) {
                cache[i + 2] = Integer.max(nums[i] + cache[i], cache[i + 1]);
            }
            return cache[nums.length + 1];
        }
    }

    /**
     * space: O(1)
     */
    static class Solution2 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int prePreMaxInterest = 0;
            int preMaxInterest = 0;
            for (int i : nums) {
                int currMaxInterest = Math.max(prePreMaxInterest + i, preMaxInterest);
                prePreMaxInterest = preMaxInterest;
                preMaxInterest = currMaxInterest;
            }
            return preMaxInterest;
        }
    }
}
