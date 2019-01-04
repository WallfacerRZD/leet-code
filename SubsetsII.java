import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2019/1/4 16:54
 */
public class SubsetsII {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            helper(result, new ArrayList<>(), 0, nums);
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
            if (index <= nums.length) {
                result.add(new ArrayList<>(temp));
            }
            int i = index;
            while (i < nums.length) {
                temp.add(nums[i]);
                helper(result, temp, i + 1, nums);
                temp.remove(temp.size() - 1);
                i++;
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }
    }
}
