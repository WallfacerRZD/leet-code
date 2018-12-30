/**
 * @author WallfacerRZD
 * @date 2018/12/30 11:28
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 *
 */
public class IsomorphicStrings {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int[] map1 = new int[128];
            int[] map2 = new int[128];
            int length = s.length();
            for (int i = 0; i < length; i++) {
                int key1 = (int) s.charAt(i);
                int key2 = (int) t.charAt(i);
                if (map1[key1] != map2[key2]) {
                    return false;
                }
                map1[key1] = i + 1;
                map2[key2] = i + 1;
            }
            return true;
        }
    }
}
