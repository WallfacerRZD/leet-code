/**
 * @author WallfacerRZD
 * @date 2019/1/2 10:44
 *
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
    /**
     * (n & (n-1)): 去掉n二进制表示最右边的一个1
     */
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n-1)) == 0;
        }
    }
}
