/**
 * @author WallfacerRZD
 * @date 2018/8/12 10:46
 */
public class SearchInRotatedSortedArrayII {
    /**
     * 因为有重复元素, 所以会出现num[lo] == num[hi]的情况
     * 这时不能确定该舍去哪一部分
     * 所以只能移动边缘指针, 直到出现num[lo] != num[hi]时
     * 再用二分查找的变体.
     */
    class Solution {
        public boolean search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
                    lo++;
                    hi--;
                } else if (nums[mid] >= nums[lo]) {
                    if (nums[mid] > target && target >= nums[lo]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
            return false;
        }
    }
}
