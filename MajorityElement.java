import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty
 * and the majority element always exist in the array.
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * @author WallfacerRZD
 * @date 2018/6/5 19:38
 */
public class MajorityElement {
}

/**
 * Moore's voting algorithm
 * <p>
 * 可以将题目形象化为一个投票的场景:
 * nums数组表示候选人的编号
 * candidate为当前候选人
 * count为当前候选人得到的票数
 * <p>
 * 遍历nums数组
 * 如果和candidate相同, 表示投当前候选人赞成票, count++
 * 如果和candidate不相同, 表示投当前候选人反对票, count--
 * 如果count为0, 说明到这个时刻为止, 已经遍历的子数组对投票结果不产生影响.重新选取候选人.
 */
class Solution1 {
    public int majorityEelement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i : nums) {
            if (candidate == i) {
                count++;
            } else if (count == 0) {
                candidate = i;
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

/**
 * 使用哈希表记录每个数字出现的次数
 */
class Solution2 {
    public int majorityEelement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            if (map.get(i) > nums.length / 2) {
                result = i;
                break;
            }
        }
        return result;
    }
}
