import java.util.*;

/**
 * @author WallfacerRZD
 * @date 2019/1/12 11:19
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 */
public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int distance = 1;
            Set<String> reached = new HashSet<>();
            reached.add(beginWord);
            while (!reached.contains(endWord)) {
                Set<String> toAdd = new HashSet<>();
                for (String each : reached) {
                    for (int i = 0; i < each.length(); i++) {
                        char[] chars = each.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            chars[i] = c;
                            String transformed = new String(chars);
                            if (wordList.contains(transformed)) {
                                toAdd.add(transformed);
                                wordList.remove(transformed);
                            }
                        }
                    }
                }
                if (toAdd.isEmpty()) {
                    return 0;
                }
                distance++;
                reached = toAdd;
            }
            return distance;
        }
    }

    /**
     * Time Limit Exceeded
     */
    class Solution1 {
        int result = Integer.MAX_VALUE;
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            helper(beginWord, endWord, wordList, 1);
            return result == Integer.MAX_VALUE ? 0 : result;
        }

        private void helper(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                result = Math.min(result, count);
                return;
            }
            if (count > wordList.size()) {
                return;
            }
            for (String s : wordList) {
                if (canTransform(beginWord, s)) {
                    helper(s, endWord, wordList, count + 1);
                }
            }
        }

        private boolean canTransform(String beginWord, String endWord) {
            int count = 0;
            for (int i = 0; i < beginWord.length(); i++) {
                if (beginWord.charAt(i) != endWord.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }
}
