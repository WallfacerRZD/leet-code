import java.util.ArrayList;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2019/1/6 15:18
 */
public class RestoreIPAddresses {
    /**
     * Goal
     * Choice
     * Constrain
     */
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            restoreIpAddresses(result, s, "", 0, 0);
            return result;
        }

        private void restoreIpAddresses(List<String> result, String s, String ipAddress, int digitStartIndex, int digitCount) {
            if (digitCount > 4) {
                return;
            }
            // Goal
            if (digitCount == 4 && digitStartIndex == s.length()) {
                result.add(ipAddress);
                return;
            }
            // Choice
            for (int digitLength = 1; digitLength < 4; digitLength++) {
                // constrain
                if (digitStartIndex + digitLength > s.length()) {
                    break;
                }
                String digit = s.substring(digitStartIndex, digitStartIndex + digitLength);
                // constrain
                boolean inValid = (digit.startsWith("0") && digit.length() > 1) ||
                        (digit.length() == 3 && Integer.parseInt(digit) > 255);
                if (inValid) {
                    continue;
                }
                restoreIpAddresses(result, s, ipAddress + digit + (digitCount == 3 ? "" : "."),
                                   digitStartIndex + digitLength, digitCount + 1);
            }
        }
    }
}
