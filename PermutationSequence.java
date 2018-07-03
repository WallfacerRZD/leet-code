import java.util.ArrayList;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/7/3 22:39
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {
    /**
     * (╯︵╰)
     */
    static class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }

            int[] factorial = new int[n+1];
            factorial[0] = 1;
            int product = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = product *= i;
            }

            k--;
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <=n; i++) {
                int index = k / factorial[n-i];
                result.append(numbers.get(index));
                k -= index * factorial[n-i];
                numbers.remove(index);
            }
            return result.toString();
        }
    }
}
