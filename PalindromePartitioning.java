import java.util.ArrayList;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2019/1/7 16:41
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Example:
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    /**
     * 递归遍历字符起始位置
     * for循环遍历字符串长度
     */
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            helper(result, new ArrayList<>(), s, 0);
            return result;
        }

        private void helper(List<List<String>> result, List<String> subStrings, String s, int index) {
            if (index == s.length()) {
                result.add(new ArrayList<>(subStrings));
                return;
            }
            for (int len = 1; index + len <= s.length(); len++) {
                String subString = s.substring(index, index + len);
                if (!isValid(subString)) {
                    continue;
                }
                subStrings.add(subString);
                helper(result, subStrings, s, index + len);
                subStrings.remove(subStrings.size() - 1);
            }
        }

        private boolean isValid(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
