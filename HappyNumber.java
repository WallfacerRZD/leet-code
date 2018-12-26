import java.util.HashSet;
import java.util.Set;

/**
 * @author WallfacerRZD
 * @date 2018/12/26 12:03
 */
public class HappyNumber {
    /**
     * Floyd Cycle
     */
    static class Solution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;
            do {
                slow = getSquareSum(slow);
                if (slow == 1) {
                    return true;
                }
                fast = getSquareSum(fast);
                fast = getSquareSum(fast);
            } while (fast != slow);
            return false;
        }

        private int getSquareSum(int n) {
            int nCopy = n;
            int squareSum = 0;
            while (nCopy != 0) {
                int digit = nCopy % 10;
                squareSum += digit * digit;
                nCopy /= 10;
            }
            return squareSum;
        }
    }

    static class Solution1 {
        public boolean isHappy(int n) {
            int nCopy = n;
            Set<Integer> inLoop = new HashSet<>();
            while (inLoop.add(nCopy)) {
                nCopy = getSquareSum(nCopy);
                if (nCopy == 1) {
                    return true;
                }
            }
            return false;
        }

        private int getSquareSum(int n) {
            int nCopy = n;
            int squareSum = 0;
            while (nCopy != 0) {
                int digit = nCopy % 10;
                squareSum += digit * digit;
                nCopy /= 10;
            }
            return squareSum;
        }
    }
}
