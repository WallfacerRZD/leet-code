import java.util.*;

/**
 * @author WallfacerRZD
 * @date 2018/7/24 22:14
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            Set<String> skip = new HashSet<>(Arrays.asList(".", "", ".."));
            Deque<String> stack = new LinkedList<>();
            for (String str : path.split("/")) {
                if ("..".equals(str) && !stack.isEmpty()) {
                    stack.pollLast();
                } else if (!skip.contains(str)) {
                    stack.offerLast(str);
                }
            }
            StringBuilder result = new StringBuilder();
            for (String str : stack) {
                result.append("/").append(str);
            }
            return stack.isEmpty() ? "/" : result.toString();
        }
    }

    public static void main(String[] args) {
        new SimplifyPath().new Solution().simplifyPath("");
    }
}
