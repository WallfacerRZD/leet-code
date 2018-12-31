import java.util.HashSet;
import java.util.Set;

/**
 * @author WallfacerRZD
 * @date 2018/12/31 10:51
 * <p>
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {
    /**
     * Time Limit Exceeded
     */
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            for (int i = 1; i <= k; i++) {
                for (int j = 0; i + j < nums.length && j < nums.length; j++) {
                    if (nums[j] == nums[i + j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class Solution1 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>(k + 1);
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }
                if (!set.add(nums[i])) {
                    return true;
                }
            }
            return false;
        }
    }
}
