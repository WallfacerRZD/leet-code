/**
 * @author WallfacerRZD
 * @date 2018/12/28 14:49
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    /**
     * 空间换时间
     */
    static class Solution {
        public int countPrimes(int n) {
            boolean[] notPrimes = new boolean[n];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (!notPrimes[i]) {
                    count++;
                    for (int j = 2; j * i < n; j++) {
                        notPrimes[i * j] = true;
                    }
                }
            }
            return count;
        }
    }

    /**
     * Time Limit Exceeded
     */
    static class Solution1 {
        public int countPrimes(int n) {
            int primeCount = 0;
            for (int i = 0; i < n; i++) {
                if (isPrime(i)) {
                    primeCount++;
                }
            }
            return primeCount;
        }

        private boolean isPrime(int x) {
            if (x <= 1) {
                return false;
            }
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
