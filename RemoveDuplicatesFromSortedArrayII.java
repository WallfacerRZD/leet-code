/**
 * @author WallfacerRZD
 * @date 2018/8/11 10:02
 */
public class RemoveDuplicatesFromSortedArrayII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int n : nums) {
                if (i < 2 || n > nums[i-2]) {
                    nums[i++] = n;
                }
            }
            return i;
        }
    }
}
