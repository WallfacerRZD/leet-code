import java.util.*;

/**
 * @author WallfacerRZD
 * @date 2018/6/25 22:41
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * 思路:
 *      将每个字符串排序, 通过判断排序后的字符串是否相同
 *      来确定是否是由相同字符构成的字符串
 * 其实一开始我已经想到了这个解法, 但是觉得这个解法太直接了, 就没有实现,
 * 没想到高票的解法就是这样.
 * 果然还是要勇敢地去尝试啊
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String keyStr = String.valueOf(ca);
                if (!map.containsKey(keyStr)) {
                    map.put(keyStr, new ArrayList<>());
                }
                map.get(keyStr).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }
}
