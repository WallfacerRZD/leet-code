/**
 * @author WallfacerRZD
 * @date 2018/6/28 23:08
 *
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame {
    /**
     * 不断更新能达到的最大下标
     */
    class Solution1 {
        public boolean canJump(int[] nums) {
            int reach = 0;
            for (int i = 0; i < nums.length && i <= reach; i++) {
                reach = Math.max(nums[i] + i, reach);
            }
            return reach >= nums.length - 1;
        }
    }

    /**
     * last: 能到达last就能到达数组的最后
     * 最后判断last是否为0
     */
    class Solution2 {
        public boolean canJump(int[] nums) {
            int last = nums.length - 1;
            int i = nums.length - 2;
            for (; i >= 0; i--) {
                if (nums[i] + i >= last) {
                    last = i;
                }
            }
            return last == 0;
        }
    }
}
