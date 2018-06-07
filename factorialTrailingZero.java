import java.math.BigInteger;

/**
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @author WallfacerRZD
 * @date 2018/6/7 22:14
 */
public class factorialTrailingZero {
    /**
     * n!中, 0的个数由因子10的个数决定.
     * 因为10=2*5, 所以10的个数为min(因子2的个数, 因子5的个数).
     * 因为n!中, 因子2的个数多于因子5的个数
     * 所以0的个数由因子5的个数决定.
     * 5的倍数都提供1个因子5, n!中有(n/5)个5的倍数.
     * 注意: 25=5*5,提供2个因子5, 1个额外因子5(其中一个在计算5的倍数时计算过了)
     * 所以结果为:
     * return n / 5 + n / 25 + n / 125 + ....
     */
    private class Solution1 {
        public int trailingZeroes(int n) {
            int sum = 0;
            while (n != 0) {
                sum += (n /= 5);
            }
            return sum;
        }
    }

    private class Solution2 {
        public int trailingZeroes(int n) {
            return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
        }
    }
}
