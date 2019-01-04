/**
 * @author WallfacerRZD
 * @date 2019/1/4 16:41
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram(同位异构词) of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] alphabet = new int[26];
            for (char c : s.toCharArray()) {
                alphabet[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                alphabet[c - 'a']--;
            }
            for (int x : alphabet) {
                if (x != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
