/**
 * @author WallfacerRZD
 * @date 2018/6/26 22:45
 *
 * 思路: 快速幂
 *      将指数转换为二进制, 从左到右遍历二进制数
 *      遇到一个1就对结果作一次贡献.
 *
 * 注意:
 *      如果指数是负数时, 将指数转换成正数时要注意溢出
 */
public class Pow_x_n {
    class Solution {
        public double myPow(double x, int n) {
            long nCopy = (long)n;
            if (nCopy < 0) {
                nCopy = -nCopy;
            }
            double result = 1;
            while (nCopy != 0) {
                if ((nCopy & 1) == 1) {
                    result *= x;
                }
                x *= x;
                nCopy >>= 1;
            }
            return n > 0 ? result : 1 / result;
        }
    }
}
