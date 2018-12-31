import java.util.HashSet;
import java.util.Set;

/**
 * @author WallfacerRZD
 * @date 2018/12/31 10:39
 * <p>
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    /**
     * 正如飞禽见地下狮虎搏斗，不免会想：“何不高飞下扑，可制必胜？”
     * 殊不知狮虎在百兽之中虽然最为凶猛厉害，要高飞下扑，却是力所不能。
     * 张无忌见识未够广博，一时想不到其中的缘故。
     */
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                boolean ok = set.add(num);
                if (!ok) {
                    return true;
                }
            }
            return false;
        }
    }
}
